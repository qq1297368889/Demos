package gzb.tools;
public interface GzbCache {
//根据key  获取一个唯一自增数字 
	public Long getIncr(String key);
	//根据key  获取值
	public Object get(String key);
	//根据key  获取值 并修改失效时间  
	public Object get(String key,int mm);
	//根据key  修改或新增值
	public void set(String key,Object val);
	//根据key  修改或新增值 并修改或指定失效时间  
	public void set(String key,Object val,int mm); 
	//根据key  删除
	public Object del(String key);
}
