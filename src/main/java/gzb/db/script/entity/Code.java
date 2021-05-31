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
public class Code {
	private java.lang.Integer codeId;
	private java.lang.Integer codeAdminId;
	private java.lang.Integer codeScriptId;
	private java.lang.String codeText;
	private java.lang.Integer codeType;
	private java.lang.Integer codeTime;
	private java.lang.Integer codeState;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Code setCodeId(java.lang.Integer codeId) {
		this.codeId = codeId;
		return this;
	}
	public java.lang.Integer getCodeId() {
		return codeId;
	}
	public Code setCodeAdminId(java.lang.Integer codeAdminId) {
		this.codeAdminId = codeAdminId;
		return this;
	}
	public java.lang.Integer getCodeAdminId() {
		return codeAdminId;
	}
	public Code setCodeScriptId(java.lang.Integer codeScriptId) {
		this.codeScriptId = codeScriptId;
		return this;
	}
	public java.lang.Integer getCodeScriptId() {
		return codeScriptId;
	}
	public Code setCodeText(java.lang.String codeText) {
		this.codeText = codeText;
		return this;
	}
	public java.lang.String getCodeText() {
		return codeText;
	}
	public Code MD5CodeText() throws Exception{ 
		this.codeText = TextTool.textToMd5(this.codeText);
		return this;
	}
	public Code MD5CodeText(String iv) throws Exception{ 
		this.codeText = TextTool.textToMd5(this.codeText+iv);
		return this;
	}
	public Code AESCodeText(String pwd,String iv) throws Exception{ 
		this.codeText = TextTool.textAESEncoder(this.codeText, pwd, iv);
		return this;
	}
	public Code setCodeType(java.lang.Integer codeType) {
		this.codeType = codeType;
		return this;
	}
	public java.lang.Integer getCodeType() {
		return codeType;
	}
	public Code setCodeTime(java.lang.Integer codeTime) {
		this.codeTime = codeTime;
		return this;
	}
	public java.lang.Integer getCodeTime() {
		return codeTime;
	}
	public Code setCodeState(java.lang.Integer codeState) {
		this.codeState = codeState;
		return this;
	}
	public java.lang.Integer getCodeState() {
		return codeState;
	}
	public Code(){
	
	}
	public Code(java.lang.Integer codeId, java.lang.Integer codeAdminId, java.lang.Integer codeScriptId, java.lang.String codeText, java.lang.Integer codeType, java.lang.Integer codeTime, java.lang.Integer codeState){
		this.codeId=codeId;
		this.codeAdminId=codeAdminId;
		this.codeScriptId=codeScriptId;
		this.codeText=codeText;
		this.codeType=codeType;
		this.codeTime=codeTime;
		this.codeState=codeState;
	}
	public Code(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "codeId");
			setCodeId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeAdminId");
			setCodeAdminId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeScriptId");
			setCodeScriptId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeText");
			setCodeText(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeType");
			setCodeType(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeTime");
			setCodeTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "codeState");
			setCodeState(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
		} 
	}
	public Code(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="codeId="+(codeId == null ? "" : codeId)+"\r\n";
		res+="codeAdminId="+(codeAdminId == null ? "" : codeAdminId)+"\r\n";
		res+="codeScriptId="+(codeScriptId == null ? "" : codeScriptId)+"\r\n";
		res+="codeText="+(codeText == null ? "" : codeText)+"\r\n";
		res+="codeType="+(codeType == null ? "" : codeType)+"\r\n";
		res+="codeTime="+(codeTime == null ? "" : codeTime)+"\r\n";
		res+="codeState="+(codeState == null ? "" : codeState)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"codeId\":\""+(codeId == null ? "" : codeId)+"\","+
		"\"codeAdminId\":\""+(codeAdminId == null ? "" : codeAdminId)+"\","+
		"\"codeScriptId\":\""+(codeScriptId == null ? "" : codeScriptId)+"\","+
		"\"codeText\":\""+(codeText == null ? "" : codeText)+"\","+
		"\"codeType\":\""+(codeType == null ? "" : codeType)+"\","+
		"\"codeTime\":\""+(codeTime == null ? "" : codeTime)+"\","+
		"\"codeState\":\""+(codeState == null ? "" : codeState)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Code> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Code> list =null;
		Code en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Code.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Code>();
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
				en=new Code();
				temp=rs.getString("codeId");
				if(temp!=null){
					en.setCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeAdminId");
				if(temp!=null){
					en.setCodeAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeScriptId");
				if(temp!=null){
					en.setCodeScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeText");
				if(temp!=null){
					en.setCodeText(new java.lang.String(temp));
				}
				temp=rs.getString("codeType");
				if(temp!=null){
					en.setCodeType(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeTime");
				if(temp!=null){
					en.setCodeTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeState");
				if(temp!=null){
					en.setCodeState(new java.lang.Integer(temp));
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
		List<Code> list_ret=new ArrayList<Code>();
		List<Code> list=query(); 
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
	public List<Code> query() throws SQLException{ 
		String sql="select * from Code where ";
		List<Object> para=new ArrayList<Object>();
		if(getCodeId() != null){
			sql+="codeId = ? and ";
			para.add(getCodeId());
		}
		if(getCodeAdminId() != null){
			sql+="codeAdminId = ? and ";
			para.add(getCodeAdminId());
		}
		if(getCodeScriptId() != null){
			sql+="codeScriptId = ? and ";
			para.add(getCodeScriptId());
		}
		if(getCodeText() != null){
			sql+="codeText = ? and ";
			para.add(getCodeText());
		}
		if(getCodeType() != null){
			sql+="codeType = ? and ";
			para.add(getCodeType());
		}
		if(getCodeTime() != null){
			sql+="codeTime = ? and ";
			para.add(getCodeTime());
		}
		if(getCodeState() != null){
			sql+="codeState = ? and ";
			para.add(getCodeState());
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
	public Code get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Code.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("codeId");
				if(temp!=null){
					setCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeAdminId");
				if(temp!=null){
					setCodeAdminId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeScriptId");
				if(temp!=null){
					setCodeScriptId(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeText");
				if(temp!=null){
					setCodeText(new java.lang.String(temp));
				}
				temp=rs.getString("codeType");
				if(temp!=null){
					setCodeType(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeTime");
				if(temp!=null){
					setCodeTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("codeState");
				if(temp!=null){
					setCodeState(new java.lang.Integer(temp));
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
	public Code get() throws SQLException{ 
		String sql="select * from Code where ";
		List<Object> para=new ArrayList<Object>();
		if(getCodeId() != null){
			sql+="codeId = ? and ";
			para.add(getCodeId());
		}
		if(getCodeAdminId() != null){
			sql+="codeAdminId = ? and ";
			para.add(getCodeAdminId());
		}
		if(getCodeScriptId() != null){
			sql+="codeScriptId = ? and ";
			para.add(getCodeScriptId());
		}
		if(getCodeText() != null){
			sql+="codeText = ? and ";
			para.add(getCodeText());
		}
		if(getCodeType() != null){
			sql+="codeType = ? and ";
			para.add(getCodeType());
		}
		if(getCodeTime() != null){
			sql+="codeTime = ? and ";
			para.add(getCodeTime());
		}
		if(getCodeState() != null){
			sql+="codeState = ? and ";
			para.add(getCodeState());
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
		String sql="insert into Code (codeId,codeAdminId,codeScriptId,codeText,codeType,codeTime,codeState) values(?,?,?,?,?,?,?)";
		sb.append("Code.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setCodeId(new Integer(DataBase.gzbCache.getIncr("db_CodeId_auto_id_incr").toString()));
			pstate.setObject(1,getCodeId());
			pstate.setObject(2,getCodeAdminId());
			pstate.setObject(3,getCodeScriptId());
			pstate.setObject(4,getCodeText());
			pstate.setObject(5,getCodeType());
			pstate.setObject(6,getCodeTime());
			pstate.setObject(7,getCodeState());
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
			setCodeId(new Code("select * from Code order by codeId desc limit 1",null).getCodeId());
			DataBase.gzbCache.set("db_CodeId_auto_id_incr", getCodeId());
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
		String sql="delete from code where codeId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Code.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getCodeId()); 
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
		String sql="update Code set codeId=?,codeAdminId=?,codeScriptId=?,codeText=?,codeType=?,codeTime=?,codeState=? where CodeId=?";
		sb.append("Code.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getCodeId()); 
			pstate.setObject(2,getCodeAdminId()); 
			pstate.setObject(3,getCodeScriptId()); 
			pstate.setObject(4,getCodeText()); 
			pstate.setObject(5,getCodeType()); 
			pstate.setObject(6,getCodeTime()); 
			pstate.setObject(7,getCodeState()); 
			pstate.setObject(8,getCodeId()); 
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
