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
public class Scriptvisits {
	private java.lang.Integer scriptVisitsId;
	private java.lang.Integer scriptVisitsScriptId;
	private java.lang.String scriptVisitsDay;
	private java.lang.Integer scriptVisitsTime;
	private java.lang.Integer scriptVisitsCodeId;
	private java.lang.String scriptVisitsIp;
	private java.lang.String scriptVisitsMsg;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Scriptvisits setScriptVisitsId(java.lang.Integer scriptVisitsId) {
		this.scriptVisitsId = scriptVisitsId;
		return this;
	}
	public java.lang.Integer getScriptVisitsId() {
		return scriptVisitsId;
	}
	public Scriptvisits setScriptVisitsScriptId(java.lang.Integer scriptVisitsScriptId) {
		this.scriptVisitsScriptId = scriptVisitsScriptId;
		return this;
	}
	public java.lang.Integer getScriptVisitsScriptId() {
		return scriptVisitsScriptId;
	}
	public Scriptvisits setScriptVisitsDay(java.lang.String scriptVisitsDay) {
		this.scriptVisitsDay = scriptVisitsDay;
		return this;
	}
	public java.lang.String getScriptVisitsDay() {
		return scriptVisitsDay;
	}
	public Scriptvisits MD5ScriptVisitsDay() throws Exception{ 
		this.scriptVisitsDay = TextTool.textToMd5(this.scriptVisitsDay);
		return this;
	}
	public Scriptvisits MD5ScriptVisitsDay(String iv) throws Exception{ 
		this.scriptVisitsDay = TextTool.textToMd5(this.scriptVisitsDay+iv);
		return this;
	}
	public Scriptvisits AESScriptVisitsDay(String pwd,String iv) throws Exception{ 
		this.scriptVisitsDay = TextTool.textAESEncoder(this.scriptVisitsDay, pwd, iv);
		return this;
	}
	public Scriptvisits setScriptVisitsTime(java.lang.Integer scriptVisitsTime) {
		this.scriptVisitsTime = scriptVisitsTime;
		return this;
	}
	public java.lang.Integer getScriptVisitsTime() {
		return scriptVisitsTime;
	}
	public Scriptvisits setScriptVisitsCodeId(java.lang.Integer scriptVisitsCodeId) {
		this.scriptVisitsCodeId = scriptVisitsCodeId;
		return this;
	}
	public java.lang.Integer getScriptVisitsCodeId() {
		return scriptVisitsCodeId;
	}
	public Scriptvisits setScriptVisitsIp(java.lang.String scriptVisitsIp) {
		this.scriptVisitsIp = scriptVisitsIp;
		return this;
	}
	public java.lang.String getScriptVisitsIp() {
		return scriptVisitsIp;
	}
	public Scriptvisits MD5ScriptVisitsIp() throws Exception{ 
		this.scriptVisitsIp = TextTool.textToMd5(this.scriptVisitsIp);
		return this;
	}
	public Scriptvisits MD5ScriptVisitsIp(String iv) throws Exception{ 
		this.scriptVisitsIp = TextTool.textToMd5(this.scriptVisitsIp+iv);
		return this;
	}
	public Scriptvisits AESScriptVisitsIp(String pwd,String iv) throws Exception{ 
		this.scriptVisitsIp = TextTool.textAESEncoder(this.scriptVisitsIp, pwd, iv);
		return this;
	}
	public Scriptvisits setScriptVisitsMsg(java.lang.String scriptVisitsMsg) {
		this.scriptVisitsMsg = scriptVisitsMsg;
		return this;
	}
	public java.lang.String getScriptVisitsMsg() {
		return scriptVisitsMsg;
	}
	public Scriptvisits MD5ScriptVisitsMsg() throws Exception{ 
		this.scriptVisitsMsg = TextTool.textToMd5(this.scriptVisitsMsg);
		return this;
	}
	public Scriptvisits MD5ScriptVisitsMsg(String iv) throws Exception{ 
		this.scriptVisitsMsg = TextTool.textToMd5(this.scriptVisitsMsg+iv);
		return this;
	}
	public Scriptvisits AESScriptVisitsMsg(String pwd,String iv) throws Exception{ 
		this.scriptVisitsMsg = TextTool.textAESEncoder(this.scriptVisitsMsg, pwd, iv);
		return this;
	}
	public Scriptvisits(){
	
	}
	public Scriptvisits(java.lang.Integer scriptVisitsId, java.lang.Integer scriptVisitsScriptId, java.lang.String scriptVisitsDay, java.lang.Integer scriptVisitsTime, java.lang.Integer scriptVisitsCodeId, java.lang.String scriptVisitsIp, java.lang.String scriptVisitsMsg){
		this.scriptVisitsId=scriptVisitsId;
		this.scriptVisitsScriptId=scriptVisitsScriptId;
		this.scriptVisitsDay=scriptVisitsDay;
		this.scriptVisitsTime=scriptVisitsTime;
		this.scriptVisitsCodeId=scriptVisitsCodeId;
		this.scriptVisitsIp=scriptVisitsIp;
		this.scriptVisitsMsg=scriptVisitsMsg;
	}
	public Scriptvisits(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "scriptVisitsId");
			setScriptVisitsId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsScriptId");
			setScriptVisitsScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsDay");
			setScriptVisitsDay(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsTime");
			setScriptVisitsTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsCodeId");
			setScriptVisitsCodeId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsIp");
			setScriptVisitsIp(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisitsMsg");
			setScriptVisitsMsg(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
		} 
	}
	public Scriptvisits(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="scriptVisitsId="+(scriptVisitsId == null ? "" : scriptVisitsId)+"\r\n";
		res+="scriptVisitsScriptId="+(scriptVisitsScriptId == null ? "" : scriptVisitsScriptId)+"\r\n";
		res+="scriptVisitsDay="+(scriptVisitsDay == null ? "" : scriptVisitsDay)+"\r\n";
		res+="scriptVisitsTime="+(scriptVisitsTime == null ? "" : scriptVisitsTime)+"\r\n";
		res+="scriptVisitsCodeId="+(scriptVisitsCodeId == null ? "" : scriptVisitsCodeId)+"\r\n";
		res+="scriptVisitsIp="+(scriptVisitsIp == null ? "" : scriptVisitsIp)+"\r\n";
		res+="scriptVisitsMsg="+(scriptVisitsMsg == null ? "" : scriptVisitsMsg)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"scriptVisitsId\":\""+(scriptVisitsId == null ? "" : scriptVisitsId)+"\","+
		"\"scriptVisitsScriptId\":\""+(scriptVisitsScriptId == null ? "" : scriptVisitsScriptId)+"\","+
		"\"scriptVisitsDay\":\""+(scriptVisitsDay == null ? "" : scriptVisitsDay)+"\","+
		"\"scriptVisitsTime\":\""+(scriptVisitsTime == null ? "" : scriptVisitsTime)+"\","+
		"\"scriptVisitsCodeId\":\""+(scriptVisitsCodeId == null ? "" : scriptVisitsCodeId)+"\","+
		"\"scriptVisitsIp\":\""+(scriptVisitsIp == null ? "" : scriptVisitsIp)+"\","+
		"\"scriptVisitsMsg\":\""+(scriptVisitsMsg == null ? "" : scriptVisitsMsg)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Scriptvisits> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Scriptvisits> list =null;
		Scriptvisits en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptvisits.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Scriptvisits>();
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
				en=new Scriptvisits();
				temp=rs.getString("scriptVisitsId");
				if(temp!=null){
					en.setScriptVisitsId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsScriptId");
				if(temp!=null){
					en.setScriptVisitsScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsDay");
				if(temp!=null){
					en.setScriptVisitsDay(new java.lang.String(temp));
				}
				temp=rs.getString("scriptVisitsTime");
				if(temp!=null){
					en.setScriptVisitsTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsCodeId");
				if(temp!=null){
					en.setScriptVisitsCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsIp");
				if(temp!=null){
					en.setScriptVisitsIp(new java.lang.String(temp));
				}
				temp=rs.getString("scriptVisitsMsg");
				if(temp!=null){
					en.setScriptVisitsMsg(new java.lang.String(temp));
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
		List<Scriptvisits> list_ret=new ArrayList<Scriptvisits>();
		List<Scriptvisits> list=query(); 
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
	public List<Scriptvisits> query() throws SQLException{ 
		String sql="select * from Scriptvisits where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptVisitsId() != null){
			sql+="scriptVisitsId = ? and ";
			para.add(getScriptVisitsId());
		}
		if(getScriptVisitsScriptId() != null){
			sql+="scriptVisitsScriptId = ? and ";
			para.add(getScriptVisitsScriptId());
		}
		if(getScriptVisitsDay() != null){
			sql+="scriptVisitsDay = ? and ";
			para.add(getScriptVisitsDay());
		}
		if(getScriptVisitsTime() != null){
			sql+="scriptVisitsTime = ? and ";
			para.add(getScriptVisitsTime());
		}
		if(getScriptVisitsCodeId() != null){
			sql+="scriptVisitsCodeId = ? and ";
			para.add(getScriptVisitsCodeId());
		}
		if(getScriptVisitsIp() != null){
			sql+="scriptVisitsIp = ? and ";
			para.add(getScriptVisitsIp());
		}
		if(getScriptVisitsMsg() != null){
			sql+="scriptVisitsMsg = ? and ";
			para.add(getScriptVisitsMsg());
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
	public Scriptvisits get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptvisits.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("scriptVisitsId");
				if(temp!=null){
					setScriptVisitsId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsScriptId");
				if(temp!=null){
					setScriptVisitsScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsDay");
				if(temp!=null){
					setScriptVisitsDay(new java.lang.String(temp));
				}
				temp=rs.getString("scriptVisitsTime");
				if(temp!=null){
					setScriptVisitsTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsCodeId");
				if(temp!=null){
					setScriptVisitsCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisitsIp");
				if(temp!=null){
					setScriptVisitsIp(new java.lang.String(temp));
				}
				temp=rs.getString("scriptVisitsMsg");
				if(temp!=null){
					setScriptVisitsMsg(new java.lang.String(temp));
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
	public Scriptvisits get() throws SQLException{ 
		String sql="select * from Scriptvisits where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptVisitsId() != null){
			sql+="scriptVisitsId = ? and ";
			para.add(getScriptVisitsId());
		}
		if(getScriptVisitsScriptId() != null){
			sql+="scriptVisitsScriptId = ? and ";
			para.add(getScriptVisitsScriptId());
		}
		if(getScriptVisitsDay() != null){
			sql+="scriptVisitsDay = ? and ";
			para.add(getScriptVisitsDay());
		}
		if(getScriptVisitsTime() != null){
			sql+="scriptVisitsTime = ? and ";
			para.add(getScriptVisitsTime());
		}
		if(getScriptVisitsCodeId() != null){
			sql+="scriptVisitsCodeId = ? and ";
			para.add(getScriptVisitsCodeId());
		}
		if(getScriptVisitsIp() != null){
			sql+="scriptVisitsIp = ? and ";
			para.add(getScriptVisitsIp());
		}
		if(getScriptVisitsMsg() != null){
			sql+="scriptVisitsMsg = ? and ";
			para.add(getScriptVisitsMsg());
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
		String sql="insert into Scriptvisits (scriptVisitsId,scriptVisitsScriptId,scriptVisitsDay,scriptVisitsTime,scriptVisitsCodeId,scriptVisitsIp,scriptVisitsMsg) values(?,?,?,?,?,?,?)";
		sb.append("Scriptvisits.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setScriptVisitsId(new Integer(DataBase.gzbCache.getIncr("db_ScriptVisitsId_auto_id_incr").toString()));
			pstate.setObject(1,getScriptVisitsId());
			pstate.setObject(2,getScriptVisitsScriptId());
			pstate.setObject(3,getScriptVisitsDay());
			pstate.setObject(4,getScriptVisitsTime());
			pstate.setObject(5,getScriptVisitsCodeId());
			pstate.setObject(6,getScriptVisitsIp());
			pstate.setObject(7,getScriptVisitsMsg());
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
			setScriptVisitsId(new Scriptvisits("select * from Scriptvisits order by scriptVisitsId desc limit 1",null).getScriptVisitsId());
			DataBase.gzbCache.set("db_ScriptVisitsId_auto_id_incr", getScriptVisitsId());
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
		String sql="delete from scriptvisits where scriptVisitsId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptvisits.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptVisitsId()); 
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
		String sql="update Scriptvisits set scriptVisitsId=?,scriptVisitsScriptId=?,scriptVisitsDay=?,scriptVisitsTime=?,scriptVisitsCodeId=?,scriptVisitsIp=?,scriptVisitsMsg=? where ScriptVisitsId=?";
		sb.append("Scriptvisits.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptVisitsId()); 
			pstate.setObject(2,getScriptVisitsScriptId()); 
			pstate.setObject(3,getScriptVisitsDay()); 
			pstate.setObject(4,getScriptVisitsTime()); 
			pstate.setObject(5,getScriptVisitsCodeId()); 
			pstate.setObject(6,getScriptVisitsIp()); 
			pstate.setObject(7,getScriptVisitsMsg()); 
			pstate.setObject(8,getScriptVisitsId()); 
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
