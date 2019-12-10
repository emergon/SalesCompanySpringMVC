package com.emergon.configuration;

/*
References:
https://www.javaspringclub.com/spring-mvc-hibernate-mysql-example/

Optional:
http://www.javasavvy.com/spring-4-mvc-hibernate-jpa-java-config-tutorial/
https://howtodoinjava.com/jpa/spring-hibernate-jpa-configuration-example/   Full XML Example
 */
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.emergon")
public class MyWebAppConfig implements WebMvcConfigurer {//WebMvcConfigurerAdapter is deprecated in Spring 5

    //Default view resolver is /WEB-INF/*.jsp
    //If we want to override it, then we can use this method
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //viewResolver.setViewClass(JstlView.class);//Not any more required
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    /**
     * This method is used to Add handlers to serve static resources such as
     * images, js, and, css files from specific locations under web application
     * root All requests for resources coming in with a public URL pattern like
     * "/static/**" by searching in the “/static/” directory under the root
     * folder in our application. Stars ** are used to search this folder
     * recursively.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    MyInterceptor myInterceptor() {
         return new MyInterceptor();
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }
}
