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
public class Reccode {
	private java.lang.Integer recCodeId;
	private java.lang.Integer recCodeAdminId;
	private java.lang.Integer recCodeScriptId;
	private java.lang.String recCodeKey;
	private java.lang.Integer recCodeVal;
	private java.lang.Integer recCodeLoginTime;
	private java.lang.Integer recCodeState;
	private java.lang.Integer recCodeAddTime;
	private java.lang.Integer recCodeStartTime;
	private java.lang.Integer recCodeEndTime;
	private java.lang.Integer recCodePrice;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Reccode setRecCodeId(java.lang.Integer recCodeId) {
		this.recCodeId = recCodeId;
		return this;
	}
	public java.lang.Integer getRecCodeId() {
		return recCodeId;
	}
	public Reccode setRecCodeAdminId(java.lang.Integer recCodeAdminId) {
		this.recCodeAdminId = recCodeAdminId;
		return this;
	}
	public java.lang.Integer getRecCodeAdminId() {
		return recCodeAdminId;
	}
	public Reccode setRecCodeScriptId(java.lang.Integer recCodeScriptId) {
		this.recCodeScriptId = recCodeScriptId;
		return this;
	}
	public java.lang.Integer getRecCodeScriptId() {
		return recCodeScriptId;
	}
	public Reccode setRecCodeKey(java.lang.String recCodeKey) {
		this.recCodeKey = recCodeKey;
		return this;
	}
	public java.lang.String getRecCodeKey() {
		return recCodeKey;
	}
	public Reccode MD5RecCodeKey() throws Exception{ 
		this.recCodeKey = TextTool.textToMd5(this.recCodeKey);
		return this;
	}
	public Reccode MD5RecCodeKey(String iv) throws Exception{ 
		this.recCodeKey = TextTool.textToMd5(this.recCodeKey+iv);
		return this;
	}
	public Reccode AESRecCodeKey(String pwd,String iv) throws Exception{ 
		this.recCodeKey = TextTool.textAESEncoder(this.recCodeKey, pwd, iv);
		return this;
	}
	public Reccode setRecCodeVal(java.lang.Integer recCodeVal) {
		this.recCodeVal = recCodeVal;
		return this;
	}
	public java.lang.Integer getRecCodeVal() {
		return recCodeVal;
	}
	public Reccode setRecCodeLoginTime(java.lang.Integer recCodeLoginTime) {
		this.recCodeLoginTime = recCodeLoginTime;
		return this;
	}
	public java.lang.Integer getRecCodeLoginTime() {
		return recCodeLoginTime;
	}
	public Reccode setRecCodeState(java.lang.Integer recCodeState) {
		this.recCodeState = recCodeState;
		return this;
	}
	public java.lang.Integer getRecCodeState() {
		return recCodeState;
	}
	public Reccode setRecCodeAddTime(java.lang.Integer recCodeAddTime) {
		this.recCodeAddTime = recCodeAddTime;
		return this;
	}
	public java.lang.Integer getRecCodeAddTime() {
		return recCodeAddTime;
	}
	public Reccode setRecCodeStartTime(java.lang.Integer recCodeStartTime) {
		this.recCodeStartTime = recCodeStartTime;
		return this;
	}
	public java.lang.Integer getRecCodeStartTime() {
		return recCodeStartTime;
	}
	public Reccode setRecCodeEndTime(java.lang.Integer recCodeEndTime) {
		this.recCodeEndTime = recCodeEndTime;
		return this;
	}
	public java.lang.Integer getRecCodeEndTime() {
		return recCodeEndTime;
	}
	public Reccode setRecCodePrice(java.lang.Integer recCodePrice) {
		this.recCodePrice = recCodePrice;
		return this;
	}
	public java.lang.Integer getRecCodePrice() {
		return recCodePrice;
	}
	public Reccode(){
	
	}
	public Reccode(java.lang.Integer recCodeId, java.lang.Integer recCodeAdminId, java.lang.Integer recCodeScriptId, java.lang.String recCodeKey, java.lang.Integer recCodeVal, java.lang.Integer recCodeLoginTime, java.lang.Integer recCodeState, java.lang.Integer recCodeAddTime, java.lang.Integer recCodeStartTime, java.lang.Integer recCodeEndTime, java.lang.Integer recCodePrice){
		this.recCodeId=recCodeId;
		this.recCodeAdminId=recCodeAdminId;
		this.recCodeScriptId=recCodeScriptId;
		this.recCodeKey=recCodeKey;
		this.recCodeVal=recCodeVal;
		this.recCodeLoginTime=recCodeLoginTime;
		this.recCodeState=recCodeState;
		this.recCodeAddTime=recCodeAddTime;
		this.recCodeStartTime=recCodeStartTime;
		this.recCodeEndTime=recCodeEndTime;
		this.recCodePrice=recCodePrice;
	}
	public Reccode(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "recCodeId");
			setRecCodeId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeAdminId");
			setRecCodeAdminId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeScriptId");
			setRecCodeScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeKey");
			setRecCodeKey(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeVal");
			setRecCodeVal(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeLoginTime");
			setRecCodeLoginTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeState");
			setRecCodeState(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeAddTime");
			setRecCodeAddTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeStartTime");
			setRecCodeStartTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodeEndTime");
			setRecCodeEndTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "recCodePrice");
			setRecCodePrice(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Reccode(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="recCodeId="+(recCodeId == null ? "" : recCodeId)+"\r\n";
		res+="recCodeAdminId="+(recCodeAdminId == null ? "" : recCodeAdminId)+"\r\n";
		res+="recCodeScriptId="+(recCodeScriptId == null ? "" : recCodeScriptId)+"\r\n";
		res+="recCodeKey="+(recCodeKey == null ? "" : recCodeKey)+"\r\n";
		res+="recCodeVal="+(recCodeVal == null ? "" : recCodeVal)+"\r\n";
		res+="recCodeLoginTime="+(recCodeLoginTime == null ? "" : recCodeLoginTime)+"\r\n";
		res+="recCodeState="+(recCodeState == null ? "" : recCodeState)+"\r\n";
		res+="recCodeAddTime="+(recCodeAddTime == null ? "" : recCodeAddTime)+"\r\n";
		res+="recCodeStartTime="+(recCodeStartTime == null ? "" : recCodeStartTime)+"\r\n";
		res+="recCodeEndTime="+(recCodeEndTime == null ? "" : recCodeEndTime)+"\r\n";
		res+="recCodePrice="+(recCodePrice == null ? "" : recCodePrice)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"recCodeId\":\""+(recCodeId == null ? "" : recCodeId)+"\","+
		"\"recCodeAdminId\":\""+(recCodeAdminId == null ? "" : recCodeAdminId)+"\","+
		"\"recCodeScriptId\":\""+(recCodeScriptId == null ? "" : recCodeScriptId)+"\","+
		"\"recCodeKey\":\""+(recCodeKey == null ? "" : recCodeKey)+"\","+
		"\"recCodeVal\":\""+(recCodeVal == null ? "" : recCodeVal)+"\","+
		"\"recCodeLoginTime\":\""+(recCodeLoginTime == null ? "" : recCodeLoginTime)+"\","+
		"\"recCodeState\":\""+(recCodeState == null ? "" : recCodeState)+"\","+
		"\"recCodeAddTime\":\""+(recCodeAddTime == null ? "" : recCodeAddTime)+"\","+
		"\"recCodeStartTime\":\""+(recCodeStartTime == null ? "" : recCodeStartTime)+"\","+
		"\"recCodeEndTime\":\""+(recCodeEndTime == null ? "" : recCodeEndTime)+"\","+
		"\"recCodePrice\":\""+(recCodePrice == null ? "" : recCodePrice)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Reccode> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Reccode> list =null;
		Reccode en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccode.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Reccode>();
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
				en=new Reccode();
				temp=rs.getString("recCodeId");
				if(temp!=null){
					en.setRecCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeAdminId");
				if(temp!=null){
					en.setRecCodeAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeScriptId");
				if(temp!=null){
					en.setRecCodeScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeKey");
				if(temp!=null){
					en.setRecCodeKey(new java.lang.String(temp));
				}
				temp=rs.getString("recCodeVal");
				if(temp!=null){
					en.setRecCodeVal(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLoginTime");
				if(temp!=null){
					en.setRecCodeLoginTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeState");
				if(temp!=null){
					en.setRecCodeState(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeAddTime");
				if(temp!=null){
					en.setRecCodeAddTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeStartTime");
				if(temp!=null){
					en.setRecCodeStartTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeEndTime");
				if(temp!=null){
					en.setRecCodeEndTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodePrice");
				if(temp!=null){
					en.setRecCodePrice(new java.lang.Integer(temp));
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
		List<Reccode> list_ret=new ArrayList<Reccode>();
		List<Reccode> list=query(); 
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
	public List<Reccode> query() throws SQLException{ 
		String sql="select * from Reccode where ";
		List<Object> para=new ArrayList<Object>();
		if(getRecCodeId() != null){
			sql+="recCodeId = ? and ";
			para.add(getRecCodeId());
		}
		if(getRecCodeAdminId() != null){
			sql+="recCodeAdminId = ? and ";
			para.add(getRecCodeAdminId());
		}
		if(getRecCodeScriptId() != null){
			sql+="recCodeScriptId = ? and ";
			para.add(getRecCodeScriptId());
		}
		if(getRecCodeKey() != null){
			sql+="recCodeKey = ? and ";
			para.add(getRecCodeKey());
		}
		if(getRecCodeVal() != null){
			sql+="recCodeVal = ? and ";
			para.add(getRecCodeVal());
		}
		if(getRecCodeLoginTime() != null){
			sql+="recCodeLoginTime = ? and ";
			para.add(getRecCodeLoginTime());
		}
		if(getRecCodeState() != null){
			sql+="recCodeState = ? and ";
			para.add(getRecCodeState());
		}
		if(getRecCodeAddTime() != null){
			sql+="recCodeAddTime = ? and ";
			para.add(getRecCodeAddTime());
		}
		if(getRecCodeStartTime() != null){
			sql+="recCodeStartTime = ? and ";
			para.add(getRecCodeStartTime());
		}
		if(getRecCodeEndTime() != null){
			sql+="recCodeEndTime = ? and ";
			para.add(getRecCodeEndTime());
		}
		if(getRecCodePrice() != null){
			sql+="recCodePrice = ? and ";
			para.add(getRecCodePrice());
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
	public Reccode get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccode.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("recCodeId");
				if(temp!=null){
					setRecCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeAdminId");
				if(temp!=null){
					setRecCodeAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeScriptId");
				if(temp!=null){
					setRecCodeScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeKey");
				if(temp!=null){
					setRecCodeKey(new java.lang.String(temp));
				}
				temp=rs.getString("recCodeVal");
				if(temp!=null){
					setRecCodeVal(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeLoginTime");
				if(temp!=null){
					setRecCodeLoginTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeState");
				if(temp!=null){
					setRecCodeState(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeAddTime");
				if(temp!=null){
					setRecCodeAddTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeStartTime");
				if(temp!=null){
					setRecCodeStartTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodeEndTime");
				if(temp!=null){
					setRecCodeEndTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("recCodePrice");
				if(temp!=null){
					setRecCodePrice(new java.lang.Integer(temp));
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
	public Reccode get() throws SQLException{ 
		String sql="select * from Reccode where ";
		List<Object> para=new ArrayList<Object>();
		if(getRecCodeId() != null){
			sql+="recCodeId = ? and ";
			para.add(getRecCodeId());
		}
		if(getRecCodeAdminId() != null){
			sql+="recCodeAdminId = ? and ";
			para.add(getRecCodeAdminId());
		}
		if(getRecCodeScriptId() != null){
			sql+="recCodeScriptId = ? and ";
			para.add(getRecCodeScriptId());
		}
		if(getRecCodeKey() != null){
			sql+="recCodeKey = ? and ";
			para.add(getRecCodeKey());
		}
		if(getRecCodeVal() != null){
			sql+="recCodeVal = ? and ";
			para.add(getRecCodeVal());
		}
		if(getRecCodeLoginTime() != null){
			sql+="recCodeLoginTime = ? and ";
			para.add(getRecCodeLoginTime());
		}
		if(getRecCodeState() != null){
			sql+="recCodeState = ? and ";
			para.add(getRecCodeState());
		}
		if(getRecCodeAddTime() != null){
			sql+="recCodeAddTime = ? and ";
			para.add(getRecCodeAddTime());
		}
		if(getRecCodeStartTime() != null){
			sql+="recCodeStartTime = ? and ";
			para.add(getRecCodeStartTime());
		}
		if(getRecCodeEndTime() != null){
			sql+="recCodeEndTime = ? and ";
			para.add(getRecCodeEndTime());
		}
		if(getRecCodePrice() != null){
			sql+="recCodePrice = ? and ";
			para.add(getRecCodePrice());
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
		String sql="insert into Reccode (recCodeId,recCodeAdminId,recCodeScriptId,recCodeKey,recCodeVal,recCodeLoginTime,recCodeState,recCodeAddTime,recCodeStartTime,recCodeEndTime,recCodePrice) values(?,?,?,?,?,?,?,?,?,?,?)";
		sb.append("Reccode.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setRecCodeId(new Integer(DataBase.gzbCache.getIncr("db_RecCodeId_auto_id_incr").toString()));
			pstate.setObject(1,getRecCodeId());
			pstate.setObject(2,getRecCodeAdminId());
			pstate.setObject(3,getRecCodeScriptId());
			pstate.setObject(4,getRecCodeKey());
			pstate.setObject(5,getRecCodeVal());
			pstate.setObject(6,getRecCodeLoginTime());
			pstate.setObject(7,getRecCodeState());
			pstate.setObject(8,getRecCodeAddTime());
			pstate.setObject(9,getRecCodeStartTime());
			pstate.setObject(10,getRecCodeEndTime());
			pstate.setObject(11,getRecCodePrice());
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
			setRecCodeId(new Reccode("select * from Reccode order by recCodeId desc limit 1",null).getRecCodeId());
			DataBase.gzbCache.set("db_RecCodeId_auto_id_incr", getRecCodeId());
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
		String sql="delete from reccode where recCodeId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Reccode.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getRecCodeId()); 
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
		String sql="update Reccode set recCodeId=?,recCodeAdminId=?,recCodeScriptId=?,recCodeKey=?,recCodeVal=?,recCodeLoginTime=?,recCodeState=?,recCodeAddTime=?,recCodeStartTime=?,recCodeEndTime=?,recCodePrice=? where RecCodeId=?";
		sb.append("Reccode.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getRecCodeId()); 
			pstate.setObject(2,getRecCodeAdminId()); 
			pstate.setObject(3,getRecCodeScriptId()); 
			pstate.setObject(4,getRecCodeKey()); 
			pstate.setObject(5,getRecCodeVal()); 
			pstate.setObject(6,getRecCodeLoginTime()); 
			pstate.setObject(7,getRecCodeState()); 
			pstate.setObject(8,getRecCodeAddTime()); 
			pstate.setObject(9,getRecCodeStartTime()); 
			pstate.setObject(10,getRecCodeEndTime()); 
			pstate.setObject(11,getRecCodePrice()); 
			pstate.setObject(12,getRecCodeId()); 
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
