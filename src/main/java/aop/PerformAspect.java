/**
 * 
 */
package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * 2017Äê12ÔÂ18ÈÕ
 */
@Component("performAspect")
@Aspect
public class PerformAspect {
	
	@Pointcut("execution(* aop.*.*(..))")
	public void performPointCut(){}
	
	@Before(value="performPointCut()")
	public void performBefore(){
		System.out.println("performBefore...standup,clap.clap.clap");
	}
	
	@AfterReturning(value="performPointCut()")
	public void performAfter(){
		System.out.println("performAfter...sitdown,clap.clap.clap");
	}
	
	@After(value="performPointCut()")
	public void performLast(){
		System.out.println("performLast...all.go.go.go");
	}

}
