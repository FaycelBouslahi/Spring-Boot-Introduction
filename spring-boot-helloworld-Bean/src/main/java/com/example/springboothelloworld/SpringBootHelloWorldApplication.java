package com.example.springboothelloworld;

import com.example.springboothelloworld.servlet.HelloFilter;
import com.example.springboothelloworld.servlet.HelloListener;
import com.example.springboothelloworld.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }

    /// Register Servlet.
    @Bean
    public ServletRegistrationBean<HelloServlet> getServletRegistrationBean() {
        ServletRegistrationBean<HelloServlet> servletBean = new ServletRegistrationBean<>(new HelloServlet());
        servletBean.addUrlMappings("/helloServlet");
        return servletBean;
    }

    /// Register Filter.
    @Bean
    public FilterRegistrationBean<HelloFilter> getFilterRegistrationBean() {
        FilterRegistrationBean<HelloFilter> filterBean = new FilterRegistrationBean<>(new HelloFilter());
        // Add filter path
        filterBean.addUrlPatterns("/helloServlet");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new HelloListener());
    }

}
