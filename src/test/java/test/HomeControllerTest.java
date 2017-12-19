/**
 * 
 */
package test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import controller.HomeController;

/**
 * @author admin
 * 2017Äê11ÔÂ22ÈÕ
 */
public class HomeControllerTest {
	
	@Test
	public void testHomePage() throws Exception{
		HomeController homeController=new HomeController();
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(homeController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/homepage")).andExpect(MockMvcResultMatchers.view().name("home"));
	}

}
