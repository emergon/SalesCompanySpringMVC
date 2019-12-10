package com.emergon.service;

import com.emergon.entities.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    public User validateUser(User user){
        String uname = user.getUsername();
        String pass = user.getPassword();
        boolean result = uname.equals("admin") && pass.equals("1234");
        if(result){
            return user;
        }
        return null;
    }
    
}
