package com.emergon.configuration;
/*
References:
https://docs.spring.io/spring/docs/ Spring Documentation ALL VERSIONS
https://stackoverflow.com/questions/35258758/getservletconfigclasses-vs-getrootconfigclasses-when-extending-abstractannot Difference between methods
https://stackoverflow.com/questions/5132604/why-use-spring-applicationcontext-hierarchies/5132637#5132637 Spring App Hierarchies
*/
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class[] configClassesForAll = {};
        return configClassesForAll;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] configClassesForThisServlet = {MyWebAppConfig.class};
        return configClassesForThisServlet;
    }

    @Override
    protected String[] getServletMappings() {
        String[] urlMapping = {"/"};
        return urlMapping;
    }

}
