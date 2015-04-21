package com.tess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ivan
 */
@Controller
public class WelcomeController {
    
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    String showWelcomePage() {
        return "welcome";
    }
}
