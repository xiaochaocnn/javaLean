/**
 * 
 */
package aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * 2017Äê12ÔÂ18ÈÕ
 */
public class PerformTest {
	
	@Test
	public void performTest(){
		ClassPathXmlApplicationContext appcontext=new ClassPathXmlApplicationContext("beans.xml");
		Performance perform=(Performance) appcontext.getBean("performance");
		try{
		perform.perform();
		}catch(Exception e){
			
		}finally{
		  
		}
	}

}
