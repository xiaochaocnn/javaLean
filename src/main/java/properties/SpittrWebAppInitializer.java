/**
 * 
 */
package properties;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author admin
 * 2017Äê11ÔÂ22ÈÕ
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{ RootConfig.class };
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{WebConfig.class};
    }

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
     */
    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[]{"/"};
    }
}
