/**
 * 
 */
package properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author admin
 * 2017年11月21日
 */
@Configuration
@ComponentScan(basePackages={"properties"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})

public class RootConfig {

}
