package step3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * web application 종료 직전에 호출
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("contextDestroyed");
    }

	/**
     * web application 시작 시점에 호출
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	String security = event.getServletContext().getInitParameter("appSecurity");
    	System.out.println("contextInitialized security info" +security);
    }
	
}
