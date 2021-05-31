package gzb.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

public class WebGzbSession {
	private int mm=60*60*24*30;
	private static final String CookPwd="AG5gHJKISXlums0r";
	private static final String CookIV="HJYx5D6w1mbms09k";
	private HttpServletRequest request;
	private HttpServletResponse response; 
	public WebGzbSession(int mm,HttpServletRequest request,HttpServletResponse response){
		this.mm=mm;
		this.request=request;
		this.response=response;
	}
	public int GetInt(String key){
		String str=WebTool.CookieGet(key, request);  
		str=TextTool.textAESEncoder(str, CookPwd, CookIV);
		if(str==null || str.length()<1){
			str=request.getParameter(key); 
			if(str==null || str.length()<1){
				return 0;
			}
		} 
		return Integer.valueOf(str);
	}
	public String GetString(String key){
		String str=WebTool.CookieGet(key, request); 
		if(str==null || str.length()<1){
			str=request.getParameter(key); 
			if(str==null || str.length()<1){
				return null;
			}
		} 
		return TextTool.textAESDecoder(str, CookPwd, CookIV);
	}
	public void Put(String key,String val){
		val=TextTool.textAESEncoder(val, CookPwd, CookIV);
		if(val!=null){
			WebTool.CookieSet(key, val, mm, response, request);
		}
	}
	public void Del(String key){
		WebTool.CookieSet(key, null, mm, response, request);
	} 
}
