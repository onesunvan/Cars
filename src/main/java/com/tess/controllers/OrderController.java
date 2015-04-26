package com.tess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ivan
 */
@Controller
public class OrderController {
    
    @RequestMapping(value = "/bookCar")
    public String bookCar() {
        return "redirect:/";
    }
}
