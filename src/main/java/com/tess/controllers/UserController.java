package com.tess.controllers;

import com.tess.dto.UserDTO;
import com.tess.entities.UserInformation;
import com.tess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ivan
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/userDatas")
    public String getUserDatas(Model model) {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        if (username.equals("anonymousUser")) {
            return "user-datas";
        }
        System.out.println(username);
        UserInformation user = userService.getUserByName(username)
                .getUserInformation();
        UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassport());
        model.addAttribute("userDTO", userDTO);
        return "user-datas";
    }
}
