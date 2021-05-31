package gzb.tools;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress; 
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebTool {
	public static final String jsonSuccess(String msg){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"1\","
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final String jsonSuccess(String msg,List<?> list){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"1\","
				+ "\"data\":"+list+","
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final String jsonSuccess(String msg,String data){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"1\","
				+ "\"data\":["+data+"],"
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	}  
	public static final String jsonFail(String msg){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"2\","
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final String jsonError(){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"3\","
				+ "\"msg\":\"服务器发生错误,请稍后重试!\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final String jsonError(String msg){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"3\","
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	} 
	public static final String jsonJump(String msg,String url){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"4\","
				+ "\"url\":\""+url+"\","
				+ "\"msg\":\""+msg+"\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final String jsonJump(String url){
		String json="{"
				+ "\"code\":\"0\","
				+ "\"state\":\"4\","
				+ "\"url\":\""+url+"\","
				+ "\"msg\":\"未登录或登录失效,请重新登录~\""
				+ "}";
		System.out.println(json);
		return json;
	}
	public static final void CookieSet(String key,String value,int mm, 
			HttpServletResponse resp,HttpServletRequest request){   
		if(key==null || value==null){ 
			return ;
		} 
		String [] ss1=request.getServerName().split("\\."); 
		Cookie cookie=new Cookie(key, value); 
		cookie.setMaxAge(mm); 
		/*if(ss1.length==3){
			System.out.println(ss1[1]+"."+ss1[2]);
			cookie.setDomain(ss1[1]+"."+ss1[2]);
		}*/

		resp.addCookie(cookie); 
	}  
	public static final String CookieGet(String key,HttpServletRequest request){   
		Cookie[] cookies=request.getCookies();
		if(cookies==null){
			return null;
		}
		for(Cookie cookie : cookies){   
			if(key.equals(cookie.getName())){ 
				return cookie.getValue();
			} 
		} 
		return null;
	} 
	public static final String getIpAddress(HttpServletRequest request) {  
		String ip = request.getHeader("x-forwarded-for");  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_CLIENT_IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getRemoteAddr();  
			if("127.0.0.1".equals(ip)||"0:0:0:0:0:0:0:1".equals(ip)){
				//根据网卡取本机配置的IP
				InetAddress inet=null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip= inet.getHostAddress();
			}
		}  
		return ip;
	} 

}
