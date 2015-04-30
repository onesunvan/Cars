package com.tess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ivan
 */
@Controller
public class AdminController {
    
    @RequestMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }
}
