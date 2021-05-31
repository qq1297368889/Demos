package gzb.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock; 
public class Info {
	public static void main(String[] args) throws IOException {
		System.out.println(Info.getProjectPath());
	} 
	public static final String doubleTo2(double	data){
		return String.format("%.2f",data);
	}
	public static final String doubleTo1(double	data){
		return String.format("%.1f",data);
	}
	static String [] priv_ss1="QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzasdfghjklpoiuytrewq10123456789@_-".split("|");
	public static final String getString(int len){
		String str="";
		for (int i = 0; i < len; i++) {
			str+=priv_ss1[getRandom(priv_ss1.length-1, 0)];

		} 
		return str;
	}
	public static final int getRandom(int max,int min){
		return (min+(int)(Math.random()*max));
	}
	public static boolean isLinux() {
		return System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;
	}
	static String classesPath=null;
	public static String getWebClassPath(){
		if(classesPath!=null){return classesPath;}
		classesPath=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
		if(!isLinux()){
			classesPath = classesPath.substring(1);
		}
		return classesPath;
	}
	public static String getProjectPath(){ 
		return getWebClassPath().replace("WEB-INF/classes/", ""); 
	}
	/**
	 * 获取异常信息 详细
	 * */
	public static final String getExceptionInfo(Exception ex) {  
		ByteArrayOutputStream out = null;  
		PrintStream pout = null;  
		String ret = "";  
		try {  
			out = new ByteArrayOutputStream();  
			pout = new PrintStream(out);  
			ex.printStackTrace(pout);  
			ret = new String(out.toByteArray());  
			out.close();  
		}catch(Exception e){  
			return ex.getMessage();  
		}finally{  
			if(pout!=null){  
				pout.close();  
			}  
		}  
		return ret;  
	}  
	public static final String SJ_1="yyyy-MM-dd-HH-mm-ss";
	public static final String SJ_2="yyyy-MM-dd HH:mm:ss";
	/** 	
	 * 获取现行时间 格式     
	 * 指定格式 请传入   例子 ：yyyy-MM-dd-HH-mm-ss 
	 * */
	public static final String timeGet(String format){ 
		return new SimpleDateFormat(format).format(new Date()).toString();
	}
	public static final String timeGet(){ 
		return new SimpleDateFormat(SJ_2).format(new Date()).toString();
	}
	public static final int timeStampGet(){ 
		return Integer.valueOf(String.valueOf(new Date().getTime()).substring(0,10));
	}
	public static final String timeStampToDateString(int stamp,String format){ 
		try {
			return new SimpleDateFormat(format).format(new Date(Long.valueOf(stamp)*1000)).toString();
		} catch (Exception e) {
			Log.e(e);
		}
		return null;
	}
	public static final Integer timeDateStringToStamp(String data,String format){ 
		try {
			Long lo=new SimpleDateFormat(format).parse(data).getTime();  
			int res=new Integer((lo+"").substring(0, 10)); 
			return res;
		} catch (Exception e) {
			Log.e(e);
		}
		return null;
	}
	public static final Date timeStringToData(String data,String format){ 
		try {
			return new SimpleDateFormat(format).parse(data);
		} catch (Exception e) {
			Log.e(e);
		}
		return null;
	}
	public static final String timeDataToString(Date data,String format){ 
		try {
			return new SimpleDateFormat(format).format(data).toString();
		} catch (Exception e) { 
			Log.e(e);
		}
		return null;
	}
	public static final Lock lockGet(){ 
		return new ReentrantLock();
	}

}
