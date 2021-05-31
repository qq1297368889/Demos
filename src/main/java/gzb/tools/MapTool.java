package gzb.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map; 
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock; 


public class MapTool {
	public static Map<String, entityMapTime> map=new HashMap<String, entityMapTime>(); 
	public static Lock lock0=new ReentrantLock();
	public static void main(String[] args) { 
	 
		MapTool.read("D:/1/data.txt");
		System.out.println(MapTool.get("k1"));
	}
	 static{
		new Thread(){
			public void run() {
				int time=0;
				while (true) { 
					try { 
						time=Info.timeStampGet();
						Entry<String, entityMapTime> en=null;
						for (Iterator<Entry<String, entityMapTime>> it = map.entrySet().iterator(); it.hasNext();){
							en = it.next(); 
							if(en.getValue().useTime>0 && en.getValue().useTime<time){
								it.remove();
							} 
						}  
						sleep(1000);
					} catch (Exception e) {
						Log.e(e);;
					}
					 
				}
			}; 
		}.start();

	} 
	public static final Object get(String key){
		entityMapTime emt=map.get(key);
		if(emt==null){ 
			return null;
		}
		emt.lock();
		try {
			int time1=Info.timeStampGet();
			if(emt.useTime>0 && emt.useTime<time1){
				return null;
			}
			return emt.getData();
		} catch (Exception e) {
			Log.e(e);
			return null;
		}finally{ 
			emt.unlock();
		}
	}
	public static final Object get(String key,int mm){
		entityMapTime emt=map.get(key);
		if(emt==null){ 
			return null;
		}
		emt.lock();
		try {
			int time1=Info.timeStampGet();
			if(emt.useTime>0 && emt.useTime<time1){
				return null;
			}
			emt.useTime=Info.timeStampGet()+mm;
			return emt.getData();
		} catch (Exception e) {
			Log.e(e);
			return null;
		}finally{ 
			emt.unlock();
		}
	}
	public static final void put(String key,Object obj){
		entityMapTime emt=map.get(key);
		if(emt==null){ 
			emt =new entityMapTime(obj,0);
			map.put(key, emt);
		}
		emt.lock();
		try { 
			emt.setData(obj); 
		} catch (Exception e) {
			Log.e(e); 
		}finally{ 
			emt.unlock();
		}
	}
	public static final void put(String key,Object obj,int mm){
		entityMapTime emt=map.get(key);
		if(emt==null){ 
			emt =new entityMapTime(obj,mm);
			map.put(key, emt);
		}else{
			emt.setData(obj);
			emt.addTime=Info.timeStampGet();
			emt.useTime=emt.addTime+mm;
		}
		emt.lock();
		try { 
			emt.setData(obj); 
		} catch (Exception e) {
			Log.e(e); 
		}finally{ 
			emt.unlock();
		}
	}
	public static final Object del(String key){
		entityMapTime emt=map.get(key);
		if(emt==null){ 
			return null;
		}
		emt.lock();
		try {
			return map.remove(key); 
		} catch (Exception e) {
			Log.e(e);
			return null;
		}finally{ 
			emt.unlock();
		}
	}
	public static final void save(String url){
		try {   
			StringBuilder sb=new StringBuilder();
			int time=Info.timeStampGet();
			for (Iterator<Entry<String, entityMapTime>> it = map.entrySet().iterator(); it.hasNext();){
				Entry<String, entityMapTime> en = it.next(); 
				System.out.println(en.getValue().getData());
				if(en.getValue().useTime<1 || en.getValue().useTime>time){ 
					en.getValue().lock();
					try {
						sb.append(TextTool.textBase64Encoder(en.getKey()));
						sb.append("|");
						sb.append(TextTool.textBase64Encoder(en.getValue().getData().toString()));
						sb.append("|");
						sb.append(TextTool.textBase64Encoder(en.getValue().useTime+""));
						sb.append("|");
						sb.append(TextTool.textBase64Encoder(en.getValue().addTime+""));
						sb.append("\r\n");
						if(sb.length()>102400){
							FileTool.fileSaveString(url, sb.toString(), true);
							sb.setLength(0);
						}
					} catch (Exception e) {
						throw e;
					}finally{
						en.getValue().unlock();
					}   
				} 
			}   
			if(sb.length()>0){ 
				FileTool.fileSaveString(url, sb.toString(), true);
				sb.setLength(0);
			}
		} catch (Exception e) {
			Log.e(e);;
		}
	}
	public static final void read(String url){
		try {    
			String str=FileTool.fileReadString(url);
			String[]ss1=str.split("\r\n");
			String[]ss2=null;
			String key=null;
			entityMapTime emt=null;
			for (String string : ss1) {
				if(string==null || string.length()<3){
					continue;
				}
				ss2=string.split("\\|");
				if(ss2.length==4){
					key=TextTool.textBase64Decoder(ss2[0]);
					emt=new entityMapTime();
					emt.useTime=Integer.valueOf(TextTool.textBase64Decoder(ss2[2]));
					emt.addTime=Integer.valueOf(TextTool.textBase64Decoder(ss2[3]));
					emt.setData(TextTool.textBase64Decoder(ss2[1]));
					map.put(key, emt); 
				}
			}

		} catch (Exception e) {
			Log.e(e);;
		}
	}

} 
class entityMapTime{
	public int addTime=Info.timeStampGet();
	public int useTime=0;
	public Object data=null;
	Lock lock=new ReentrantLock();
	public entityMapTime(Object data,int mm){
		this.data=data;
		if(mm>0){
			useTime=addTime+mm;
		}else{
			useTime+=0;
		}

	}
	public entityMapTime(){ 
	}
	public void lock(){
		lock.lock(); 
	}
	public void unlock(){
		lock.unlock(); 
	}
	public Object getData(){ 
		return data;
	}
	public void setData(Object data){ 
		this.data=data;
	}
}