
package com.emergon.validator;

import com.emergon.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/* @author emergon */
@Component
public class UserValidator implements Validator{

    /**
    * This Validator validates *just* User instances
    */
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "username", "username.empty");
        User u = (User) target;
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        /*
        (?=.*[0-9]) a digit must occur at least once
    (?=.*[a-z]) a lower case letter must occur at least once
    (?=.*[A-Z]) an upper case letter must occur at least once
    (?=.*[@#$%^&+=]) a special character must occur at least once
    (?=\\S+$) no whitespace allowed in the entire string
    .{8,} at least 8 characters
        */
        if(!u.getPassword().matches("(?=.*[0-9])")){
            errors.rejectValue("password", "pass.no.digit");
        }else if(!u.getPassword().matches("(?=.*[a-z])")){
            errors.rejectValue("password", "pass.no.lower");
        }else if(!u.getPassword().matches("(?=.*[A-Z])")){
            errors.rejectValue("password", "pass.no.upper");
        }else if(!u.getPassword().matches("(?=.*[@#$%^&+=])")){
            errors.rejectValue("password", "pass.no.special");
        }else if(!u.getPassword().matches("(?=\\\\S+$)")){
            errors.rejectValue("password", "pass.no.whitespace");
        }else if(!u.getPassword().matches(".{8,}")){
            errors.rejectValue("password", "pass.no.large");
        }
//        if (u.getPassword().length()< 4) {
//            errors.rejectValue("password", "password.too.short");
//        } else if (u.getPassword().length() > 6) {
//            errors.rejectValue("password", "pass.too.large", "too large");
//        }
    }

}
