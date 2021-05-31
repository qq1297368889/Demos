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
public class Pay {
	private java.lang.Integer payId;
	private java.lang.String payZFB;
	private java.lang.Integer payTime;
	private java.lang.Integer payRecCodeId;
	private java.lang.Integer payState;
	private java.lang.Double payPrice;
	private List<?> obj;
	private boolean runState=false;
	public boolean runState(){
		return runState;
	}
	public Pay setPayId(java.lang.Integer payId) {
		this.payId = payId;
		return this;
	}
	public java.lang.Integer getPayId() {
		return payId;
	}
	public Pay setPayZFB(java.lang.String payZFB) {
		this.payZFB = payZFB;
		return this;
	}
	public java.lang.String getPayZFB() {
		return payZFB;
	}
	public Pay MD5PayZFB() throws Exception{ 
		this.payZFB = TextTool.textToMd5(this.payZFB);
		return this;
	}
	public Pay MD5PayZFB(String iv) throws Exception{ 
		this.payZFB = TextTool.textToMd5(this.payZFB+iv);
		return this;
	}
	public Pay AESPayZFB(String pwd,String iv) throws Exception{ 
		this.payZFB = TextTool.textAESEncoder(this.payZFB, pwd, iv);
		return this;
	}
	public Pay setPayTime(java.lang.Integer payTime) {
		this.payTime = payTime;
		return this;
	}
	public java.lang.Integer getPayTime() {
		return payTime;
	}
	public Pay setPayRecCodeId(java.lang.Integer payRecCodeId) {
		this.payRecCodeId = payRecCodeId;
		return this;
	}
	public java.lang.Integer getPayRecCodeId() {
		return payRecCodeId;
	}
	public Pay setPayState(java.lang.Integer payState) {
		this.payState = payState;
		return this;
	}
	public java.lang.Integer getPayState() {
		return payState;
	}
	public Pay setPayPrice(java.lang.Double payPrice) {
		this.payPrice = payPrice;
		return this;
	}
	public java.lang.Double getPayPrice() {
		return payPrice;
	}
	public Pay(){
	
	}
	public Pay(java.lang.Integer payId, java.lang.String payZFB, java.lang.Integer payTime, java.lang.Integer payRecCodeId, java.lang.Integer payState, java.lang.Double payPrice){
		this.payId=payId;
		this.payZFB=payZFB;
		this.payTime=payTime;
		this.payRecCodeId=payRecCodeId;
		this.payState=payState;
		this.payPrice=payPrice;
	}
	public Pay(String json){
		String temp;
		if(json!=null && json.length()>0){
			temp = TextTool.JsonGetVal(json, "payId");
			setPayId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "payZFB");
			setPayZFB(temp==null || temp.length()==0 ? null : java.lang.String.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "payTime");
			setPayTime(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "payRecCodeId");
			setPayRecCodeId(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "payState");
			setPayState(temp==null || temp.length()==0 ? null : java.lang.Integer.valueOf(temp));
			temp = TextTool.JsonGetVal(json, "payPrice");
			setPayPrice(temp==null || temp.length()==0 ? null : java.lang.Double.valueOf(temp));
		} 
	}
	public Pay(String sql,Object []para){
		try {
			get(sql,para);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}
	public String toConfig(){
		String res="";
		res+="payId="+(payId == null ? "" : payId)+"\r\n";
		res+="payZFB="+(payZFB == null ? "" : payZFB)+"\r\n";
		res+="payTime="+(payTime == null ? "" : payTime)+"\r\n";
		res+="payRecCodeId="+(payRecCodeId == null ? "" : payRecCodeId)+"\r\n";
		res+="payState="+(payState == null ? "" : payState)+"\r\n";
		res+="payPrice="+(payPrice == null ? "" : payPrice)+"\r\n";
		return res;
	}
	@Override
	public String toString(){
		String res="{"+
		"\"payId\":\""+(payId == null ? "" : payId)+"\","+
		"\"payZFB\":\""+(payZFB == null ? "" : payZFB)+"\","+
		"\"payTime\":\""+(payTime == null ? "" : payTime)+"\","+
		"\"payRecCodeId\":\""+(payRecCodeId == null ? "" : payRecCodeId)+"\","+
		"\"payState\":\""+(payState == null ? "" : payState)+"\","+
		"\"payPrice\":\""+(payPrice == null ? "" : payPrice)+"\","+
		"\"obj\":"+(obj==null ? "[]" : obj)+
		"}";
		return res;
	}
	public List<Pay> query(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		List<Pay> list =null;
		Pay en=null;
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Pay.query:").append(sql).append(";参数:"); 
		try {
			list=new ArrayList<Pay>();
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
				en=new Pay();
				temp=rs.getString("payId");
				if(temp!=null){
					en.setPayId(new java.lang.Integer(temp));
				}
				temp=rs.getString("payZFB");
				if(temp!=null){
					en.setPayZFB(new java.lang.String(temp));
				}
				temp=rs.getString("payTime");
				if(temp!=null){
					en.setPayTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("payRecCodeId");
				if(temp!=null){
					en.setPayRecCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("payState");
				if(temp!=null){
					en.setPayState(new java.lang.Integer(temp));
				}
				temp=rs.getString("payPrice");
				if(temp!=null){
					en.setPayPrice(new java.lang.Double(temp));
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
		List<Pay> list_ret=new ArrayList<Pay>();
		List<Pay> list=query(); 
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
	public List<Pay> query() throws SQLException{ 
		String sql="select * from Pay where ";
		List<Object> para=new ArrayList<Object>();
		if(getPayId() != null){
			sql+="payId = ? and ";
			para.add(getPayId());
		}
		if(getPayZFB() != null){
			sql+="payZFB = ? and ";
			para.add(getPayZFB());
		}
		if(getPayTime() != null){
			sql+="payTime = ? and ";
			para.add(getPayTime());
		}
		if(getPayRecCodeId() != null){
			sql+="payRecCodeId = ? and ";
			para.add(getPayRecCodeId());
		}
		if(getPayState() != null){
			sql+="payState = ? and ";
			para.add(getPayState());
		}
		if(getPayPrice() != null){
			sql+="payPrice = ? and ";
			para.add(getPayPrice());
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
	public Pay get(String sql,Object []para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null; 
		StringBuilder sb=new StringBuilder(); 
		sb.append("Pay.get:").append(sql).append(";参数:"); 
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
				temp=rs.getString("payId");
				if(temp!=null){
					setPayId(new java.lang.Integer(temp));
				}
				temp=rs.getString("payZFB");
				if(temp!=null){
					setPayZFB(new java.lang.String(temp));
				}
				temp=rs.getString("payTime");
				if(temp!=null){
					setPayTime(new java.lang.Integer(temp));
				}
				temp=rs.getString("payRecCodeId");
				if(temp!=null){
					setPayRecCodeId(new java.lang.Integer(temp));
				}
				temp=rs.getString("payState");
				if(temp!=null){
					setPayState(new java.lang.Integer(temp));
				}
				temp=rs.getString("payPrice");
				if(temp!=null){
					setPayPrice(new java.lang.Double(temp));
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
	public Pay get() throws SQLException{ 
		String sql="select * from Pay where ";
		List<Object> para=new ArrayList<Object>();
		if(getPayId() != null){
			sql+="payId = ? and ";
			para.add(getPayId());
		}
		if(getPayZFB() != null){
			sql+="payZFB = ? and ";
			para.add(getPayZFB());
		}
		if(getPayTime() != null){
			sql+="payTime = ? and ";
			para.add(getPayTime());
		}
		if(getPayRecCodeId() != null){
			sql+="payRecCodeId = ? and ";
			para.add(getPayRecCodeId());
		}
		if(getPayState() != null){
			sql+="payState = ? and ";
			para.add(getPayState());
		}
		if(getPayPrice() != null){
			sql+="payPrice = ? and ";
			para.add(getPayPrice());
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
		String sql="insert into Pay (payId,payZFB,payTime,payRecCodeId,payState,payPrice) values(?,?,?,?,?,?)";
		sb.append("Pay.save:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			setPayId(new Integer(DataBase.gzbCache.getIncr("db_PayId_auto_id_incr").toString()));
			pstate.setObject(1,getPayId());
			pstate.setObject(2,getPayZFB());
			pstate.setObject(3,getPayTime());
			pstate.setObject(4,getPayRecCodeId());
			pstate.setObject(5,getPayState());
			pstate.setObject(6,getPayPrice());
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
			setPayId(new Pay("select * from Pay order by payId desc limit 1",null).getPayId());
			DataBase.gzbCache.set("db_PayId_auto_id_incr", getPayId());
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
		String sql="delete from pay where payId=?";
		StringBuilder sb=new StringBuilder(); 
		sb.append("Pay.delete:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getPayId()); 
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
		String sql="update Pay set payId=?,payZFB=?,payTime=?,payRecCodeId=?,payState=?,payPrice=? where PayId=?";
		sb.append("Pay.update:").append(sql).append(";参数:").append(this.toString()); 
		try { 
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			pstate.setObject(1,getPayId()); 
			pstate.setObject(2,getPayZFB()); 
			pstate.setObject(3,getPayTime()); 
			pstate.setObject(4,getPayRecCodeId()); 
			pstate.setObject(5,getPayState()); 
			pstate.setObject(6,getPayPrice()); 
			pstate.setObject(7,getPayId()); 
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
