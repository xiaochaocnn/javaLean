/**
 * 
 */
package spring.wringbean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author admin
 * 2017年11月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayTest {
   @Autowired
   private CompactDisc cd;
   @Autowired
   private MediaPlayer player;
   
   @Test
   public void CDNotNull(){
	   assertNotNull(cd);
   }
   
   @Test
   public void play(){
	   player.play();
   }

}
