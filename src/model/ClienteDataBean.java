package model;

public class ClienteDataBean {
	private String nome,cognome,residenza,documento_tipo,documento_ente,documento_numero,email,login,password;

	public ClienteDataBean(String nome, String cognome, String residenza,
			String documento_tipo, String documento_ente,
			String documento_numero, String email, String login, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.documento_tipo = documento_tipo;
		this.documento_ente = documento_ente;
		this.documento_numero = documento_numero;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public ClienteDataBean() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getDocumento_tipo() {
		return documento_tipo;
	}

	public void setDocumento_tipo(String documento_tipo) {
		this.documento_tipo = documento_tipo;
	}

	public String getDocumento_ente() {
		return documento_ente;
	}

	public void setDocumento_ente(String documento_ente) {
		this.documento_ente = documento_ente;
	}

	public String getDocumento_numero() {
		return documento_numero;
	}

	public void setDocumento_numero(String documento_numero) {
		this.documento_numero = documento_numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClienteDataBean [nome=" + nome + ", cognome=" + cognome
				+ ", residenza=" + residenza + ", documento_tipo="
				+ documento_tipo + ", documento_ente=" + documento_ente
				+ ", documento_numero=" + documento_numero + ", email=" + email
				+ ", login=" + login + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result
				+ ((documento_ente == null) ? 0 : documento_ente.hashCode());
		result = prime
				* result
				+ ((documento_numero == null) ? 0 : documento_numero.hashCode());
		result = prime * result
				+ ((documento_tipo == null) ? 0 : documento_tipo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((residenza == null) ? 0 : residenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDataBean other = (ClienteDataBean) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (documento_ente == null) {
			if (other.documento_ente != null)
				return false;
		} else if (!documento_ente.equals(other.documento_ente))
			return false;
		if (documento_numero == null) {
			if (other.documento_numero != null)
				return false;
		} else if (!documento_numero.equals(other.documento_numero))
			return false;
		if (documento_tipo == null) {
			if (other.documento_tipo != null)
				return false;
		} else if (!documento_tipo.equals(other.documento_tipo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (residenza == null) {
			if (other.residenza != null)
				return false;
		} else if (!residenza.equals(other.residenza))
			return false;
		return true;
	}
}