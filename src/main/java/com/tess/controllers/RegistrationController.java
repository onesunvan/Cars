package com.tess.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tess.exceptions.UsernameExistException;
import com.tess.forms.UserForm;
import com.tess.images.ImageUtil;
import com.tess.services.UserService;

/**
 *
 * @author ivan
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(@ModelAttribute("user") UserForm user) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid UserForm user, 
            BindingResult bindingResult, @RequestParam(value = "uploadFile") MultipartFile image,
            Model model, final RedirectAttributes redirectAttributes) {
        List<String> imageErrors = new LinkedList<>();
        byte[] imageBytes = ImageUtil.validateImage(image, imageErrors);
        if (!imageErrors.isEmpty()) {
            model.addAttribute("imageErrors", imageErrors);
        }
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "registration";
        } else {
            if (!imageErrors.isEmpty()) {
                return "registration";
            }
            try {
                userService.registerNewUser(user, imageBytes);
            } catch (UsernameExistException ex) {
                bindingResult.rejectValue("username", "registration.usernameexists");
                return "registration";
            }
            redirectAttributes.addFlashAttribute("successMessage", "registration.success");
            return "redirect:/";
        }
    }
    
    @RequestMapping(value = "/avatarImg", method = RequestMethod.GET)
    public void getImage(HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        byte[] carImage = userService.getUserByName(
                    SecurityContextHolder.getContext().getAuthentication().getName())
                .getUserInformation().getImage();
        res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        res.getOutputStream().write(carImage);
        res.getOutputStream().close();
    }
}
