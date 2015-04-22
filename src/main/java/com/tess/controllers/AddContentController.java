package com.tess.controllers;

import com.tess.entities.Car;
import com.tess.forms.CarForm;
import com.tess.services.CarService;
import com.tess.services.UsernameExistException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ivan
 */
@Controller
@RequestMapping(value = "/addContent")
public class AddContentController {
    
    @Autowired
    private CarService carService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String showAddContent(@ModelAttribute("car") CarForm car) {
        return "add-content";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addContent(@ModelAttribute("car") @Valid CarForm car, BindingResult bindingResult,
            @RequestParam(value = "uploadFile") MultipartFile image,
            Model model) {
        List<String> imageErrors = new LinkedList<>();
        byte[] imageBytes = validateImage(image, imageErrors);
        if (!imageErrors.isEmpty()) {
            model.addAttribute("imageErrors", imageErrors);
        }
        if (bindingResult.hasErrors()) {
            return "add-content";
        } else {
            if (!imageErrors.isEmpty()) {
                return "add-content";
            }
            Car carEntity = new Car(car.getBrand(), car.getModel(), 
                    car.getPrice(), imageBytes);
            carService.saveCar(carEntity);
            return "redirect:/";
        }
    }
    
    
    private byte[] validateImage(MultipartFile image, List<String> errors) {
        if (image.isEmpty()) {
            errors.add("addcontent.imageempty");
        } else if (!image.getContentType().equals("image/jpeg")) {
            errors.add("addcontent.notjpeg");
        }
        byte[] imageBytes = {};
        try {
            imageBytes = image.getBytes();
        } catch (IOException ex) {
            errors.add("addcontent.jpgerror");
        }
        return imageBytes;
    }
}
