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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String showOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            Model model) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        List<Orders> orders = orderService.getOrdersOnPage(pageNumber);
        model.addAttribute("orders", orders);
        model.addAttribute("amount", orderService.getAmountOfOrders());
        model.addAttribute("pageNumber", pageNumber);
        return "orders";        
    }
    
    @RequestMapping(value = "/showMyOrders")
    public String showMyOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            Model model, Principal principal) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        List<Orders> orders = orderService.getUserOrdersOnPage(pageNumber, principal.getName());
        model.addAttribute("orders", orders);
        model.addAttribute("amount", orderService.getAmountOfUserOrders(principal.getName()));
        model.addAttribute("pageNumber", pageNumber);
        return "orders";        
    }
    
    @RequestMapping(value = "/acceptOrder/{id}")
    public String acceptOrder(@PathVariable("id") Integer id,
            Model model, final RedirectAttributes redirectAttributes) {
        orderService.acceptOrder(new Long(id));
        redirectAttributes.addFlashAttribute("successMessage", "orders.accepted");
        return "redirect:/showOrders";
    }
    
    @RequestMapping(value = "/declineOrder/{id}")
    public String declineOrder(@PathVariable("id") Integer id,
            Model model, final RedirectAttributes redirectAttributes) {
        orderService.declineOrder(new Long(id));
        redirectAttributes.addFlashAttribute("successMessage", "orders.declined");
        return "redirect:/showOrders";
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ModelAndView carNotFound(IllegalStateException exception) {
        ModelAndView modelAndView = new ModelAndView("errorpage");
        modelAndView.addObject("code", "order.ordersnotfound");
        return modelAndView;
    }
    
}
