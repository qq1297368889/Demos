package gzb.tools;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;  

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec; 

public class TextTool { 
	static String [] priv_ss1="QWERTYUIOPASDFGHJKLZXCVBNMmnbvcxzasdfghjklpoiuytrewq10123456789".split("|"); 
	public static final String tetGetString(int len){
		String str="";
		for (int i = 0; i < len; i++) {
			str+=priv_ss1[Info.getRandom(priv_ss1.length-1, 0)];

		}

		return str;
	}
	public static final String JsonGetVal(String json,String key){ 
		String []ss1=json.split("\""+key+"\"");
		String [] ss2;
		if(ss1.length>=2){
			ss2=ss1[1].split("\"");
			if(ss2.length>=2){
				return ss2[1];
			}
		}
		return null;
	}
	public static final String configGet(String fileUrl, String key) throws Exception{
		FileTool.fileNew(fileUrl);
		String []ss0=FileTool.fileReadArray(fileUrl,"UTF-8");

		return configGetText(ss0,key);
	}
	public static final String configGetText(String []ss0, String key) throws Exception{
		for (String string : ss0) {
			if(string!=null && string.length()>0){
				String []ss1=string.split("=",2);
				if(ss1.length==2 && ss1[0].equals(key)){
					System.out.println(key+"="+ss1[1]);
					return ss1[1];
				}
			}
		}
		return null;
	}
	public static final void configSet(String fileUrl, String key, String val) throws Exception{
		FileTool.fileNew(fileUrl);
		String []ss0=FileTool.fileReadArray(fileUrl,"UTF-8");
		String all="";
		all+=key+"="+val+"\r\n";
		for (String string : ss0) {
			if(string!=null && string.length()>0){
				String []ss1=string.split("=",2);
				if(ss1.length==2 && ss1[0].equals(key)){

				}else{
					all+=ss1[0]+"="+ss1[1]+"\r\n";
				}
			}
		}
		FileTool.fileSaveString(fileUrl, all, false); 
	} 

	public static final String textBase64Encoder(String str){
		try {
			return textBase64Encoder(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
			return null;
		} 
	}
	public static final String textBase64Encoder(byte []strByte){
		try {
			return new String(Base64.getEncoder().encode(strByte),"UTF-8").replaceAll("=", "_").replaceAll("\\+", "-");
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
			return null;
		} 
	}
	public static final String textBase64Decoder(String str){
		try { 
			return new String(textBase64DecoderByte(str),"UTF-8");
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
			return null;
		} 
	}
	public static final byte [] textBase64DecoderByte(String str){
		try { 
			return Base64.getDecoder().decode(str.replaceAll("_", "=").replaceAll("-", "+"));
		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		} 
	}
	public static final String textAESEncoder(String str,String pwd1,String pwd2){
		try {  
			byte[] raw = pwd1.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
			IvParameterSpec iv = new IvParameterSpec(pwd2.getBytes("UTF-8"));//使用CBC模式，需要一个向量iv，可增加加密算法的强度
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv); 
			return textBase64Encoder(cipher.doFinal(str.getBytes("UTF-8")));
		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		} 
	}
	public static final String textAESDecoder(String str,String pwd1,String pwd2){
		try { 
			byte[] raw = pwd1.getBytes("UTF-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(pwd2.getBytes("UTF-8"));
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);  
			return new String(cipher.doFinal(textBase64DecoderByte(str)),"UTF-8");
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}


	/**
	 * 获取文本MD5
	 * 参数1:文本
	 * 默认为 UTF-8
	 * */
	public static final String textToMd5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(str.getBytes("UTF8"));
		byte s[] = m.digest();
		String result = "";
		for (int i = 0; i < s.length; i++) {
			result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
		}
		while (result.length()<32) {
			result="0"+result;
		} 
		return result;
	}

	public static final String textMid(String str,String q,String h,int index){
		int a =-1;
		int b =-1;
		while (index>0) {
			index--;
			a=str.indexOf(q);
			if(a<0){
				return null;
			} 
			b=str.indexOf(h, a);
			if(b<0){
				return null;
			}
		}
		return str.substring(a+2,b);
	}
}
