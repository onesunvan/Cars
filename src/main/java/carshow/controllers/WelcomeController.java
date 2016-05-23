package carshow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ivan
 */
@Controller
public class WelcomeController {
    
    @RequestMapping("/")
    String showWelcomePage() {
        return "forward:/cars";
    }
}
