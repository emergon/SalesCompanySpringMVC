package com.emergon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    /*
    Parameters that can be used in methods
    Model, ModelAndView, HttpServletRequest
    */
    @RequestMapping(method = RequestMethod.GET)//if attribute method is not used, then this method will process ALL requests(GET,POST,...)
    public ModelAndView homePage(ModelAndView model){
        model.setViewName("index");
        return model;
    }
}
