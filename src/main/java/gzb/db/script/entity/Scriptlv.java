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
public class Scriptlv {
	private java.lang.Integer scriptLvId;
	private java.lang.Integer scriptLvScriptId;
	private java.lang.Integer scriptLvAdminId;
	private java.lang.Integer scriptLvAesId;
	private java.lang.Integer scriptLvHtmlId;
	private java.lang.Integer scriptLvCodeId;
	private java.lang.Integer scriptLvTime;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Scriptlv setScriptLvId(java.lang.Integer scriptLvId) {
		this.scriptLvId = scriptLvId;
		return this;
	}
	public java.lang.Integer getScriptLvId() {
		return scriptLvId;
	}
	public Scriptlv setScriptLvScriptId(java.lang.Integer scriptLvScriptId) {
		this.scriptLvScriptId = scriptLvScriptId;
		return this;
	}
	public java.lang.Integer getScriptLvScriptId() {
		return scriptLvScriptId;
	}
	public Scriptlv setScriptLvAdminId(java.lang.Integer scriptLvAdminId) {
		this.scriptLvAdminId = scriptLvAdminId;
		return this;
	}
	public java.lang.Integer getScriptLvAdminId() {
		return scriptLvAdminId;
	}
	public Scriptlv setScriptLvAesId(java.lang.Integer scriptLvAesId) {
		this.scriptLvAesId = scriptLvAesId;
		return this;
	}
	public java.lang.Integer getScriptLvAesId() {
		return scriptLvAesId;
	}
	public Scriptlv setScriptLvHtmlId(java.lang.Integer scriptLvHtmlId) {
		this.scriptLvHtmlId = scriptLvHtmlId;
		return this;
	}
	public java.lang.Integer getScriptLvHtmlId() {
		return scriptLvHtmlId;
	}
	public Scriptlv setScriptLvCodeId(java.lang.Integer scriptLvCodeId) {
		this.scriptLvCodeId = scriptLvCodeId;
		return this;
	}
	public java.lang.Integer getScriptLvCodeId() {
		return scriptLvCodeId;
	}
	public Scriptlv setScriptLvTime(java.lang.Integer scriptLvTime) {
		this.scriptLvTime = scriptLvTime;
		return this;
	}
	public java.lang.Integer getScriptLvTime() {
		return scriptLvTime;
	}
	public Scriptlv(){
	
	}
	public Scriptlv(java.lang.Integer scriptLvId, java.lang.Integer scriptLvScriptId, java.lang.Integer scriptLvAdminId, java.lang.Integer scriptLvAesId, java.lang.Integer scriptLvHtmlId, java.lang.Integer scriptLvCodeId, java.lang.Integer scriptLvTime){
		this.scriptLvId=scriptLvId;
		this.scriptLvScriptId=scriptLvScriptId;
		this.scriptLvAdminId=scriptLvAdminId;
		this.scriptLvAesId=scriptLvAesId;
		this.scriptLvHtmlId=scriptLvHtmlId;
		this.scriptLvCodeId=scriptLvCodeId;
		this.scriptLvTime=scriptLvTime;
	}
	public Scriptlv(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "scriptLvId");
			setScriptLvId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvScriptId");
			setScriptLvScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvAdminId");
			setScriptLvAdminId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvAesId");
			setScriptLvAesId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvHtmlId");
			setScriptLvHtmlId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvCodeId");
			setScriptLvCodeId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvTime");
			setScriptLvTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Scriptlv(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="scriptLvId="+(scriptLvId == null ? "" : scriptLvId)+"\r\n";
		res+="scriptLvScriptId="+(scriptLvScriptId == null ? "" : scriptLvScriptId)+"\r\n";
		res+="scriptLvAdminId="+(scriptLvAdminId == null ? "" : scriptLvAdminId)+"\r\n";
		res+="scriptLvAesId="+(scriptLvAesId == null ? "" : scriptLvAesId)+"\r\n";
		res+="scriptLvHtmlId="+(scriptLvHtmlId == null ? "" : scriptLvHtmlId)+"\r\n";
		res+="scriptLvCodeId="+(scriptLvCodeId == null ? "" : scriptLvCodeId)+"\r\n";
		res+="scriptLvTime="+(scriptLvTime == null ? "" : scriptLvTime)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"scriptLvId\":\""+(scriptLvId == null ? "" : scriptLvId)+"\","+
		"\"scriptLvScriptId\":\""+(scriptLvScriptId == null ? "" : scriptLvScriptId)+"\","+
		"\"scriptLvAdminId\":\""+(scriptLvAdminId == null ? "" : scriptLvAdminId)+"\","+
		"\"scriptLvAesId\":\""+(scriptLvAesId == null ? "" : scriptLvAesId)+"\","+
		"\"scriptLvHtmlId\":\""+(scriptLvHtmlId == null ? "" : scriptLvHtmlId)+"\","+
		"\"scriptLvCodeId\":\""+(scriptLvCodeId == null ? "" : scriptLvCodeId)+"\","+
		"\"scriptLvTime\":\""+(scriptLvTime == null ? "" : scriptLvTime)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Scriptlv> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Scriptlv> list =null;
		Scriptlv en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptlv.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Scriptlv>();
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
				en=new Scriptlv();
				temp=rs.getString("scriptLvId");
				if(temp!=null){
					en.setScriptLvId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvScriptId");
				if(temp!=null){
					en.setScriptLvScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvAdminId");
				if(temp!=null){
					en.setScriptLvAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvAesId");
				if(temp!=null){
					en.setScriptLvAesId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvHtmlId");
				if(temp!=null){
					en.setScriptLvHtmlId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvCodeId");
				if(temp!=null){
					en.setScriptLvCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvTime");
				if(temp!=null){
					en.setScriptLvTime(new java.lang.Integer(temp));
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
		List<Scriptlv> list_ret=new ArrayList<Scriptlv>();
		List<Scriptlv> list=query(); 
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
	public List<Scriptlv> query() throws SQLException{ 
		String sql="select * from Scriptlv where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptLvId() != null){
			sql+="scriptLvId = ? and ";
			para.add(getScriptLvId());
		}
		if(getScriptLvScriptId() != null){
			sql+="scriptLvScriptId = ? and ";
			para.add(getScriptLvScriptId());
		}
		if(getScriptLvAdminId() != null){
			sql+="scriptLvAdminId = ? and ";
			para.add(getScriptLvAdminId());
		}
		if(getScriptLvAesId() != null){
			sql+="scriptLvAesId = ? and ";
			para.add(getScriptLvAesId());
		}
		if(getScriptLvHtmlId() != null){
			sql+="scriptLvHtmlId = ? and ";
			para.add(getScriptLvHtmlId());
		}
		if(getScriptLvCodeId() != null){
			sql+="scriptLvCodeId = ? and ";
			para.add(getScriptLvCodeId());
		}
		if(getScriptLvTime() != null){
			sql+="scriptLvTime = ? and ";
			para.add(getScriptLvTime());
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
	public Scriptlv get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptlv.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("scriptLvId");
				if(temp!=null){
					setScriptLvId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvScriptId");
				if(temp!=null){
					setScriptLvScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvAdminId");
				if(temp!=null){
					setScriptLvAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvAesId");
				if(temp!=null){
					setScriptLvAesId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvHtmlId");
				if(temp!=null){
					setScriptLvHtmlId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvCodeId");
				if(temp!=null){
					setScriptLvCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptLvTime");
				if(temp!=null){
					setScriptLvTime(new java.lang.Integer(temp));
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
	public Scriptlv get() throws SQLException{ 
		String sql="select * from Scriptlv where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptLvId() != null){
			sql+="scriptLvId = ? and ";
			para.add(getScriptLvId());
		}
		if(getScriptLvScriptId() != null){
			sql+="scriptLvScriptId = ? and ";
			para.add(getScriptLvScriptId());
		}
		if(getScriptLvAdminId() != null){
			sql+="scriptLvAdminId = ? and ";
			para.add(getScriptLvAdminId());
		}
		if(getScriptLvAesId() != null){
			sql+="scriptLvAesId = ? and ";
			para.add(getScriptLvAesId());
		}
		if(getScriptLvHtmlId() != null){
			sql+="scriptLvHtmlId = ? and ";
			para.add(getScriptLvHtmlId());
		}
		if(getScriptLvCodeId() != null){
			sql+="scriptLvCodeId = ? and ";
			para.add(getScriptLvCodeId());
		}
		if(getScriptLvTime() != null){
			sql+="scriptLvTime = ? and ";
			para.add(getScriptLvTime());
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
		String sql="insert into Scriptlv (scriptLvId,scriptLvScriptId,scriptLvAdminId,scriptLvAesId,scriptLvHtmlId,scriptLvCodeId,scriptLvTime) values(?,?,?,?,?,?,?)";
		sb.append("Scriptlv.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setScriptLvId(new Integer(DataBase.gzbCache.getIncr("db_ScriptLvId_auto_id_incr").toString()));
			pstate.setObject(1,getScriptLvId());
			pstate.setObject(2,getScriptLvScriptId());
			pstate.setObject(3,getScriptLvAdminId());
			pstate.setObject(4,getScriptLvAesId());
			pstate.setObject(5,getScriptLvHtmlId());
			pstate.setObject(6,getScriptLvCodeId());
			pstate.setObject(7,getScriptLvTime());
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
			setScriptLvId(new Scriptlv("select * from Scriptlv order by scriptLvId desc limit 1",null).getScriptLvId());
			DataBase.gzbCache.set("db_ScriptLvId_auto_id_incr", getScriptLvId());
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
		String sql="delete from scriptlv where scriptLvId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptlv.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptLvId()); 
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
		String sql="update Scriptlv set scriptLvId=?,scriptLvScriptId=?,scriptLvAdminId=?,scriptLvAesId=?,scriptLvHtmlId=?,scriptLvCodeId=?,scriptLvTime=? where ScriptLvId=?";
		sb.append("Scriptlv.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptLvId()); 
			pstate.setObject(2,getScriptLvScriptId()); 
			pstate.setObject(3,getScriptLvAdminId()); 
			pstate.setObject(4,getScriptLvAesId()); 
			pstate.setObject(5,getScriptLvHtmlId()); 
			pstate.setObject(6,getScriptLvCodeId()); 
			pstate.setObject(7,getScriptLvTime()); 
			pstate.setObject(8,getScriptLvId()); 
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
