package com.tess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ivan
 */
@Controller
public class WelcomeController {
    
    @RequestMapping(value = {"/", "/welcome"})
    String showWelcomePage(@RequestParam(value = "filter", required = false) String filter, Model model) {
        if (filter != null) {
            model.addAttribute("filter", filter);
        }
        return "welcome";
    }
}
