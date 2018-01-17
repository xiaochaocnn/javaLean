/**
 * 
 */
package spring.wringbean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.Performance;

/**
 * @author admin 2017年11月3日
 */
@Configuration
@ComponentScan(basePackages = { "spring" })
public class CDPlayerConfig {

	@Autowired
	private CDPlayer cdPlayer;

	/*
	 * @Test public void test(){ ClassPathXmlApplicationContext appcontext=new
	 * ClassPathXmlApplicationContext("beans.xml"); CDPlayer cdPlayer=(CDPlayer)
	 * appcontext.getBean("cDPlayer"); cdPlayer.play(); }
	 */
}
