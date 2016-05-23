/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshow.controllers;

import carshow.entities.User;
import carshow.forms.UserCreditinalsForm;
import carshow.forms.UserPasswordForm;
import carshow.images.ImageUtil;
import carshow.services.UserService;

import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ivan
 */
@Controller
public class EditUserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/editUser", method = RequestMethod.GET) 
    public String showEditForm(@ModelAttribute("user") UserCreditinalsForm user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User userEntity = userService.getUserByName(name);
        user.setEmail(userEntity.getUserInformation().getEmail());
        user.setPhoneNumber(userEntity.getUserInformation().getPhoneNumber());
        user.setFirstName(userEntity.getUserInformation().getFirstName());
        user.setLastName(userEntity.getUserInformation().getLastName());
        return "user_edit";
    }
    
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") @Valid UserCreditinalsForm user, 
            BindingResult bindingResult, 
            @RequestParam(value = "uploadFile") MultipartFile image, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<String> imageErrors = new LinkedList<>();
        byte[] imageBytes = null;
        if (!image.isEmpty()) {
            imageBytes = ImageUtil.validateImage(image, imageErrors);
        }
        if (!imageErrors.isEmpty()) {
            model.addAttribute("imageErrors", imageErrors);
        }
        if (bindingResult.hasErrors()) {
            return "user_edit";
        } else {
            if (!imageErrors.isEmpty()) {
                return "add-content";
            }
            userService.updateUserByUserCreditinalsForm(username, user, imageBytes);
            return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/editPassword", method = RequestMethod.GET) 
    public String showEditForm(@ModelAttribute("user") UserPasswordForm user) {
        return "edit-password";
    }
    
     @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    public String editUserPassword(@ModelAttribute("user") @Valid UserPasswordForm user, 
            BindingResult bindingResult) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (bindingResult.hasErrors()) {
            return "edit-password";
        } else {
            if (!userService.isOldPasswordValid(user.getOldPassword(),
                    username)) {
                bindingResult.rejectValue("oldPassword", "useredit.oldpassword");
                return "edit-password";
            }
            userService.updateUserPassword(username, user.getPassword());
            return "redirect:/";
        }
    }
}
