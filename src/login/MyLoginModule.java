package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import util.ReservedReader;

public class MyLoginModule implements LoginModule {

	private CallbackHandler callbackHandler;
	private Subject subject;

	private UserPrincipal userPrincipal;
	private RolePrincipal rolePrincipal;

	private String username;
	private char[] password = null;
	private boolean debug;
	private boolean loginSucceeded;
	private boolean commitSucceeded;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;

		debug = "true".equalsIgnoreCase((String) options.get("debug"));
	}

	@Override
	public boolean login() throws LoginException {

		if (callbackHandler == null) {
			throw new LoginException("Error: no CallbackHandler available "
					+ "to garner authentication information from the user");
		}

		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("username");
		callbacks[1] = new PasswordCallback("password: ", false);

		try {
			callbackHandler.handle(callbacks);
			username = ((NameCallback) callbacks[0]).getName();
			password = ((PasswordCallback) callbacks[1]).getPassword();

			if (debug) {
				// LOGGER.debug("Username :" + username);
				// LOGGER.debug("Password : " + password);
			}
			if (username == null || password == null) {
				// LOGGER.error("Callback handler does not return login data properly");
				throw new LoginException(
						"Callback handler does not return login data properly");
			}
			if (isValidUser()) { // validate user.
				loginSucceeded = true;
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}

		return false;
	}

	private Connection getConnection() throws LoginException {
		ReservedReader r= new ReservedReader(MyLoginModule.class, "credential.txt", "=>");
		System.out.println("*********" + r.getValue("url")
				+ r.getValue("username") + r.getValue("password"));
		Connection con = null;
		try {
			// loading driver

			Class.forName(r.getValue("driver").replace(" ", "")).newInstance();
			con = DriverManager.getConnection(r.getValue("url")
					.replace(" ", ""), r.getValue("username").replace(" ", ""),
					r.getValue("password").replace(" ", ""));
		} catch (Exception e) {
			// LOGGER.error("Error when creating database connection" + e);
			e.printStackTrace();
		}
		return con;
	}

	private boolean isValidUser() {
		String sql = "select login from Cliente where Cliente.login=? and Cliente.password=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, new String(password));

			rs = stmt.executeQuery();

			if (rs.next()) { // User exist with the given user name and
								// password.
				return true;
			}
		} catch (Exception e) {
			// LOGGER.error("Error when loading user from the database " + e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// LOGGER.error("Error when closing result set." + e);
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// LOGGER.error("Error when closing statement." + e);
			}
			try {
				con.close();
			} catch (SQLException e) {
				// LOGGER.error("Error when closing connection." + e);
			}
		}
		return false;
	}

	@Override
	public boolean commit() throws LoginException {

		if (loginSucceeded == false) {
			return false;
		} else {
			userPrincipal = new UserPrincipal(username);
			if (!subject.getPrincipals().contains(userPrincipal)) {
				subject.getPrincipals().add(userPrincipal);
				// LOGGER.debug("User principal added:" + userPrincipal);
			}

			// populate subject with roles.
			List<String> roles = getRoles();
			for (String role : roles) {
				RolePrincipal rolePrincipal = new RolePrincipal(role);
				if (!subject.getPrincipals().contains(rolePrincipal)) {
					subject.getPrincipals().add(rolePrincipal);
					// LOGGER.debug("Role principal added: " + rolePrincipal);
				}
			}

			commitSucceeded = true;
			// LOGGER.info("Login subject were successfully populated with principals and roles");
			return true;
		}

	}

	private List<String> getRoles() {
		List<String> roleList = new ArrayList<String>();
		roleList.add("client");
		
		return roleList;
	}

	@Override
	public boolean abort() throws LoginException {
		if (this.loginSucceeded == false) {
			return false;
		} else if (this.loginSucceeded == true && commitSucceeded == false) {
			this.loginSucceeded = false;
			username = null;
			if (password != null) {
				password = null;
			}
			userPrincipal = null;
		} else {
			logout();
		}
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(userPrincipal);
		subject.getPrincipals().remove(rolePrincipal);

		loginSucceeded = false;
		commitSucceeded = loginSucceeded;

		username = null;
		password = null;

		userPrincipal = null;
		rolePrincipal = null;

		return true;
	}

}