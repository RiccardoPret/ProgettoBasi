package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataBean;

public abstract class DataBeanGetStrategy {
	
	protected String queryName;
	protected List<Object> params;
	
	public DataBeanGetStrategy(String queryName, List<Object> params){
		this.queryName=queryName;
		this.params=params;
	}
	
	public DataBeanGetStrategy(){
		
	}
	
	public List<DataBean> getSelectedBeans() throws SQLException{
		List<DataBean> toRet=new ArrayList<DataBean>();
		String qText=Query.getInstance().getQuery(this.queryName);
		DatabaseDriver dbd=new DatabaseDriver();
		dbd.openConnection();
		PreparedStatement ps=dbd.getOpenedConnection().prepareStatement(qText);
		for(int i=0;i<this.params.size();i++){
			ps.setObject(i+1, this.params.get(i));
		}
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			toRet.add(this.buildDataBean(rs));
		}
		rs.getStatement().close();
		rs.close();
		dbd.closeConnection();
		return toRet;
	}

	protected abstract DataBean buildDataBean(ResultSet rs) throws SQLException;
	
}
