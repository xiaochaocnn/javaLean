/**
 * 
 */
package spring.wringbean;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * 2017年11月3日
 */
@Component
public class Sgtppers implements CompactDisc{
	
	private String title="dang";
	private String artist="liuxing";

	/* (non-Javadoc)
	 * @see spring.wringbean.CompactDisc#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing"+title+"by"+artist);
	}

}
