/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergon.configuration;

import com.emergon.entities.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author anastasios
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        boolean requestLogin = request.getRequestURI().contains("login")||request.getRequestURI().contains("logout");
        if ((!requestLogin && (user == null||user.getUsername()==null))) {
            response.sendRedirect(request.getContextPath() +"/login");
        }
    }

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return super.preHandle(request, response, handler); //To change body of generated methods, choose Tools | Templates.
//    }

}
