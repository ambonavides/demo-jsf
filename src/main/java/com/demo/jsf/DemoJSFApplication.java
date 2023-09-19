package com.demo.jsf;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoJSFApplication {

    public static void main (String[] args) {
        SpringApplication.run(DemoJSFApplication.class, args);
    }

    @Bean
    ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        ServletRegistrationBean srb = getServletRegistrationBean();
        return srb;
    }

	private ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.html", "*.jsf", "*.xhtml"));
        srb.setLoadOnStartup(1);
		return srb;
	}
	
}