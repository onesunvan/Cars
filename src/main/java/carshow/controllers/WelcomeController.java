package carshow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
