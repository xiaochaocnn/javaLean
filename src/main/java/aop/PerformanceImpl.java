/**
 * 
 */
package aop;

import org.springframework.stereotype.Service;

/**
 * @author admin
 * 2017��12��18��
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
