package javabsic;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisUseInJava {
	 
	public static void main(String[] args){
		Jedis jedis=new Jedis("localhost");
		System.out.println("connection success");
		System.out.println("server is running:"+jedis.ping());
		//redis javaString
		jedis.set("testString", "chaochao");
		System.out.println("testString:"+jedis.get("testString"));
		//list
		jedis.lpush("slist", "redis");
		jedis.lpush("slist", "redi");
		jedis.lpush("slist", "red");
		List<String> list=jedis.lrange("slist", 0, 2);
		for(int i=0;i<list.size();i++){
			System.out.println("list:--"+list.get(i));
		}
		//set
		Set<String> keys=jedis.keys("*");
		Iterator<String> it=keys.iterator();
		while(it.hasNext()){
			String key=it.next();
			System.out.println(key);
		}
	}
}
