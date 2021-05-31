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
public class Scriptcase {
	private java.lang.Integer scriptCaseId;
	private java.lang.String scriptCaseImg;
	private java.lang.String scriptCaseText;
	private java.lang.Integer scriptCaseScriptId;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Scriptcase setScriptCaseId(java.lang.Integer scriptCaseId) {
		this.scriptCaseId = scriptCaseId;
		return this;
	}
	public java.lang.Integer getScriptCaseId() {
		return scriptCaseId;
	}
	public Scriptcase setScriptCaseImg(java.lang.String scriptCaseImg) {
		this.scriptCaseImg = scriptCaseImg;
		return this;
	}
	public java.lang.String getScriptCaseImg() {
		return scriptCaseImg;
	}
	public Scriptcase MD5ScriptCaseImg() throws Exception{ 
		this.scriptCaseImg = TextTool.textToMd5(this.scriptCaseImg);
		return this;
	}
	public Scriptcase MD5ScriptCaseImg(String iv) throws Exception{ 
		this.scriptCaseImg = TextTool.textToMd5(this.scriptCaseImg+iv);
		return this;
	}
	public Scriptcase AESScriptCaseImg(String pwd,String iv) throws Exception{ 
		this.scriptCaseImg = TextTool.textAESEncoder(this.scriptCaseImg, pwd, iv);
		return this;
	}
	public Scriptcase setScriptCaseText(java.lang.String scriptCaseText) {
		this.scriptCaseText = scriptCaseText;
		return this;
	}
	public java.lang.String getScriptCaseText() {
		return scriptCaseText;
	}
	public Scriptcase MD5ScriptCaseText() throws Exception{ 
		this.scriptCaseText = TextTool.textToMd5(this.scriptCaseText);
		return this;
	}
	public Scriptcase MD5ScriptCaseText(String iv) throws Exception{ 
		this.scriptCaseText = TextTool.textToMd5(this.scriptCaseText+iv);
		return this;
	}
	public Scriptcase AESScriptCaseText(String pwd,String iv) throws Exception{ 
		this.scriptCaseText = TextTool.textAESEncoder(this.scriptCaseText, pwd, iv);
		return this;
	}
	public Scriptcase setScriptCaseScriptId(java.lang.Integer scriptCaseScriptId) {
		this.scriptCaseScriptId = scriptCaseScriptId;
		return this;
	}
	public java.lang.Integer getScriptCaseScriptId() {
		return scriptCaseScriptId;
	}
	public Scriptcase(){
	
	}
	public Scriptcase(java.lang.Integer scriptCaseId, java.lang.String scriptCaseImg, java.lang.String scriptCaseText, java.lang.Integer scriptCaseScriptId){
		this.scriptCaseId=scriptCaseId;
		this.scriptCaseImg=scriptCaseImg;
		this.scriptCaseText=scriptCaseText;
		this.scriptCaseScriptId=scriptCaseScriptId;
	}
	public Scriptcase(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "scriptCaseId");
			setScriptCaseId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptCaseImg");
			setScriptCaseImg(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptCaseText");
			setScriptCaseText(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "scriptCaseScriptId");
			setScriptCaseScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Scriptcase(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="scriptCaseId="+(scriptCaseId == null ? "" : scriptCaseId)+"\r\n";
		res+="scriptCaseImg="+(scriptCaseImg == null ? "" : scriptCaseImg)+"\r\n";
		res+="scriptCaseText="+(scriptCaseText == null ? "" : scriptCaseText)+"\r\n";
		res+="scriptCaseScriptId="+(scriptCaseScriptId == null ? "" : scriptCaseScriptId)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"scriptCaseId\":\""+(scriptCaseId == null ? "" : scriptCaseId)+"\","+
		"\"scriptCaseImg\":\""+(scriptCaseImg == null ? "" : scriptCaseImg)+"\","+
		"\"scriptCaseText\":\""+(scriptCaseText == null ? "" : scriptCaseText)+"\","+
		"\"scriptCaseScriptId\":\""+(scriptCaseScriptId == null ? "" : scriptCaseScriptId)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Scriptcase> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Scriptcase> list =null;
		Scriptcase en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptcase.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Scriptcase>();
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
				en=new Scriptcase();
				temp=rs.getString("scriptCaseId");
				if(temp!=null){
					en.setScriptCaseId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptCaseImg");
				if(temp!=null){
					en.setScriptCaseImg(new java.lang.String(temp));
				}
				temp=rs.getString("scriptCaseText");
				if(temp!=null){
					en.setScriptCaseText(new java.lang.String(temp));
				}
				temp=rs.getString("scriptCaseScriptId");
				if(temp!=null){
					en.setScriptCaseScriptId(new java.lang.Integer(temp));
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
		List<Scriptcase> list_ret=new ArrayList<Scriptcase>();
		List<Scriptcase> list=query(); 
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
	public List<Scriptcase> query() throws SQLException{ 
		String sql="select * from Scriptcase where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptCaseId() != null){
			sql+="scriptCaseId = ? and ";
			para.add(getScriptCaseId());
		}
		if(getScriptCaseImg() != null){
			sql+="scriptCaseImg = ? and ";
			para.add(getScriptCaseImg());
		}
		if(getScriptCaseText() != null){
			sql+="scriptCaseText = ? and ";
			para.add(getScriptCaseText());
		}
		if(getScriptCaseScriptId() != null){
			sql+="scriptCaseScriptId = ? and ";
			para.add(getScriptCaseScriptId());
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
	public Scriptcase get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptcase.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("scriptCaseId");
				if(temp!=null){
					setScriptCaseId(new java.lang.Integer(temp));
				}
				temp=rs.getString("scriptCaseImg");
				if(temp!=null){
					setScriptCaseImg(new java.lang.String(temp));
				}
				temp=rs.getString("scriptCaseText");
				if(temp!=null){
					setScriptCaseText(new java.lang.String(temp));
				}
				temp=rs.getString("scriptCaseScriptId");
				if(temp!=null){
					setScriptCaseScriptId(new java.lang.Integer(temp));
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
	public Scriptcase get() throws SQLException{ 
		String sql="select * from Scriptcase where ";
		List<Object> para=new ArrayList<Object>();
		if(getScriptCaseId() != null){
			sql+="scriptCaseId = ? and ";
			para.add(getScriptCaseId());
		}
		if(getScriptCaseImg() != null){
			sql+="scriptCaseImg = ? and ";
			para.add(getScriptCaseImg());
		}
		if(getScriptCaseText() != null){
			sql+="scriptCaseText = ? and ";
			para.add(getScriptCaseText());
		}
		if(getScriptCaseScriptId() != null){
			sql+="scriptCaseScriptId = ? and ";
			para.add(getScriptCaseScriptId());
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
		String sql="insert into Scriptcase (scriptCaseId,scriptCaseImg,scriptCaseText,scriptCaseScriptId) values(?,?,?,?)";
		sb.append("Scriptcase.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setScriptCaseId(new Integer(DataBase.gzbCache.getIncr("db_ScriptCaseId_auto_id_incr").toString()));
			pstate.setObject(1,getScriptCaseId());
			pstate.setObject(2,getScriptCaseImg());
			pstate.setObject(3,getScriptCaseText());
			pstate.setObject(4,getScriptCaseScriptId());
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
			setScriptCaseId(new Scriptcase("select * from Scriptcase order by scriptCaseId desc limit 1",null).getScriptCaseId());
			DataBase.gzbCache.set("db_ScriptCaseId_auto_id_incr", getScriptCaseId());
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
		String sql="delete from scriptcase where scriptCaseId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Scriptcase.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptCaseId()); 
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
		String sql="update Scriptcase set scriptCaseId=?,scriptCaseImg=?,scriptCaseText=?,scriptCaseScriptId=? where ScriptCaseId=?";
		sb.append("Scriptcase.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getScriptCaseId()); 
			pstate.setObject(2,getScriptCaseImg()); 
			pstate.setObject(3,getScriptCaseText()); 
			pstate.setObject(4,getScriptCaseScriptId()); 
			pstate.setObject(5,getScriptCaseId()); 
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
