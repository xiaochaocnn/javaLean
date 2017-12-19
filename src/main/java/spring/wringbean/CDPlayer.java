/**
 * 
 */
package spring.wringbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * 2017年11月6日
 */
@Component
public class CDPlayer implements MediaPlayer {
  
	private CompactDisc cd;
	
	@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd=cd;;
		
	}
	
	public void play(){
		cd.play();
	}

}
