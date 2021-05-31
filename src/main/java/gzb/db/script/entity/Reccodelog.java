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
public class Reccodelog {
	private java.lang.Integer recCodeLogId;
	private java.lang.String recCodeLogText;
	private java.lang.Integer recCodeLogType;
	private java.lang.Integer recCodeLogRid;
	private java.lang.Integer recCodeLogTime;
	private java.lang.String recCodeLogIp;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Reccodelog setRecCodeLogId(java.lang.Integer recCodeLogId) {
		this.recCodeLogId = recCodeLogId;
		return this;
	}
	public java.lang.Integer getRecCodeLogId() {
		return recCodeLogId;
	}
	public Reccodelog setRecCodeLogText(java.lang.String recCodeLogText) {
		this.recCodeLogText = recCodeLogText;
		return this;
	}
	public java.lang.String getRecCodeLogText() {
		return recCodeLogText;
	}
	public Reccodelog MD5RecCodeLogText() throws Exception{ 
		this.recCodeLogText = TextTool.textToMd5(this.recCodeLogText);
		return this;
	}
	public Reccodelog MD5RecCodeLogText(String iv) throws Exception{ 
		this.recCodeLogText = TextTool.textToMd5(this.recCodeLogText+iv);
		return this;
	}
	public Reccodelog AESRecCodeLogText(String pwd,String iv) throws Exception{ 
		this.recCodeLogText = TextTool.textAESEncoder(this.recCodeLogText, pwd, iv);
		return this;
	}
	public Reccodelog setRecCodeLogType(java.lang.Integer recCodeLogType) {
		this.recCodeLogType = recCodeLogType;
		return this;
	}
	public java.lang.Integer getRecCodeLogType() {
		return recCodeLogType;
	}
	public Reccodelog setRecCodeLogRid(java.lang.Integer recCodeLogRid) {
		this.recCodeLogRid = recCodeLogRid;
		return this;
	}
	public java.lang.Integer getRecCodeLogRid() {
		return recCodeLogRid;
	}
	public Reccodelog setRecCodeLogTime(java.lang.Integer recCodeLogTime) {
		this.recCodeLogTime = recCodeLogTime;
		return this;
	}
	public java.lang.Integer getRecCodeLogTime() {
		return recCodeLogTime;
	}
	public Reccodelog setRecCodeLogIp(java.lang.String recCodeLogIp) {
		this.recCodeLogIp = recCodeLogIp;
		return this;
	}
	public java.lang.String getRecCodeLogIp() {
		return recCodeLogIp;
	}
	public Reccodelog MD5RecCodeLogIp() throws Exception{ 
		this.recCodeLogIp = TextTool.textToMd5(this.recCodeLogIp);
		return this;
	}
	public Reccodelog MD5RecCodeLogIp(String iv) throws Exception{ 
		this.recCodeLogIp = TextTool.textToMd5(this.recCodeLogIp+iv);
		return this;
	}
	public Reccodelog AESRecCodeLogIp(String pwd,String iv) throws Exception{ 
		this.recCodeLogIp = TextTool.textAESEncoder(this.recCodeLogIp, pwd, iv);
		return this;
	}
	public Reccodelog(){
	
	}
	public Reccodelog(java.lang.Integer recCodeLogId, java.lang.String recCodeLogText, java.lang.Integer recCodeLogType, java.lang.Integer recCodeLogRid, java.lang.Integer recCodeLogTime, java.lang.String recCodeLogIp){
		this.recCodeLogId=recCodeLogId;
		this.recCodeLogText=recCodeLogText;
		this.recCodeLogType=recCodeLogType;
		this.recCodeLogRid=recCodeLogRid;
		this.recCodeLogTime=recCodeLogTime;
		this.recCodeLogIp=recCodeLogIp;
	}
	public Reccodelog(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "recCodeLogId");
			setRecCodeLogId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLogText");
			setRecCodeLogText(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLogType");
			setRecCodeLogType(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLogRid");
			setRecCodeLogRid(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLogTime");
			setRecCodeLogTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLogIp");
			setRecCodeLogIp(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
		} 
	}
	public Reccodelog(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="recCodeLogId="+(recCodeLogId == null ? "" : recCodeLogId)+"\r\n";
		res+="recCodeLogText="+(recCodeLogText == null ? "" : recCodeLogText)+"\r\n";
		res+="recCodeLogType="+(recCodeLogType == null ? "" : recCodeLogType)+"\r\n";
		res+="recCodeLogRid="+(recCodeLogRid == null ? "" : recCodeLogRid)+"\r\n";
		res+="recCodeLogTime="+(recCodeLogTime == null ? "" : recCodeLogTime)+"\r\n";
		res+="recCodeLogIp="+(recCodeLogIp == null ? "" : recCodeLogIp)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"recCodeLogId\":\""+(recCodeLogId == null ? "" : recCodeLogId)+"\","+
		"\"recCodeLogText\":\""+(recCodeLogText == null ? "" : recCodeLogText)+"\","+
		"\"recCodeLogType\":\""+(recCodeLogType == null ? "" : recCodeLogType)+"\","+
		"\"recCodeLogRid\":\""+(recCodeLogRid == null ? "" : recCodeLogRid)+"\","+
		"\"recCodeLogTime\":\""+(recCodeLogTime == null ? "" : recCodeLogTime)+"\","+
		"\"recCodeLogIp\":\""+(recCodeLogIp == null ? "" : recCodeLogIp)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Reccodelog> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Reccodelog> list =null;
		Reccodelog en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccodelog.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Reccodelog>();
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
				en=new Reccodelog();
				temp=rs.getString("recCodeLogId");
				if(temp!=null){
					en.setRecCodeLogId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogText");
				if(temp!=null){
					en.setRecCodeLogText(new java.lang.String(temp));
				}
				temp=rs.getString("recCodeLogType");
				if(temp!=null){
					en.setRecCodeLogType(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogRid");
				if(temp!=null){
					en.setRecCodeLogRid(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogTime");
				if(temp!=null){
					en.setRecCodeLogTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogIp");
				if(temp!=null){
					en.setRecCodeLogIp(new java.lang.String(temp));
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
		List<Reccodelog> list_ret=new ArrayList<Reccodelog>();
		List<Reccodelog> list=query(); 
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
	public List<Reccodelog> query() throws SQLException{ 
		String sql="select * from Reccodelog where ";
		List<Object> para=new ArrayList<Object>();
		if(getRecCodeLogId() != null){
			sql+="recCodeLogId = ? and ";
			para.add(getRecCodeLogId());
		}
		if(getRecCodeLogText() != null){
			sql+="recCodeLogText = ? and ";
			para.add(getRecCodeLogText());
		}
		if(getRecCodeLogType() != null){
			sql+="recCodeLogType = ? and ";
			para.add(getRecCodeLogType());
		}
		if(getRecCodeLogRid() != null){
			sql+="recCodeLogRid = ? and ";
			para.add(getRecCodeLogRid());
		}
		if(getRecCodeLogTime() != null){
			sql+="recCodeLogTime = ? and ";
			para.add(getRecCodeLogTime());
		}
		if(getRecCodeLogIp() != null){
			sql+="recCodeLogIp = ? and ";
			para.add(getRecCodeLogIp());
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
	public Reccodelog get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccodelog.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("recCodeLogId");
				if(temp!=null){
					setRecCodeLogId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogText");
				if(temp!=null){
					setRecCodeLogText(new java.lang.String(temp));
				}
				temp=rs.getString("recCodeLogType");
				if(temp!=null){
					setRecCodeLogType(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogRid");
				if(temp!=null){
					setRecCodeLogRid(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogTime");
				if(temp!=null){
					setRecCodeLogTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLogIp");
				if(temp!=null){
					setRecCodeLogIp(new java.lang.String(temp));
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
	public Reccodelog get() throws SQLException{ 
		String sql="select * from Reccodelog where ";
		List<Object> para=new ArrayList<Object>();
		if(getRecCodeLogId() != null){
			sql+="recCodeLogId = ? and ";
			para.add(getRecCodeLogId());
		}
		if(getRecCodeLogText() != null){
			sql+="recCodeLogText = ? and ";
			para.add(getRecCodeLogText());
		}
		if(getRecCodeLogType() != null){
			sql+="recCodeLogType = ? and ";
			para.add(getRecCodeLogType());
		}
		if(getRecCodeLogRid() != null){
			sql+="recCodeLogRid = ? and ";
			para.add(getRecCodeLogRid());
		}
		if(getRecCodeLogTime() != null){
			sql+="recCodeLogTime = ? and ";
			para.add(getRecCodeLogTime());
		}
		if(getRecCodeLogIp() != null){
			sql+="recCodeLogIp = ? and ";
			para.add(getRecCodeLogIp());
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
		String sql="insert into Reccodelog (recCodeLogId,recCodeLogText,recCodeLogType,recCodeLogRid,recCodeLogTime,recCodeLogIp) values(?,?,?,?,?,?)";
		sb.append("Reccodelog.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setRecCodeLogId(new Integer(DataBase.gzbCache.getIncr("db_RecCodeLogId_auto_id_incr").toString()));
			pstate.setObject(1,getRecCodeLogId());
			pstate.setObject(2,getRecCodeLogText());
			pstate.setObject(3,getRecCodeLogType());
			pstate.setObject(4,getRecCodeLogRid());
			pstate.setObject(5,getRecCodeLogTime());
			pstate.setObject(6,getRecCodeLogIp());
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
			setRecCodeLogId(new Reccodelog("select * from Reccodelog order by recCodeLogId desc limit 1",null).getRecCodeLogId());
			DataBase.gzbCache.set("db_RecCodeLogId_auto_id_incr", getRecCodeLogId());
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
		String sql="delete from reccodelog where recCodeLogId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccodelog.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getRecCodeLogId()); 
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
		String sql="update Reccodelog set recCodeLogId=?,recCodeLogText=?,recCodeLogType=?,recCodeLogRid=?,recCodeLogTime=?,recCodeLogIp=? where RecCodeLogId=?";
		sb.append("Reccodelog.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getRecCodeLogId()); 
			pstate.setObject(2,getRecCodeLogText()); 
			pstate.setObject(3,getRecCodeLogType()); 
			pstate.setObject(4,getRecCodeLogRid()); 
			pstate.setObject(5,getRecCodeLogTime()); 
			pstate.setObject(6,getRecCodeLogIp()); 
			pstate.setObject(7,getRecCodeLogId()); 
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
