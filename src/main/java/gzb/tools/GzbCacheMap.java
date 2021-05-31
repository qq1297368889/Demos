package gzb.tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GzbCacheMap implements GzbCache{
	private static HashMap<String, CacheEntity> map=new HashMap<String, CacheEntity>();  
	private static Lock lock=new ReentrantLock();
	static{ 
		Thread t1= new Thread(){
			public void run() { 
				while (true) {
					try { 
						GzbCacheMap.lock.lock();
						try {
							Long TimeStamp=new Date().getTime(); 
							for (Iterator<Entry<String, CacheEntity>> it = GzbCacheMap.map.entrySet().iterator(); it.hasNext();){
								Entry<String, CacheEntity> en = it.next();
								if(en!=null && en.getValue().UseTime>0 && en.getValue().UseTime<TimeStamp){
									System.out.println("缓存删除："+en.getKey());
									it.remove();
								}
							}  
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							GzbCacheMap.lock.unlock();
						}  
						sleep(1000*10);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}


			}
		}; 
		t1.start();
	}
	@Override
	public Long getIncr(String key) {
		lock.lock();
		try {
			CacheEntity ce=map.get(key);
			if(ce==null){
				ce=new CacheEntity();
			}
			if(ce.Obj==null){
				ce.Obj="0";
				ce.UseTime=0;
			}
			Long res=Long.valueOf(ce.Obj.toString())+1;
			ce.Obj=res;
			map.put(key, ce);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return 0l;
	}

	@Override
public Object get(String key) {
		lock.lock();
		try {
			Long TimeStamp=new Date().getTime();
			CacheEntity ce=map.get(key); 
			if(ce==null || (ce.UseTime>0 && ce.UseTime<=TimeStamp)){ 
				return null;
			} 
			return ce.Obj;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return null;
	}
	@Override
	public Object get(String key,int mm) {
		lock.lock();
		try {
			Long TimeStamp=new Date().getTime();
			CacheEntity ce=map.get(key);
			if(ce==null || (ce.UseTime>0 && ce.UseTime<TimeStamp)){ 
				return null;
			} 
			//ce.UseTime=TimeStamp+(mm*1000);  
			//map.put(key, ce);
			return ce.Obj;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return null;
	}
	@Override
	public void set(String key, Object val) {
		lock.lock(); 
		try {
			map.put(key, new CacheEntity(val,0l));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	@Override
	public void set(String key, Object val, int mm) {
		lock.lock();
		try {
			Long TimeStamp=new Date().getTime();
			map.put(key, new CacheEntity(val,TimeStamp+(mm*1000)));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	@Override
	public Object del(String key) {
		lock.lock(); 
		try {
			CacheEntity ce=map.remove(key);
			if (ce==null){return null;}
			return ce.Obj;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return null;
	}


}
