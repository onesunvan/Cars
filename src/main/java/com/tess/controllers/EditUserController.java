/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tess.controllers;

import com.tess.entities.User;
import com.tess.forms.UserEditForm;
import com.tess.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ivan
 */
@Controller
public class EditUserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/editUser", method = RequestMethod.GET) 
    public String showEditForm(@ModelAttribute("user") UserEditForm user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User userEntity = userService.getUserByName(name);
        user.setEmail(userEntity.getUserInformation().getEmail());
        user.setPassport(userEntity.getUserInformation().getPassport());
        user.setFirstName(userEntity.getUserInformation().getFirstName());
        user.setLastName(userEntity.getUserInformation().getLastName());
        return "user_edit";
    }
    
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") @Valid UserEditForm user, BindingResult bindingResult) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (bindingResult.hasErrors()) {
            return "user_edit";
        } else {
            if (!userService.isOldPasswordValid(user.getOldPassword(),
                    username)) {
                bindingResult.rejectValue("oldPassword", "useredit.oldpassword");
                return "user_edit";
            }
            userService.updateUserByUserEditForm(username, user);
            return "redirect:/";
        }
    }
}
