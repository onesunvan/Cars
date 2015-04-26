package com.tess.controllers;

import com.tess.entities.Car;
import com.tess.services.CarNotFoundException;
import com.tess.services.CarService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ivan
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/carImg/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") Long id, HttpServletRequest req,
            HttpServletResponse res) throws ServletException, IOException {
        byte[] carImage = carService.getCarImageById(id);
        res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        res.getOutputStream().write(carImage);
        res.getOutputStream().close();
    }

    @RequestMapping(value = "/cars")
    public String getCars(@RequestParam(value = "number") Integer number,
            @RequestParam(value = "filter", required = false) String filter, Model model,
            SecurityContextHolderAwareRequestWrapper request) {
        List<Car> cars;
        if (filter != null) {
            if (request.isUserInRole("ROLE_ADMIN")) {
                System.out.println("Admin with Filter");
                cars = carService.getCarsOnPageLike(number, filter);
            } else {
                System.out.println("Not Admin with Filter");
                cars = carService.getCarsOnPageLikeIfExists(number, filter);
            }
        } else {
            if (request.isUserInRole("ROLE_ADMIN")) {
                System.out.println("Admin");
                cars = carService.getCarsOnPage(number);
            } else {
                System.out.println("Not Admin");
                cars = carService.getCarsOnPageIfExists(number);
            }
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
    
    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public String showCar(@PathVariable("id") Integer id, Model model) {
        Car car = carService.getCarById(new Long(id));
        model.addAttribute("car", car);
        return "car";
    }
     
    @ExceptionHandler(CarNotFoundException.class)
    public ModelAndView carNotFound(CarNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("errorpage");
        modelAndView.addObject("message", "carnotfound");
        return modelAndView;
    }
    
}
