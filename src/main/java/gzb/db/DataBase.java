package gzb.db;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.Date;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import gzb.tools.*;
public class DataBase {
	private static HikariDataSource cpds=null;
	public static GzbCache gzbCache=new GzbCacheMap();//new GzbCacheRedis(); new GzbCacheMap();
	//public static GzbCache gzbRedis=new GzbCacheRedis();//new GzbCacheRedis(); new GzbCacheMap();
	public static GzbCache queryCacheMap=gzbCache;//new GzbCacheRedis(); new GzbCacheMap(); 
	public static boolean queryCache=false;
	public static void main(String[] args) throws Exception {
		 
	}
	static{
		int id=1;
		try {
			String dbConfigUrl=Info.getWebClassPath()+ "config.ini";
			HikariConfig config = new HikariConfig(); 
			if(new File(dbConfigUrl).exists()){
				String []ss0=FileTool.fileReadArray(dbConfigUrl,"UTF-8");
				config.setJdbcUrl(TextTool.configGetText(ss0, "数据库连接_"+id+"_连接"));
				config.setDriverClassName(TextTool.configGetText(ss0, "数据库连接_"+id+"_类名"));
				config.setUsername(TextTool.configGetText(ss0, "数据库连接_"+id+"_账号"));
				config.setPassword(TextTool.configGetText(ss0, "数据库连接_"+id+"_密码"));
				config.setAutoCommit(Boolean.valueOf(TextTool.configGetText(ss0, "数据库连接_"+id+"_自动提交")));
				config.setMaximumPoolSize(Integer.valueOf(TextTool.configGetText(ss0, "数据库连接_"+id+"_线程池最大连接")));
				config.setConnectionTimeout(Integer.valueOf(TextTool.configGetText(ss0, "数据库连接_"+id+"_获取连接超时")));
				config.addDataSourceProperty("nullCatalogMeansCurrent", true);
				System.out.println("mysql,初始化成功");
			}else{
				System.out.println(dbConfigUrl+" 不存在,mysql,初始化失败");
				throw new Exception();
			}
			cpds = new HikariDataSource(config);
		} catch (Exception e) {
			Log.e(e);
			System.out.println("mysql,初始化失败"+e);
		}

	} 
	public static final int runSqlUpdateOrSaveOrDelete(String sql,Object [] para) throws SQLException{
		if(para==null){
			para=new Object[]{};
		}
		Connection conn=null;  
		ResultSet rs=null;
		PreparedStatement pstate=null;  
		StringBuilder sb = new StringBuilder(); 
		sb.append("DataBase.runSqlUpdateOrSaveOrDelete.sql:").append(sql).append(";参数:");  
		try {  
			conn = DataBase.getConnection();
			pstate = conn.prepareStatement(sql); 
			for (int i = 0; i < para.length; i++) {
				pstate.setObject(i+1,para[i]);
				sb.append(para[i]).append(",");
			}  
			long t1=new Date().getTime();
			int res=pstate.executeUpdate();
			long t2=new Date().getTime();  
			sb.append(";耗时:");
			sb.append(t2-t1);
			sb.append("毫秒");
			Log.i(sb.toString());
			return res;
		}catch(Exception e) {  
			Log.e(e,sb.toString());
		}finally{
			DataBase.close(conn,rs,pstate);
		} 
		return -1;
	}

	public static final Connection getConnection() throws SQLException{
		return cpds.getConnection(); 
	}
	public static final void close(Connection conn,ResultSet rs,PreparedStatement pstate){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstate!=null){
				pstate.close();
			}
			if(conn!=null){
				conn.close();
			}  
		} catch (Exception e) {
			Log.e(e);
		}
	};
}
