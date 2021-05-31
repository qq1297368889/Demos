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
public class Script {
	private java.lang.Integer scriptId;
	private java.lang.Integer scriptAdminId;
	private java.lang.String scriptName;
	private java.lang.String scriptDesc;
	private java.lang.Integer scriptTime;
	private java.lang.Integer scriptState;
	private java.lang.String scriptPwd;
	private java.lang.String scriptIV;
	private java.lang.Integer scriptLvId;
	private java.lang.Integer scriptUpdTime;
	private java.lang.Integer scriptVisual;
	private java.lang.Integer scriptIndexVisual;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Script setScriptId(java.lang.Integer scriptId) {
		this.scriptId = scriptId;
		return this;
	}
	public java.lang.Integer getScriptId() {
		return scriptId;
	}
	public Script setScriptAdminId(java.lang.Integer scriptAdminId) {
		this.scriptAdminId = scriptAdminId;
		return this;
	}
	public java.lang.Integer getScriptAdminId() {
		return scriptAdminId;
	}
	public Script setScriptName(java.lang.String scriptName) {
		this.scriptName = scriptName;
		return this;
	}
	public java.lang.String getScriptName() {
		return scriptName;
	}
	public Script MD5ScriptName() throws Exception{ 
		this.scriptName = TextTool.textToMd5(this.scriptName);
		return this;
	}
	public Script MD5ScriptName(String iv) throws Exception{ 
		this.scriptName = TextTool.textToMd5(this.scriptName+iv);
		return this;
	}
	public Script AESScriptName(String pwd,String iv) throws Exception{ 
		this.scriptName = TextTool.textAESEncoder(this.scriptName, pwd, iv);
		return this;
	}
	public Script setScriptDesc(java.lang.String scriptDesc) {
		this.scriptDesc = scriptDesc;
		return this;
	}
	public java.lang.String getScriptDesc() {
		return scriptDesc;
	}
	public Script MD5ScriptDesc() throws Exception{ 
		this.scriptDesc = TextTool.textToMd5(this.scriptDesc);
		return this;
	}
	public Script MD5ScriptDesc(String iv) throws Exception{ 
		this.scriptDesc = TextTool.textToMd5(this.scriptDesc+iv);
		return this;
	}
	public Script AESScriptDesc(String pwd,String iv) throws Exception{ 
		this.scriptDesc = TextTool.textAESEncoder(this.scriptDesc, pwd, iv);
		return this;
	}
	public Script setScriptTime(java.lang.Integer scriptTime) {
		this.scriptTime = scriptTime;
		return this;
	}
	public java.lang.Integer getScriptTime() {
		return scriptTime;
	}
	public Script setScriptState(java.lang.Integer scriptState) {
		this.scriptState = scriptState;
		return this;
	}
	public java.lang.Integer getScriptState() {
		return scriptState;
	}
	public Script setScriptPwd(java.lang.String scriptPwd) {
		this.scriptPwd = scriptPwd;
		return this;
	}
	public java.lang.String getScriptPwd() {
		return scriptPwd;
	}
	public Script MD5ScriptPwd() throws Exception{ 
		this.scriptPwd = TextTool.textToMd5(this.scriptPwd);
		return this;
	}
	public Script MD5ScriptPwd(String iv) throws Exception{ 
		this.scriptPwd = TextTool.textToMd5(this.scriptPwd+iv);
		return this;
	}
	public Script AESScriptPwd(String pwd,String iv) throws Exception{ 
		this.scriptPwd = TextTool.textAESEncoder(this.scriptPwd, pwd, iv);
		return this;
	}
	public Script setScriptIV(java.lang.String scriptIV) {
		this.scriptIV = scriptIV;
		return this;
	}
	public java.lang.String getScriptIV() {
		return scriptIV;
	}
	public Script MD5ScriptIV() throws Exception{ 
		this.scriptIV = TextTool.textToMd5(this.scriptIV);
		return this;
	}
	public Script MD5ScriptIV(String iv) throws Exception{ 
		this.scriptIV = TextTool.textToMd5(this.scriptIV+iv);
		return this;
	}
	public Script AESScriptIV(String pwd,String iv) throws Exception{ 
		this.scriptIV = TextTool.textAESEncoder(this.scriptIV, pwd, iv);
		return this;
	}
	public Script setScriptLvId(java.lang.Integer scriptLvId) {
		this.scriptLvId = scriptLvId;
		return this;
	}
	public java.lang.Integer getScriptLvId() {
		return scriptLvId;
	}
	public Script setScriptUpdTime(java.lang.Integer scriptUpdTime) {
		this.scriptUpdTime = scriptUpdTime;
		return this;
	}
	public java.lang.Integer getScriptUpdTime() {
		return scriptUpdTime;
	}
	public Script setScriptVisual(java.lang.Integer scriptVisual) {
		this.scriptVisual = scriptVisual;
		return this;
	}
	public java.lang.Integer getScriptVisual() {
		return scriptVisual;
	}
	public Script setScriptIndexVisual(java.lang.Integer scriptIndexVisual) {
		this.scriptIndexVisual = scriptIndexVisual;
		return this;
	}
	public java.lang.Integer getScriptIndexVisual() {
		return scriptIndexVisual;
	}
	public Script(){
	
	}
	public Script(java.lang.Integer scriptId, java.lang.Integer scriptAdminId, java.lang.String scriptName, java.lang.String scriptDesc, java.lang.Integer scriptTime, java.lang.Integer scriptState, java.lang.String scriptPwd, java.lang.String scriptIV, java.lang.Integer scriptLvId, java.lang.Integer scriptUpdTime, java.lang.Integer scriptVisual, java.lang.Integer scriptIndexVisual){
		this.scriptId=scriptId;
		this.scriptAdminId=scriptAdminId;
		this.scriptName=scriptName;
		this.scriptDesc=scriptDesc;
		this.scriptTime=scriptTime;
		this.scriptState=scriptState;
		this.scriptPwd=scriptPwd;
		this.scriptIV=scriptIV;
		this.scriptLvId=scriptLvId;
		this.scriptUpdTime=scriptUpdTime;
		this.scriptVisual=scriptVisual;
		this.scriptIndexVisual=scriptIndexVisual;
	}
	public Script(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "scriptId");
			setScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptAdminId");
			setScriptAdminId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptName");
			setScriptName(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptDesc");
			setScriptDesc(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptTime");
			setScriptTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptState");
			setScriptState(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptPwd");
			setScriptPwd(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptIV");
			setScriptIV(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptLvId");
			setScriptLvId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptUpdTime");
			setScriptUpdTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptVisual");
			setScriptVisual(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptIndexVisual");
			setScriptIndexVisual(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Script(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="scriptId="+(scriptId == null ? "" : scriptId)+"\r\n";
		res+="scriptAdminId="+(scriptAdminId == null ? "" : scriptAdminId)+"\r\n";
		res+="scriptName="+(scriptName == null ? "" : scriptName)+"\r\n";
		res+="scriptDesc="+(scriptDesc == null ? "" : scriptDesc)+"\r\n";
		res+="scriptTime="+(scriptTime == null ? "" : scriptTime)+"\r\n";
		res+="scriptState="+(scriptState == null ? "" : scriptState)+"\r\n";
		res+="scriptPwd="+(scriptPwd == null ? "" : scriptPwd)+"\r\n";
		res+="scriptIV="+(scriptIV == null ? "" : scriptIV)+"\r\n";
		res+="scriptLvId="+(scriptLvId == null ? "" : scriptLvId)+"\r\n";
		res+="scriptUpdTime="+(scriptUpdTime == null ? "" : scriptUpdTime)+"\r\n";
		res+="scriptVisual="+(scriptVisual == null ? "" : scriptVisual)+"\r\n";
		res+="scriptIndexVisual="+(scriptIndexVisual == null ? "" : scriptIndexVisual)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"scriptId\":\""+(scriptId == null ? "" : scriptId)+"\","+
		"\"scriptAdminId\":\""+(scriptAdminId == null ? "" : scriptAdminId)+"\","+
		"\"scriptName\":\""+(scriptName == null ? "" : scriptName)+"\","+
		"\"scriptDesc\":\""+(scriptDesc == null ? "" : scriptDesc)+"\","+
		"\"scriptTime\":\""+(scriptTime == null ? "" : scriptTime)+"\","+
		"\"scriptState\":\""+(scriptState == null ? "" : scriptState)+"\","+
		"\"scriptPwd\":\""+(scriptPwd == null ? "" : scriptPwd)+"\","+
		"\"scriptIV\":\""+(scriptIV == null ? "" : scriptIV)+"\","+
		"\"scriptLvId\":\""+(scriptLvId == null ? "" : scriptLvId)+"\","+
		"\"scriptUpdTime\":\""+(scriptUpdTime == null ? "" : scriptUpdTime)+"\","+
		"\"scriptVisual\":\""+(scriptVisual == null ? "" : scriptVisual)+"\","+
		"\"scriptIndexVisual\":\""+(scriptIndexVisual == null ? "" : scriptIndexVisual)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Script> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Script> list =null;
		Script en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Script.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Script>();
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
				en=new Script();
				temp=rs.getString("scriptId");
				if(temp!=null){
					en.setScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptAdminId");
				if(temp!=null){
					en.setScriptAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptName");
				if(temp!=null){
					en.setScriptName(new java.lang.String(temp));
				}
				temp=rs.getString("scriptDesc");
				if(temp!=null){
					en.setScriptDesc(new java.lang.String(temp));
				}
				temp=rs.getString("scriptTime");
				if(temp!=null){
					en.setScriptTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptState");
				if(temp!=null){
					en.setScriptState(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptPwd");
				if(temp!=null){
					en.setScriptPwd(new java.lang.String(temp));
				}
				temp=rs.getString("scriptIV");
				if(temp!=null){
					en.setScriptIV(new java.lang.String(temp));
				}
				temp=rs.getString("scriptLvId");
				if(temp!=null){
					en.setScriptLvId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptUpdTime");
				if(temp!=null){
					en.setScriptUpdTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisual");
				if(temp!=null){
					en.setScriptVisual(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptIndexVisual");
				if(temp!=null){
					en.setScriptIndexVisual(new java.lang.Integer(temp));
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
		List<Script> list_ret=new ArrayList<Script>();
		List<Script> list=query(); 
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
	public List<Script> query() throws SQLException{ 
		String sql="select * from Script where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptId() != null){
			sql+="scriptId = ? and ";
			para.add(getScriptId());
		}
		if(getScriptAdminId() != null){
			sql+="scriptAdminId = ? and ";
			para.add(getScriptAdminId());
		}
		if(getScriptName() != null){
			sql+="scriptName = ? and ";
			para.add(getScriptName());
		}
		if(getScriptDesc() != null){
			sql+="scriptDesc = ? and ";
			para.add(getScriptDesc());
		}
		if(getScriptTime() != null){
			sql+="scriptTime = ? and ";
			para.add(getScriptTime());
		}
		if(getScriptState() != null){
			sql+="scriptState = ? and ";
			para.add(getScriptState());
		}
		if(getScriptPwd() != null){
			sql+="scriptPwd = ? and ";
			para.add(getScriptPwd());
		}
		if(getScriptIV() != null){
			sql+="scriptIV = ? and ";
			para.add(getScriptIV());
		}
		if(getScriptLvId() != null){
			sql+="scriptLvId = ? and ";
			para.add(getScriptLvId());
		}
		if(getScriptUpdTime() != null){
			sql+="scriptUpdTime = ? and ";
			para.add(getScriptUpdTime());
		}
		if(getScriptVisual() != null){
			sql+="scriptVisual = ? and ";
			para.add(getScriptVisual());
		}
		if(getScriptIndexVisual() != null){
			sql+="scriptIndexVisual = ? and ";
			para.add(getScriptIndexVisual());
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
	public Script get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Script.get:").append(sql).append(";参数:"); 
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
			System.out.println(rs.getRow());
			long t2=new Date().getTime();
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			//rs.last();
			if(rs.getRow()==1){
				this.runState=true;
				temp=rs.getString("scriptId");
				if(temp!=null){
					setScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptAdminId");
				if(temp!=null){
					setScriptAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptName");
				if(temp!=null){
					setScriptName(new java.lang.String(temp));
				}
				temp=rs.getString("scriptDesc");
				if(temp!=null){
					setScriptDesc(new java.lang.String(temp));
				}
				temp=rs.getString("scriptTime");
				if(temp!=null){
					setScriptTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptState");
				if(temp!=null){
					setScriptState(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptPwd");
				if(temp!=null){
					setScriptPwd(new java.lang.String(temp));
				}
				temp=rs.getString("scriptIV");
				if(temp!=null){
					setScriptIV(new java.lang.String(temp));
				}
				temp=rs.getString("scriptLvId");
				if(temp!=null){
					setScriptLvId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptUpdTime");
				if(temp!=null){
					setScriptUpdTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptVisual");
				if(temp!=null){
					setScriptVisual(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptIndexVisual");
				if(temp!=null){
					setScriptIndexVisual(new java.lang.Integer(temp));
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
	public Script get() throws SQLException{ 
		String sql="select * from Script where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptId() != null){
			sql+="scriptId = ? and ";
			para.add(getScriptId());
		}
		if(getScriptAdminId() != null){
			sql+="scriptAdminId = ? and ";
			para.add(getScriptAdminId());
		}
		if(getScriptName() != null){
			sql+="scriptName = ? and ";
			para.add(getScriptName());
		}
		if(getScriptDesc() != null){
			sql+="scriptDesc = ? and ";
			para.add(getScriptDesc());
		}
		if(getScriptTime() != null){
			sql+="scriptTime = ? and ";
			para.add(getScriptTime());
		}
		if(getScriptState() != null){
			sql+="scriptState = ? and ";
			para.add(getScriptState());
		}
		if(getScriptPwd() != null){
			sql+="scriptPwd = ? and ";
			para.add(getScriptPwd());
		}
		if(getScriptIV() != null){
			sql+="scriptIV = ? and ";
			para.add(getScriptIV());
		}
		if(getScriptLvId() != null){
			sql+="scriptLvId = ? and ";
			para.add(getScriptLvId());
		}
		if(getScriptUpdTime() != null){
			sql+="scriptUpdTime = ? and ";
			para.add(getScriptUpdTime());
		}
		if(getScriptVisual() != null){
			sql+="scriptVisual = ? and ";
			para.add(getScriptVisual());
		}
		if(getScriptIndexVisual() != null){
			sql+="scriptIndexVisual = ? and ";
			para.add(getScriptIndexVisual());
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
		String sql="insert into Script (scriptId,scriptAdminId,scriptName,scriptDesc,scriptTime,scriptState,scriptPwd,scriptIV,scriptLvId,scriptUpdTime,scriptVisual,scriptIndexVisual) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		sb.append("Script.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setScriptId(new Integer(DataBase.gzbCache.getIncr("db_ScriptId_auto_id_incr").toString()));
			pstate.setObject(1,getScriptId());
			pstate.setObject(2,getScriptAdminId());
			pstate.setObject(3,getScriptName());
			pstate.setObject(4,getScriptDesc());
			pstate.setObject(5,getScriptTime());
			pstate.setObject(6,getScriptState());
			pstate.setObject(7,getScriptPwd());
			pstate.setObject(8,getScriptIV());
			pstate.setObject(9,getScriptLvId());
			pstate.setObject(10,getScriptUpdTime());
			pstate.setObject(11,getScriptVisual());
			pstate.setObject(12,getScriptIndexVisual());
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
			setScriptId(new Script("select * from Script order by scriptId desc limit 1",null).getScriptId());
			DataBase.gzbCache.set("db_ScriptId_auto_id_incr", getScriptId());
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
		String sql="delete from script where scriptId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Script.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptId()); 
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
		String sql="update Script set scriptId=?,scriptAdminId=?,scriptName=?,scriptDesc=?,scriptTime=?,scriptState=?,scriptPwd=?,scriptIV=?,scriptLvId=?,scriptUpdTime=?,scriptVisual=?,scriptIndexVisual=? where ScriptId=?";
		sb.append("Script.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptId()); 
			pstate.setObject(2,getScriptAdminId()); 
			pstate.setObject(3,getScriptName()); 
			pstate.setObject(4,getScriptDesc()); 
			pstate.setObject(5,getScriptTime()); 
			pstate.setObject(6,getScriptState()); 
			pstate.setObject(7,getScriptPwd()); 
			pstate.setObject(8,getScriptIV()); 
			pstate.setObject(9,getScriptLvId()); 
			pstate.setObject(10,getScriptUpdTime()); 
			pstate.setObject(11,getScriptVisual()); 
			pstate.setObject(12,getScriptIndexVisual()); 
			pstate.setObject(13,getScriptId()); 
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
