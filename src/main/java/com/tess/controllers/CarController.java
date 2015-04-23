package com.tess.controllers;

import com.tess.services.CarService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
