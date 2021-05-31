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
public class Indexinfo {
	private java.lang.Integer indexId;
	private java.lang.String indexTitle;
	private java.lang.String indexTitleImgUrl;
	private java.lang.String indexDesc;
	private java.lang.String indexKeywords;
	private java.lang.String indexPhone;
	private java.lang.String indexEm;
	private java.lang.String indexAddress;
	private java.lang.String indexQQ;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Indexinfo setIndexId(java.lang.Integer indexId) {
		this.indexId = indexId;
		return this;
	}
	public java.lang.Integer getIndexId() {
		return indexId;
	}
	public Indexinfo setIndexTitle(java.lang.String indexTitle) {
		this.indexTitle = indexTitle;
		return this;
	}
	public java.lang.String getIndexTitle() {
		return indexTitle;
	}
	public Indexinfo MD5IndexTitle() throws Exception{ 
		this.indexTitle = TextTool.textToMd5(this.indexTitle);
		return this;
	}
	public Indexinfo MD5IndexTitle(String iv) throws Exception{ 
		this.indexTitle = TextTool.textToMd5(this.indexTitle+iv);
		return this;
	}
	public Indexinfo AESIndexTitle(String pwd,String iv) throws Exception{ 
		this.indexTitle = TextTool.textAESEncoder(this.indexTitle, pwd, iv);
		return this;
	}
	public Indexinfo setIndexTitleImgUrl(java.lang.String indexTitleImgUrl) {
		this.indexTitleImgUrl = indexTitleImgUrl;
		return this;
	}
	public java.lang.String getIndexTitleImgUrl() {
		return indexTitleImgUrl;
	}
	public Indexinfo MD5IndexTitleImgUrl() throws Exception{ 
		this.indexTitleImgUrl = TextTool.textToMd5(this.indexTitleImgUrl);
		return this;
	}
	public Indexinfo MD5IndexTitleImgUrl(String iv) throws Exception{ 
		this.indexTitleImgUrl = TextTool.textToMd5(this.indexTitleImgUrl+iv);
		return this;
	}
	public Indexinfo AESIndexTitleImgUrl(String pwd,String iv) throws Exception{ 
		this.indexTitleImgUrl = TextTool.textAESEncoder(this.indexTitleImgUrl, pwd, iv);
		return this;
	}
	public Indexinfo setIndexDesc(java.lang.String indexDesc) {
		this.indexDesc = indexDesc;
		return this;
	}
	public java.lang.String getIndexDesc() {
		return indexDesc;
	}
	public Indexinfo MD5IndexDesc() throws Exception{ 
		this.indexDesc = TextTool.textToMd5(this.indexDesc);
		return this;
	}
	public Indexinfo MD5IndexDesc(String iv) throws Exception{ 
		this.indexDesc = TextTool.textToMd5(this.indexDesc+iv);
		return this;
	}
	public Indexinfo AESIndexDesc(String pwd,String iv) throws Exception{ 
		this.indexDesc = TextTool.textAESEncoder(this.indexDesc, pwd, iv);
		return this;
	}
	public Indexinfo setIndexKeywords(java.lang.String indexKeywords) {
		this.indexKeywords = indexKeywords;
		return this;
	}
	public java.lang.String getIndexKeywords() {
		return indexKeywords;
	}
	public Indexinfo MD5IndexKeywords() throws Exception{ 
		this.indexKeywords = TextTool.textToMd5(this.indexKeywords);
		return this;
	}
	public Indexinfo MD5IndexKeywords(String iv) throws Exception{ 
		this.indexKeywords = TextTool.textToMd5(this.indexKeywords+iv);
		return this;
	}
	public Indexinfo AESIndexKeywords(String pwd,String iv) throws Exception{ 
		this.indexKeywords = TextTool.textAESEncoder(this.indexKeywords, pwd, iv);
		return this;
	}
	public Indexinfo setIndexPhone(java.lang.String indexPhone) {
		this.indexPhone = indexPhone;
		return this;
	}
	public java.lang.String getIndexPhone() {
		return indexPhone;
	}
	public Indexinfo MD5IndexPhone() throws Exception{ 
		this.indexPhone = TextTool.textToMd5(this.indexPhone);
		return this;
	}
	public Indexinfo MD5IndexPhone(String iv) throws Exception{ 
		this.indexPhone = TextTool.textToMd5(this.indexPhone+iv);
		return this;
	}
	public Indexinfo AESIndexPhone(String pwd,String iv) throws Exception{ 
		this.indexPhone = TextTool.textAESEncoder(this.indexPhone, pwd, iv);
		return this;
	}
	public Indexinfo setIndexEm(java.lang.String indexEm) {
		this.indexEm = indexEm;
		return this;
	}
	public java.lang.String getIndexEm() {
		return indexEm;
	}
	public Indexinfo MD5IndexEm() throws Exception{ 
		this.indexEm = TextTool.textToMd5(this.indexEm);
		return this;
	}
	public Indexinfo MD5IndexEm(String iv) throws Exception{ 
		this.indexEm = TextTool.textToMd5(this.indexEm+iv);
		return this;
	}
	public Indexinfo AESIndexEm(String pwd,String iv) throws Exception{ 
		this.indexEm = TextTool.textAESEncoder(this.indexEm, pwd, iv);
		return this;
	}
	public Indexinfo setIndexAddress(java.lang.String indexAddress) {
		this.indexAddress = indexAddress;
		return this;
	}
	public java.lang.String getIndexAddress() {
		return indexAddress;
	}
	public Indexinfo MD5IndexAddress() throws Exception{ 
		this.indexAddress = TextTool.textToMd5(this.indexAddress);
		return this;
	}
	public Indexinfo MD5IndexAddress(String iv) throws Exception{ 
		this.indexAddress = TextTool.textToMd5(this.indexAddress+iv);
		return this;
	}
	public Indexinfo AESIndexAddress(String pwd,String iv) throws Exception{ 
		this.indexAddress = TextTool.textAESEncoder(this.indexAddress, pwd, iv);
		return this;
	}
	public Indexinfo setIndexQQ(java.lang.String indexQQ) {
		this.indexQQ = indexQQ;
		return this;
	}
	public java.lang.String getIndexQQ() {
		return indexQQ;
	}
	public Indexinfo MD5IndexQQ() throws Exception{ 
		this.indexQQ = TextTool.textToMd5(this.indexQQ);
		return this;
	}
	public Indexinfo MD5IndexQQ(String iv) throws Exception{ 
		this.indexQQ = TextTool.textToMd5(this.indexQQ+iv);
		return this;
	}
	public Indexinfo AESIndexQQ(String pwd,String iv) throws Exception{ 
		this.indexQQ = TextTool.textAESEncoder(this.indexQQ, pwd, iv);
		return this;
	}
	public Indexinfo(){
	
	}
	public Indexinfo(java.lang.Integer indexId, java.lang.String indexTitle, java.lang.String indexTitleImgUrl, java.lang.String indexDesc, java.lang.String indexKeywords, java.lang.String indexPhone, java.lang.String indexEm, java.lang.String indexAddress, java.lang.String indexQQ){
		this.indexId=indexId;
		this.indexTitle=indexTitle;
		this.indexTitleImgUrl=indexTitleImgUrl;
		this.indexDesc=indexDesc;
		this.indexKeywords=indexKeywords;
		this.indexPhone=indexPhone;
		this.indexEm=indexEm;
		this.indexAddress=indexAddress;
		this.indexQQ=indexQQ;
	}
	public Indexinfo(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "indexId");
			setIndexId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexTitle");
			setIndexTitle(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexTitleImgUrl");
			setIndexTitleImgUrl(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexDesc");
			setIndexDesc(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexKeywords");
			setIndexKeywords(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexPhone");
			setIndexPhone(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexEm");
			setIndexEm(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexAddress");
			setIndexAddress(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "indexQQ");
			setIndexQQ(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
		} 
	}
	public Indexinfo(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="indexId="+(indexId == null ? "" : indexId)+"\r\n";
		res+="indexTitle="+(indexTitle == null ? "" : indexTitle)+"\r\n";
		res+="indexTitleImgUrl="+(indexTitleImgUrl == null ? "" : indexTitleImgUrl)+"\r\n";
		res+="indexDesc="+(indexDesc == null ? "" : indexDesc)+"\r\n";
		res+="indexKeywords="+(indexKeywords == null ? "" : indexKeywords)+"\r\n";
		res+="indexPhone="+(indexPhone == null ? "" : indexPhone)+"\r\n";
		res+="indexEm="+(indexEm == null ? "" : indexEm)+"\r\n";
		res+="indexAddress="+(indexAddress == null ? "" : indexAddress)+"\r\n";
		res+="indexQQ="+(indexQQ == null ? "" : indexQQ)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"indexId\":\""+(indexId == null ? "" : indexId)+"\","+
		"\"indexTitle\":\""+(indexTitle == null ? "" : indexTitle)+"\","+
		"\"indexTitleImgUrl\":\""+(indexTitleImgUrl == null ? "" : indexTitleImgUrl)+"\","+
		"\"indexDesc\":\""+(indexDesc == null ? "" : indexDesc)+"\","+
		"\"indexKeywords\":\""+(indexKeywords == null ? "" : indexKeywords)+"\","+
		"\"indexPhone\":\""+(indexPhone == null ? "" : indexPhone)+"\","+
		"\"indexEm\":\""+(indexEm == null ? "" : indexEm)+"\","+
		"\"indexAddress\":\""+(indexAddress == null ? "" : indexAddress)+"\","+
		"\"indexQQ\":\""+(indexQQ == null ? "" : indexQQ)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Indexinfo> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Indexinfo> list =null;
		Indexinfo en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Indexinfo.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Indexinfo>();
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
				en=new Indexinfo();
				temp=rs.getString("indexId");
				if(temp!=null){
					en.setIndexId(new java.lang.Integer(temp));
				}
				temp=rs.getString("indexTitle");
				if(temp!=null){
					en.setIndexTitle(new java.lang.String(temp));
				}
				temp=rs.getString("indexTitleImgUrl");
				if(temp!=null){
					en.setIndexTitleImgUrl(new java.lang.String(temp));
				}
				temp=rs.getString("indexDesc");
				if(temp!=null){
					en.setIndexDesc(new java.lang.String(temp));
				}
				temp=rs.getString("indexKeywords");
				if(temp!=null){
					en.setIndexKeywords(new java.lang.String(temp));
				}
				temp=rs.getString("indexPhone");
				if(temp!=null){
					en.setIndexPhone(new java.lang.String(temp));
				}
				temp=rs.getString("indexEm");
				if(temp!=null){
					en.setIndexEm(new java.lang.String(temp));
				}
				temp=rs.getString("indexAddress");
				if(temp!=null){
					en.setIndexAddress(new java.lang.String(temp));
				}
				temp=rs.getString("indexQQ");
				if(temp!=null){
					en.setIndexQQ(new java.lang.String(temp));
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
		List<Indexinfo> list_ret=new ArrayList<Indexinfo>();
		List<Indexinfo> list=query(); 
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
	public List<Indexinfo> query() throws SQLException{ 
		String sql="select * from Indexinfo where ";
		List<Object> para=new ArrayList<Object>();
		if(getIndexId() != null){
			sql+="indexId = ? and ";
			para.add(getIndexId());
		}
		if(getIndexTitle() != null){
			sql+="indexTitle = ? and ";
			para.add(getIndexTitle());
		}
		if(getIndexTitleImgUrl() != null){
			sql+="indexTitleImgUrl = ? and ";
			para.add(getIndexTitleImgUrl());
		}
		if(getIndexDesc() != null){
			sql+="indexDesc = ? and ";
			para.add(getIndexDesc());
		}
		if(getIndexKeywords() != null){
			sql+="indexKeywords = ? and ";
			para.add(getIndexKeywords());
		}
		if(getIndexPhone() != null){
			sql+="indexPhone = ? and ";
			para.add(getIndexPhone());
		}
		if(getIndexEm() != null){
			sql+="indexEm = ? and ";
			para.add(getIndexEm());
		}
		if(getIndexAddress() != null){
			sql+="indexAddress = ? and ";
			para.add(getIndexAddress());
		}
		if(getIndexQQ() != null){
			sql+="indexQQ = ? and ";
			para.add(getIndexQQ());
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
	public Indexinfo get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Indexinfo.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("indexId");
				if(temp!=null){
					setIndexId(new java.lang.Integer(temp));
				}
				temp=rs.getString("indexTitle");
				if(temp!=null){
					setIndexTitle(new java.lang.String(temp));
				}
				temp=rs.getString("indexTitleImgUrl");
				if(temp!=null){
					setIndexTitleImgUrl(new java.lang.String(temp));
				}
				temp=rs.getString("indexDesc");
				if(temp!=null){
					setIndexDesc(new java.lang.String(temp));
				}
				temp=rs.getString("indexKeywords");
				if(temp!=null){
					setIndexKeywords(new java.lang.String(temp));
				}
				temp=rs.getString("indexPhone");
				if(temp!=null){
					setIndexPhone(new java.lang.String(temp));
				}
				temp=rs.getString("indexEm");
				if(temp!=null){
					setIndexEm(new java.lang.String(temp));
				}
				temp=rs.getString("indexAddress");
				if(temp!=null){
					setIndexAddress(new java.lang.String(temp));
				}
				temp=rs.getString("indexQQ");
				if(temp!=null){
					setIndexQQ(new java.lang.String(temp));
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
	public Indexinfo get() throws SQLException{ 
		String sql="select * from Indexinfo where ";
		List<Object> para=new ArrayList<Object>();
		if(getIndexId() != null){
			sql+="indexId = ? and ";
			para.add(getIndexId());
		}
		if(getIndexTitle() != null){
			sql+="indexTitle = ? and ";
			para.add(getIndexTitle());
		}
		if(getIndexTitleImgUrl() != null){
			sql+="indexTitleImgUrl = ? and ";
			para.add(getIndexTitleImgUrl());
		}
		if(getIndexDesc() != null){
			sql+="indexDesc = ? and ";
			para.add(getIndexDesc());
		}
		if(getIndexKeywords() != null){
			sql+="indexKeywords = ? and ";
			para.add(getIndexKeywords());
		}
		if(getIndexPhone() != null){
			sql+="indexPhone = ? and ";
			para.add(getIndexPhone());
		}
		if(getIndexEm() != null){
			sql+="indexEm = ? and ";
			para.add(getIndexEm());
		}
		if(getIndexAddress() != null){
			sql+="indexAddress = ? and ";
			para.add(getIndexAddress());
		}
		if(getIndexQQ() != null){
			sql+="indexQQ = ? and ";
			para.add(getIndexQQ());
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
		String sql="insert into Indexinfo (indexId,indexTitle,indexTitleImgUrl,indexDesc,indexKeywords,indexPhone,indexEm,indexAddress,indexQQ) values(?,?,?,?,?,?,?,?,?)";
		sb.append("Indexinfo.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setIndexId(new Integer(DataBase.gzbCache.getIncr("db_IndexId_auto_id_incr").toString()));
			pstate.setObject(1,getIndexId());
			pstate.setObject(2,getIndexTitle());
			pstate.setObject(3,getIndexTitleImgUrl());
			pstate.setObject(4,getIndexDesc());
			pstate.setObject(5,getIndexKeywords());
			pstate.setObject(6,getIndexPhone());
			pstate.setObject(7,getIndexEm());
			pstate.setObject(8,getIndexAddress());
			pstate.setObject(9,getIndexQQ());
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
			setIndexId(new Indexinfo("select * from Indexinfo order by indexId desc limit 1",null).getIndexId());
			DataBase.gzbCache.set("db_IndexId_auto_id_incr", getIndexId());
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
		String sql="delete from indexinfo where indexId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Indexinfo.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getIndexId()); 
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
		String sql="update Indexinfo set indexId=?,indexTitle=?,indexTitleImgUrl=?,indexDesc=?,indexKeywords=?,indexPhone=?,indexEm=?,indexAddress=?,indexQQ=? where IndexId=?";
		sb.append("Indexinfo.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getIndexId()); 
			pstate.setObject(2,getIndexTitle()); 
			pstate.setObject(3,getIndexTitleImgUrl()); 
			pstate.setObject(4,getIndexDesc()); 
			pstate.setObject(5,getIndexKeywords()); 
			pstate.setObject(6,getIndexPhone()); 
			pstate.setObject(7,getIndexEm()); 
			pstate.setObject(8,getIndexAddress()); 
			pstate.setObject(9,getIndexQQ()); 
			pstate.setObject(10,getIndexId()); 
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
