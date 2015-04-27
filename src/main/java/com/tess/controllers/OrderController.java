package com.tess.controllers;

import com.tess.entities.Car;
import com.tess.entities.Orders;
import com.tess.entities.User;
import com.tess.services.CarService;
import com.tess.services.OrderService;
import com.tess.services.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ivan
 */
@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CarService carService;
    
    @RequestMapping(value = "/bookCar")
    public String bookCar(@RequestParam("carId") Integer id, Principal principal,
            Model model, final RedirectAttributes redirectAttributes) {
        User user = userService.getUserByName(principal.getName());
        Car car = carService.getCarById(new Long(id));
        orderService.makeAnOrder(user, car);
        redirectAttributes.addFlashAttribute("successMessage", "ordercar.success");
        return "redirect:/";
    }
    
    @RequestMapping(value = "/showOrders")
    public String showOrders(@RequestParam("pageNumber") Integer pageNumber, Model model) {
        List<Orders> orders = orderService.getOrdersOnPage(pageNumber);
        model.addAttribute("orders", orders);
        return "orders";        
    }
    
    @RequestMapping("/generateException")
    public String generateException() {
        throw new RuntimeException("custom exception");
    }
    
    
    @ExceptionHandler(IllegalStateException.class)
    public ModelAndView carNotFound(IllegalStateException exception) {
        ModelAndView modelAndView = new ModelAndView("errorpage");
        modelAndView.addObject("code", "carnotfound");
        return modelAndView;
    }
    
}
