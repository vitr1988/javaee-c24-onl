package by.teachmeskills.lesson23.listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;

@WebListener
public class ApplicationListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
    // -- ServletContextListener
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setSessionTimeout(300);
        System.out.println("servlet context is initialized");
//        try {
//            Class.forName("<driver_name>");
//        } catch (ClassNotFoundException cnfe) {
//            cnfe.printStackTrace();
//        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context is destroyed");
    }

    // -- ServletContextListener

    // -- HttpSessionAttributeListener
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was added".formatted(event.getName()));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was removed".formatted(event.getName()));

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attribute %s was replaced".formatted(event.getName()));
    }
    // -- HttpSessionAttributeListener

    // -- HttpSessionListener

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("startedAt", LocalDateTime.now());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session was discarded during "// + LocalDateTime.now().minus()
        );
    }


    // -- HttpSessionListener
}
