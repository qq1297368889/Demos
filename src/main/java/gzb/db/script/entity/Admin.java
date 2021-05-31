package gzb.db.script.entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import gzb.db.DataBase;
import gzb.tools.Log;
import gzb.tools.TextTool;
public class Admin {
	private java.lang.Integer adminId;
	private java.lang.String adminAcc;
	private java.lang.String adminPwd;
	private java.lang.Integer adminTime;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Admin setAdminId(java.lang.Integer adminId) {
		this.adminId = adminId;
		return this;
	}
	public java.lang.Integer getAdminId() {
		return adminId;
	}
	public Admin setAdminAcc(java.lang.String adminAcc) {
		this.adminAcc = adminAcc;
		return this;
	}
	public java.lang.String getAdminAcc() {
		return adminAcc;
	}
	public Admin MD5AdminAcc() throws Exception{ 
		this.adminAcc = TextTool.textToMd5(this.adminAcc);
		return this;
	}
	public Admin MD5AdminAcc(String iv) throws Exception{ 
		this.adminAcc = TextTool.textToMd5(this.adminAcc+iv);
		return this;
	}
	public Admin AESAdminAcc(String pwd,String iv) throws Exception{ 
		this.adminAcc = TextTool.textAESEncoder(this.adminAcc, pwd, iv);
		return this;
	}
	public Admin setAdminPwd(java.lang.String adminPwd) {
		this.adminPwd = adminPwd;
		return this;
	}
	public java.lang.String getAdminPwd() {
		return adminPwd;
	}
	public Admin MD5AdminPwd() throws Exception{ 
		this.adminPwd = TextTool.textToMd5(this.adminPwd);
		return this;
	}
	public Admin MD5AdminPwd(String iv) throws Exception{ 
		this.adminPwd = TextTool.textToMd5(this.adminPwd+iv);
		return this;
	}
	public Admin AESAdminPwd(String pwd,String iv) throws Exception{ 
		this.adminPwd = TextTool.textAESEncoder(this.adminPwd, pwd, iv);
		return this;
	}
	public Admin setAdminTime(java.lang.Integer adminTime) {
		this.adminTime = adminTime;
		return this;
	}
	public java.lang.Integer getAdminTime() {
		return adminTime;
	}
	public Admin(){
	
	}
	public Admin(java.lang.Integer adminId, java.lang.String adminAcc, java.lang.String adminPwd, java.lang.Integer adminTime){
		this.adminId=adminId;
		this.adminAcc=adminAcc;
		this.adminPwd=adminPwd;
		this.adminTime=adminTime;
	}
	public Admin(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "adminId");
			setAdminId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "adminAcc");
			setAdminAcc(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "adminPwd");
			setAdminPwd(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "adminTime");
			setAdminTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Admin(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="adminId="+(adminId == null ? "" : adminId)+"\r\n";
		res+="adminAcc="+(adminAcc == null ? "" : adminAcc)+"\r\n";
		res+="adminPwd="+(adminPwd == null ? "" : adminPwd)+"\r\n";
		res+="adminTime="+(adminTime == null ? "" : adminTime)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"adminId\":\""+(adminId == null ? "" : adminId)+"\","+
		"\"adminAcc\":\""+(adminAcc == null ? "" : adminAcc)+"\","+
		"\"adminPwd\":\""+(adminPwd == null ? "" : adminPwd)+"\","+
		"\"adminTime\":\""+(adminTime == null ? "" : adminTime)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Admin> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Admin> list =null;
		Admin en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Admin.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Admin>();
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			String temp="";
			for (int i = 0; i < para.length; i++) {
				sb.append(para[i]).append(",");
				pstate.setObject(i+1,para[i]); 
			}
			long t1=new Date().getTime();
			rs=pstate.executeQuery();
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			while (rs.next()) {  
				en=new Admin();
				temp=rs.getString("adminId");
				if(temp!=null){
					en.setAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("adminAcc");
				if(temp!=null){
					en.setAdminAcc(new java.lang.String(temp));
				}
				temp=rs.getString("adminPwd");
				if(temp!=null){
					en.setAdminPwd(new java.lang.String(temp));
				}
				temp=rs.getString("adminTime");
				if(temp!=null){
					en.setAdminTime(new java.lang.Integer(temp));
				}
				list.add(en);
			}
		} catch (Exception e) {
			Log.e(e,sb.toString());
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
		return list;
	}
	public gzb.tools.ListPage query(int page,int size) throws SQLException{
		List<Admin> list_ret=new ArrayList<Admin>();
		List<Admin> list=query(); 
		 for (int i=(page-1)*size;i < list.size(); i++) {
			 list_ret.add(list.get(i));
			 if(list_ret.size()== size){
				 break;
			 }
		}
		 gzb.tools.ListPage lp=new gzb.tools.ListPage();
		 lp.setCount(list.size());
		 lp.setLimit(size);
		 lp.setList(list_ret);
		 lp.setPage(page);
		 return lp;
	}
	public List<Admin> query() throws SQLException{ 
		String sql="select * from Admin where ";
		List<Object> para=new ArrayList<Object>();
		if(getAdminId() != null){
			sql+="adminId = ? and ";
			para.add(getAdminId());
		}
		if(getAdminAcc() != null){
			sql+="adminAcc = ? and ";
			para.add(getAdminAcc());
		}
		if(getAdminPwd() != null){
			sql+="adminPwd = ? and ";
			para.add(getAdminPwd());
		}
		if(getAdminTime() != null){
			sql+="adminTime = ? and ";
			para.add(getAdminTime());
		}
		if(sql.indexOf(" and ")>-1){
			sql=sql.substring(0,sql.length()-5);
		}else{
			sql=sql.substring(0,sql.length()-7);
		}  
		Object []obj=new Object[para.size()];
		for (int i = 0; i < para.size(); i++) {
			obj[i]=para.get(i);
		}
		return query(sql,obj);
	}
	public Admin get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Admin.get:").append(sql).append(";参数:"); 
		try {
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			String temp="";
			for (int i = 0; i < para.length; i++) {
				sb.append(para[i]).append(",");
				pstate.setObject(i+1,para[i]); 
			}
			long t1=new Date().getTime();
			rs=pstate.executeQuery();
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			rs.last();
			if(rs.getRow()==1){
				this.runState=true;
				rs.beforeFirst();
				rs.next();
				temp=rs.getString("adminId");
				if(temp!=null){
					setAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("adminAcc");
				if(temp!=null){
					setAdminAcc(new java.lang.String(temp));
				}
				temp=rs.getString("adminPwd");
				if(temp!=null){
					setAdminPwd(new java.lang.String(temp));
				}
				temp=rs.getString("adminTime");
				if(temp!=null){
					setAdminTime(new java.lang.Integer(temp));
				}
			}else{
				this.runState=false;
}
		} catch (Exception e) {
			Log.e(e,sb.toString());
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
		return this;
	}
	public Admin get() throws SQLException{ 
		String sql="select * from Admin where ";
		List<Object> para=new ArrayList<Object>();
		if(getAdminId() != null){
			sql+="adminId = ? and ";
			para.add(getAdminId());
		}
		if(getAdminAcc() != null){
			sql+="adminAcc = ? and ";
			para.add(getAdminAcc());
		}
		if(getAdminPwd() != null){
			sql+="adminPwd = ? and ";
			para.add(getAdminPwd());
		}
		if(getAdminTime() != null){
			sql+="adminTime = ? and ";
			para.add(getAdminTime());
		}
		if(sql.indexOf(" and ")>-1){
			sql=sql.substring(0,sql.length()-5);
		}else{
			sql=sql.substring(0,sql.length()-7);
		}  
		Object []obj=new Object[para.size()];
		for (int i = 0; i < para.size(); i++) {
			obj[i]=para.get(i);
		}
		return get(sql,obj);
	}
	public int save() throws Exception{
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		String sql="insert into Admin (adminId,adminAcc,adminPwd,adminTime) values(?,?,?,?)";
		sb.append("Admin.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setAdminId(new Integer(DataBase.gzbCache.getIncr("db_AdminId_auto_id_incr").toString()));
			pstate.setObject(1,getAdminId());
			pstate.setObject(2,getAdminAcc());
			pstate.setObject(3,getAdminPwd());
			pstate.setObject(4,getAdminTime());
			long t1=new Date().getTime();
			int res=pstate.executeUpdate();
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			return res;
		}catch(java.sql.SQLIntegrityConstraintViolationException e){
			e.printStackTrace();
			setAdminId(new Admin("select * from Admin order by adminId desc limit 1",null).getAdminId());
			DataBase.gzbCache.set("db_AdminId_auto_id_incr", getAdminId());
			return save();
		} catch (Exception e) {
			Log.e(e,sb.toString());
			throw e;
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
	}
	public int delete() throws Exception{
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		String sql="delete from admin where adminId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Admin.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getAdminId()); 
			long t1=new Date().getTime();
			int res=pstate.executeUpdate();
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			return res;
		} catch (Exception e) {
			Log.e(e,"sql:"+sql);
			throw e;
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
	}
	public int update() throws Exception{
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		String sql="update Admin set adminId=?,adminAcc=?,adminPwd=?,adminTime=? where AdminId=?";
		sb.append("Admin.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getAdminId()); 
			pstate.setObject(2,getAdminAcc()); 
			pstate.setObject(3,getAdminPwd()); 
			pstate.setObject(4,getAdminTime()); 
			pstate.setObject(5,getAdminId()); 
			long t1=new Date().getTime();
			int res=pstate.executeUpdate();
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			return res;
		} catch (Exception e) {
			Log.e(e,"sql:"+sql);
			throw e;
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
	}
}
