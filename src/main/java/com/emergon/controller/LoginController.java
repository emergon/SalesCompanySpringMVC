package com.emergon.controller;

import com.emergon.entities.User;
import com.emergon.service.LoginService;
import com.emergon.validator.UserValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class LoginController {
    
    @Autowired
    LoginService service;
    @Autowired
    UserValidator userValidator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }
    
    @ModelAttribute("user")
    public User user(){
        return new User();
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println("->>>>>>>>>>"+result.getAllErrors());
            return "login";
        }
        User u = service.validateUser(user);
        if(u != null){
            return "redirect:/";
        }
        model.addAttribute("message", "Invalid username/password");
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:/login";
    }
    
    
}
