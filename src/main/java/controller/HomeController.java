/**
 * 
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author admin
 * 2017��11��22��
 */
@Controller
public class HomeController {
	@RequestMapping(value={"/","/homepage"},method=RequestMethod.GET)
	public String home(){
		System.out.println("homeController......");
		return "home";
	}

}
