package com.bus;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bus.filter.BusFilter;

import javax.jms.ConnectionFactory;




@Configuration
@EnableWebMvc
@EnableJms
public class BusConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFilter()).addPathPatterns("/*");
    }

    @Bean
    public BusFilter getFilter() {
        return new BusFilter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616"); // ActiveMQ broker URL
        connectionFactory.setUserName("admin"); // ActiveMQ username
        connectionFactory.setPassword("admin"); // ActiveMQ password
        return connectionFactory;
    }

    // You can add other JMS-related beans or configurations here if needed.
}
