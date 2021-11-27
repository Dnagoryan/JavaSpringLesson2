package ru.gb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


@Slf4j
public class WebConfig implements WebApplicationInitializer {

    public static final String DISPATCHER_SERVLET_NAME= "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
      log.info("onStartUp");
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class);
        DispatcherServlet servlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}
