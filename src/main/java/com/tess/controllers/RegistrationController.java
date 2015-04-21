package com.tess.controllers;

import com.tess.entities.User;
import com.tess.forms.UserForm;
import com.tess.services.UserService;
import com.tess.services.UsernameExistException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ivan
 */
@Controller
public class RegistrationController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String showRegistrationPage(@ModelAttribute("user") UserForm user) {
        return "registration";
    }
    
    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid UserForm user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            try {
                userService.registerNewUser(user);
            } catch (UsernameExistException ex) {
                bindingResult.addError(new ObjectError("username", "registration.usernameexists"));
                return "registration";
            }
            return "redirect:/";
        }
    }
}
