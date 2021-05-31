package gzb.tools;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log {
	static StringBuffer infoLog=new StringBuffer();
	static StringBuffer exceptionLog=new StringBuffer();
	static Lock lock_infoLog=new ReentrantLock();
	static Lock lock_exceptionLog=new ReentrantLock();  
	static{
		Thread t=new Thread(){ 
			@Override
			public void run() {
				try {
					String exceptionLogUrl=Info.getProjectPath()+"/Log/exception.log";
					String infoLogUrl=Info.getProjectPath()+"/Log/info.log";
					FileTool.fileNew(exceptionLogUrl);
					FileTool.fileNew(infoLogUrl); 
					String log=null;
					while (true) { 
						if(Log.infoLog!=null && Log.infoLog.length()>0){ 
							lock_infoLog.lock();
							try {
								log=Log.infoLog.toString();
								Log.infoLog=new StringBuffer(); 
							} catch (Exception e) {
								e(e);
							}finally{
								lock_infoLog.unlock();
							} 
							FileTool.fileSaveString(infoLogUrl, log, true);  
						}
						if(Log.exceptionLog!=null && Log.exceptionLog.length()>0){ 
							lock_exceptionLog.lock();
							try {
								log=Log.exceptionLog.toString();
								Log.exceptionLog=new StringBuffer(); 
							} catch (Exception e) {
								e(e);
							}finally{
								lock_exceptionLog.unlock();
							} 
							FileTool.fileSaveString(exceptionLogUrl, log, true); 
						}  
						sleep(1000*5);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		};
		t.start();
	}
	public static void main(String[] args) throws InterruptedException {
		 
	}
	public static void e(Exception e){
		lock_exceptionLog.lock(); 
		lock_exceptionLog.unlock();
		e.printStackTrace(); 
		exceptionLog.append(Info.timeGet())  
		.append("\r\n")
		.append(Info.getExceptionInfo(e))
		.append("\r\n"); 
	}
	public static void e(Exception e,String log){ 
		lock_exceptionLog.lock(); 
		lock_exceptionLog.unlock();
		e.printStackTrace();
		System.out.println(log);
		exceptionLog.append(Info.timeGet()) 
		.append("\r\n")
		.append(log)
		.append("\r\n")
		.append(Info.getExceptionInfo(e))
		.append("\r\n"); 
		
	}
	public static void i(String log){  
		lock_infoLog.lock(); 
		lock_infoLog.unlock();
		System.out.println(log); 
		infoLog.append(Info.timeGet()) 
		.append("\r\n")
		.append(log) 
		.append("\r\n"); 
	}
	public static void print(Object [] arr){
		for (int i = 0; i < arr.length; i++) {
			i(arr[i].toString());
		}
	}
	public static void print(List<Object> arr){
		for (int i = 0; i < arr.size(); i++) { 
			i(arr.get(i).toString());
		}
	}
}
