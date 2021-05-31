package gzb.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException; 
import java.security.MessageDigest; 
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
 
public class FileTool {

	public static void main(String[] args) throws Exception {
	 
	}
	
	
	
	/** 
     * 重命名文件 
     * @param
     * @return 
     */  
	public static final void fileRename(String oldFileName, String newFileName) {  
        File oldFile = new File(oldFileName); 
        File newFile = new File(newFileName);
        if (oldFile.exists() && oldFile.isFile()) {
            oldFile.renameTo(newFile);
        }
    }
	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 默认为 UTF-8
	 * */	
	public static final void fileSaveArray(File file,Object[] str,String encoding){ 
		FileOutputStream fos = null; 
        try { 
        	fos = new FileOutputStream(file,true);
        	for (Object object : str) {
        		fos.write((object+"\r\n").getBytes(encoding)); 
    		}
        	fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                	fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
	}
	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 默认为 UTF-8
	 * */	
	public static final void fileSaveList(File file,List<?>str,String encoding){ 
		FileOutputStream fos = null; 
        try { 
        	fos = new FileOutputStream(file,true);
        	for (Object object : str) {
        		fos.write((object+"\r\n").getBytes(encoding)); 
    		}
        	fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                	fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } 
	}
	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 默认为 UTF-8
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * */	
	public static final void fileSaveString(String file,String str,boolean add) throws UnsupportedEncodingException, IOException{ 
			fileSaveString(file,str,add,"UTF-8"); 
	}
	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如new File("d:/a.txt")
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 默认为 UTF-8
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * */	
	public static final void fileSaveString(File file,String str,boolean add) throws UnsupportedEncodingException, IOException{ 
			fileSaveString(file,str,add,"UTF-8"); 
	}

	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 参数4:编码 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * */	
	public static final void fileSaveString(String file,String str,boolean add,String encoding) throws UnsupportedEncodingException, IOException{ 
			fileSaveByte(new File(file),str.getBytes(encoding),add); 
	}
	/**
	 * 保存字符串数据
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * 参数4:编码 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * */	
	public static final void fileSaveString(File file,String str,boolean add,String encoding) throws UnsupportedEncodingException, IOException{ 
			fileSaveByte(file,str.getBytes(encoding),add); 
	}
	
	
	/**
	 * 保存byte数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * @throws IOException 
	 * */	
	public static final void fileSaveByte(String file,byte[]bytes,boolean add) throws IOException{
		fileSaveByte(new File(file),bytes,add);
		
	}

	/**
	 * 文件不存在会重新创建目录并创建文件,如果存在则不作操作,
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * */	
	public static final void fileNew(File file) throws IOException{ 
    	if (!file.exists()) {  
			file.getParentFile().mkdirs();
			file.createNewFile(); 
		}  
	}
	public static final String fileSaveResources(String file) throws Exception{
		return fileSaveResources(new File(file));
	}
	public static final String fileSaveResources(String file,String rootUrl) throws Exception{
		return fileSaveResources(new File(file),rootUrl);
	}
	/**
	 * 保存文件到webroot目录下 Resources
	 * 参数1:文件地址 例如 File file
	 * */	
	public static final String fileSaveResources(File file,String rootUrl) throws Exception{
		String md5 = FileTool.fileToMd5(file);
		String page=rootUrl+"Resources/";
		page+=md5.substring(0,8)+"/"; 
		page+=md5.substring(8,16)+"/"; 
		page+=md5.substring(16,24)+"/"; 
		page+=md5.substring(24,32)+"/";  
		System.out.println(page);
		System.out.println(md5);
		File file1=new File(page);
		if(file1.exists()){
			return page;//重复文件!
		}
		file1.getParentFile().mkdirs();
		file1.createNewFile();
		FileTool.fileSaveByte(file1, FileTool.fileReadByte(file), false);
		return page;
	}
	public static final String fileSaveResources(File file) throws Exception{
		String md5 = FileTool.fileToMd5(file);
		String page=Info.getProjectPath()+"Resources/";
		page+=md5.substring(0,8)+"/"; 
		page+=md5.substring(8,16)+"/"; 
		page+=md5.substring(16,24)+"/"; 
		page+=md5.substring(24,32)+"/";  
		System.out.println(page);
		System.out.println(md5);
		File file1=new File(page);
		if(file1.exists()){
			return page;//重复文件!
		}
		file1.getParentFile().mkdirs();
		file1.createNewFile();
		FileTool.fileSaveByte(file1, FileTool.fileReadByte(file), false);
		return page;
	}
	/**
	 * 文件不存在会重新创建目录并创建文件,如果存在则不作操作,
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * */	
	public static final void fileNew(String file) throws IOException{ 
		fileNew(new File(file));
	}
	/**
	 * 保存byte数据
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 参数2:要保存的数据
	 * 参数3:是否追加,true追加写入,false覆盖写入
	 * @throws IOException 
	 * */	
	public static final void fileSaveByte(File file,byte[]bytes,boolean add) throws IOException{ 
		 FileOutputStream fos = null; 
	        try { 
	        	fileNew(file);
	        	fos = new FileOutputStream(file,add);
	        	fos.write(bytes); 
	        	fos.flush();
	        } catch (IOException e) {
	        	throw e; 
	        } finally {
	            if (fos != null) {
	                try {
	                	fos.close();
	                } catch (IOException e) {
	                	throw e; 
	                }
	            }
	        }

	}
	/**
	 * 读取byte数据
	 * 参数1:文件地址 例如 d:/a.txt
	 * @throws Exception 
	 * */
	public static final byte[]fileReadByte(String file) throws Exception{ 
		return fileReadByte(new File(file)); 
	}

	/**
	 * 读取byte数据
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * @throws Exception 
	 * */	
	public static final byte[]fileReadByte(File file) throws Exception{
		byte[]bt=null;
		BufferedInputStream bis=null;
		FileInputStream fis=null;
		try {  
			if(file.exists()){
				fis=new FileInputStream(file);
				bis=new BufferedInputStream(fis);
				bt=new byte[(int)file.length()];
				bis.read(bt);
			} 
		} catch (Exception e) {
			throw e; 
		}finally{
			try {
				if(fis!=null){
					fis.close();
				}
				if(bis!=null){
					bis.close();
				}
				if(fis!=null){
					fis.close();
				}
				if(bis!=null){
					bis.close();
				}
			} catch (IOException e) {
				throw e; 
			}
		}
		return bt; 
	}
	/**
	 * 读取字符串数据
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 参数2:编码 
	 * @throws Exception 
	 * */
	public static final String fileReadString(File file,String encoding) throws Exception{  
			return new String(fileReadByte(file),encoding);  
	}
	/**
	 * 读取字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 参数2:编码
	 * @throws Exception 
	 * */
	public static final String fileReadString(String file,String encoding) throws Exception{  
			return fileReadString(new File(file),encoding); 
	}
	/**
	 * 读取字符串数据
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * 默认编码为"UTF-8"
	 * @throws Exception 
	 * */
	public static final String fileReadString(String file) throws Exception{  
			return fileReadString(new File(file),"UTF-8"); 
	}
	/**
	 * 读取字符串数据
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 默认编码为"UTF-8"
	 * @throws Exception 
	 * */
	public static final String fileReadString(File file) throws Exception{  
			return new String(fileReadByte(file),"UTF-8");  
	}
	/**
	 * 读取字符串数据 返回数组 一行一个
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 参数2:编码
	 * @throws Exception 
	 * */
	public static final String [] fileReadArray(File file,String encoding) throws Exception{  
			return new String(fileReadByte(file),encoding).split("\r\n"); 
	}
	/**
	 * 读取字符串数据 返回数组 一行一个
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 参数2:编码
	 * @throws Exception 
	 * */
	public static final String [] fileReadArray(String file,String encoding) throws Exception{   
		return new String(fileReadByte(new File(file)),encoding).replaceAll("\r", "").split("\n"); 
	}
	/**
	 * 读取字符串数据 返回数组 一行一个
	 * 参数1:文件地址 例如 new File("d:/a.txt")
	 * 默认编码为"UTF-8"
	 * @throws Exception 
	 * */
	public static final String [] fileReadArray(File file) throws Exception{  
			return new String(fileReadByte(file),"UTF-8").split("\r\n"); 
	}
	/**
	 * 获取文本MD5
	 * 参数1:文件地址 例如 new File("d:/a.txt") 
	 * @throws Exception 
	 * */
	public static final String fileToMd5(File file) throws Exception{
		MessageDigest m = MessageDigest.getInstance("MD5"); 
		m.update(fileReadByte(file));
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
	/**
	 * 获取文本MD5
	 * 参数1:文件地址 例如 "d:/a.txt"
	 * @throws Exception 
	 * */
	public static final String fileToMd5(String file) throws Exception{
		return fileToMd5(new File(file));
	}
	/**
	 * 获取目录下文件和目录名
	 * 参数1:目录地址 例如 "d:/a.txt"
	 * 参数2:retType 为1 返回全部 目录和文件名.为2返回文件名 为3返回目录名
	 * @throws Exception 
	 * */
	public static final List<String> fileSubNames(File file,int retType) throws Exception{
		 List<String> list=new ArrayList<String>();
		 File[] files=file.listFiles();
		 for (File f : files) {
			 if(retType==2){
				 if(f.isFile()){
					 list.add(f.getName());
				 }else{
					 continue;
				 } 
			 }else if(retType==3){
				 if(f.isDirectory()){
					 list.add(f.getName());
				 }else{
					 continue;
				 }
			 }else{
				 list.add(f.getName());
			 }
		} 
		 return list;
	}

	//压缩 参数1 被压缩文件   参数2 压缩到文件
	public static final void fileZipEncoder(String fileUrl,String target){
		ZipUtil.compress(fileUrl,target);
	}
	//压缩 参数1 被压缩目录   参数2 压缩到文件
	public static final void fileZipEncoderDir(String fileUrl,String target){
		ZipUtil.compressDir(fileUrl,target);
	}
	//解压  参数1 压缩文件    参数2 解压到 目录
	public static final void fileZipDecoder(String fileUrl,String target){
		ZipUtil.decompress(fileUrl,target);
	}
}



/**
 * java.util.zip压缩/解压文件
 * ZipUtil zip=new ZipUtil();
 * 
 * zip.compress("D:/厚街模板/文档/","D:/厚街模板/文档.zip");
 * zip.decompress("D:/厚街模板/文档.zip", "D:/厚街模板/文档2/");
 * */
class ZipUtil {
 
    /** 缓冲器大小 */
    private static final int BUFFER = 512;
  
 
    /**
     * 得到源文件路径的所有文件
     * @param dirFile 压缩源文件路径
     * */
    public static List<File>  getAllFile(File dirFile){
 
        List<File> fileList=new ArrayList<File>();
 
        File[] files= dirFile.listFiles();
        for(File file:files){//文件
            if(file.isFile()){
                fileList.add(file);
                System.out.println("add file:"+file.getName());
            }else {//目录
               if(file.listFiles().length!=0){//非空目录
                  fileList.addAll(getAllFile(file));//把递归文件加到fileList中
               }else {//空目录
                   fileList.add(file);
                   System.out.println("add empty dir:"+file.getName());
               }
            }
        }
        return fileList;
    }
 
    /**
     * 获取相对路径
     * @param dirPath 源文件路径
     * @param file 准备压缩的单个文件
     * */
    public static String getRelativePath(String dirPath,File file){
        File dirFile=new File(dirPath);
        String relativePath=file.getName();
 
        while (true){
            file=file.getParentFile();
            if(file==null) break;
            if(file.equals(dirFile)){
                break;
            }
            else {
                relativePath=file.getName()+"/"+relativePath;
            }
        }
        return relativePath;
    }
 
 
 
    /**
     *@param destPath 解压目标路径
     *@param fileName 解压文件的相对路径
     * */
    public static File createFile(String destPath, String fileName){
 
        String[] dirs = fileName.split("/");//将文件名的各级目录分解
        File file = new File(destPath);
 
        if (dirs.length > 1) {//文件有上级目录
            for (int i = 0; i < dirs.length - 1; i++) {
                file = new File(file, dirs[i]);//依次创建文件对象知道文件的上一级目录
            }
 
            if (!file.exists()) {
                file.mkdirs();//文件对应目录若不存在，则创建
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
 
            file = new File(file, dirs[dirs.length - 1]);//创建文件
 
            return file;
        } else {
            if (!file.exists()) {//若目标路径的目录不存在，则创建
                file.mkdirs();
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
 
            file = new File(file, dirs[0]);//创建文件
 
            return file;
        }
 
    }
 
    /**
     * 没有指定压缩目标路径进行压缩,用默认的路径进行压缩
     * @param dirPath 压缩源文件路径
     * */
    public static void compress(String dirPath){
 
        int firstIndex= dirPath.indexOf("/");
        int lastIndex= dirPath.lastIndexOf("/");
        String zipFileName=dirPath.substring(0,firstIndex+1)+dirPath.substring(lastIndex+1);
        compress(dirPath,zipFileName);
    }
    /**
     * 压缩文件
     * @param dirPath 压缩源文件路径
     * @param zipFileName 压缩目标文件路径
     * */
    public static void compress(String dirPath,String zipFileName){
   
        byte[] buffer=new byte[BUFFER];
        ZipEntry zipEntry=null;
        int readLength=0;     //每次读取出来的长度
 
        try {
            // 对输出文件做CRC32校验
            CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                    zipFileName), new CRC32());
            ZipOutputStream zos = new ZipOutputStream(cos);
            File file=new File(dirPath);
                    zipEntry=new ZipEntry(getRelativePath(dirPath,file));  //
                    zipEntry.setSize(file.length());
                    zipEntry.setTime(file.lastModified());
                    zos.putNextEntry(zipEntry);
 
                    InputStream is=new BufferedInputStream(new FileInputStream(file));
 
                    while ((readLength=is.read(buffer,0,BUFFER))!=-1){
                        zos.write(buffer,0,readLength);
                    }
                    is.close();
                    System.out.println("file compress:"+file.getCanonicalPath()); 
            zos.close();  //最后得关闭流，不然压缩最后一个文件会出错
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 压缩文件  目录 
     * @param dirPath 压缩源文件路径
     * @param zipFileName 压缩目标文件路径
     * */
    public static void compressDir(String dirPath,String zipFileName){
  
        File dirFile=new File(dirPath);
        List<File> fileList= getAllFile(dirFile);
 
        byte[] buffer=new byte[BUFFER];
        ZipEntry zipEntry=null;
        int readLength=0;     //每次读取出来的长度
 
        try {
            // 对输出文件做CRC32校验
            CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                    zipFileName), new CRC32());
            ZipOutputStream zos = new ZipOutputStream(cos);
 
            for(File file:fileList){
 
                if(file.isFile()){   //若是文件，则压缩文件
 
                    zipEntry=new ZipEntry(getRelativePath(dirPath,file));  //
                    zipEntry.setSize(file.length());
                    zipEntry.setTime(file.lastModified());
                    zos.putNextEntry(zipEntry);
 
                    InputStream is=new BufferedInputStream(new FileInputStream(file));
 
                    while ((readLength=is.read(buffer,0,BUFFER))!=-1){
                        zos.write(buffer,0,readLength);
                    }
                    is.close();
                    System.out.println("file compress:"+file.getCanonicalPath());
                }else {     //若是空目录，则写入zip条目中
 
                    zipEntry=new ZipEntry(getRelativePath(dirPath,file));
                    zos.putNextEntry(zipEntry);
                    System.out.println("dir compress: " + file.getCanonicalPath()+"/");
                }
            }
            zos.close();  //最后得关闭流，不然压缩最后一个文件会出错
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 解压
     * */
    public static void decompress(String zipFileName,String destPath){
 
        try {
  
            ZipInputStream zis=new ZipInputStream(new FileInputStream(zipFileName));
            ZipEntry       zipEntry       = null;
            byte[]         buffer         = new byte[BUFFER];//缓冲器
            int            readLength     = 0;//每次读出来的长度
            while ((zipEntry=zis.getNextEntry())!=null){
                if(zipEntry.isDirectory()){//若是目录
                    File file=new File(destPath+"/"+zipEntry.getName());
                    if(!file.exists()){
                        file.mkdirs();
                        System.out.println("mkdirs:"+file.getCanonicalPath());
                        continue;
                    }
                }//若是文件
                    File file = createFile(destPath,zipEntry.getName());
                    System.out.println("file created: " + file.getCanonicalPath());
                    OutputStream os=new FileOutputStream(file);
                    while ((readLength=zis.read(buffer,0,BUFFER))!=-1){
                        os.write(buffer,0,readLength);
                    }
                os.close();
                System.out.println("file uncompressed: " + file.getCanonicalPath());
            }
 
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
} 
