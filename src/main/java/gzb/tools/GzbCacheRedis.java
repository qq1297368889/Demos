package gzb.tools;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class GzbCacheRedis implements GzbCache{

	private static JedisPool jedisPool=null;
	static{
		try {
			int id=1;
			String dbConfigUrl=Info.getWebClassPath()+ "config.ini";
			JedisPoolConfig config = new JedisPoolConfig();

			// 设置最大连接数 30
			config.setMaxTotal(Integer.valueOf(TextTool.configGet(dbConfigUrl, "redis_"+id+"_最大连接数")));
			// 设置最大的空闲连接数  10
			config.setMaxIdle(Integer.valueOf(TextTool.configGet(dbConfigUrl, "redis_"+id+"_空闲连接数")));
			//ip "127.0.0.1"  prot 6379
			jedisPool = new JedisPool(config,TextTool.configGet(dbConfigUrl, "redis_"+id+"_地址"),
					Integer.valueOf(TextTool.configGet(dbConfigUrl, "redis_"+id+"_端口")));
			System.out.println("redis,初始化成功");
		} catch (Exception e) { 
			e.printStackTrace();
			System.out.println("redis,初始化失败"+e);
		}
		
	}
	public Long getIncr(String key){  
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource();  
			return jedis.incr(key);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally { 
			if(jedis != null){jedis.close();} 
		} 
	}
	public Object get(String key){  
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource();
			
			return jedis.get(key);
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally { 
			if(jedis != null){jedis.close();} 
		} 
	}
	public Object get(String key,int mm){  
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource();
			String val=jedis.get(key); 
			if(val==null){
				return null;
			}   
			//jedis.expire(key, mm); 
			return val;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally { 
			if(jedis != null){jedis.close();} 
		} 
	}
	public void set(String key,Object val){  
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource(); 
			val=val==null ? "":val;
			jedis.set(key, val.toString()); 
		} catch (Exception e){
			e.printStackTrace(); 
		} finally { 
			if(jedis != null){jedis.close();} 
		} 
	}
	public void set(String key,Object val,int mm){  
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource(); 
			val=val==null ? "":val;
			jedis.set(key, val.toString(), "NX", "PX", mm * 1000);
		} catch (Exception e){
			e.printStackTrace(); 
		} finally {
			if(jedis != null){jedis.close();} 
		} 
	}
	@Override
	public Object del(String key) {
		Jedis jedis = null;
		try{ 
			jedis = jedisPool.getResource(); 
			Object obj=jedis.get(key);
			jedis.del(key);
			return obj;
		} catch (Exception e){
			e.printStackTrace(); 
		} finally {
			if(jedis != null){jedis.close();} 
		} 
		return null;
	}
	
	
}