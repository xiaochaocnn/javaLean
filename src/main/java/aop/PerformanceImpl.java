/**
 * 
 */
package aop;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * 2017Äê12ÔÂ18ÈÕ
 */
@Service("performance")
public class PerformanceImpl implements Performance{
	/* (non-Javadoc)
	 * @see aop.Performance#perform()
	 */
	@Override
	public void perform() {
       System.out.println("Performance....Perform");		
	}

}
