package carshow.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carshow.entities.Car;
import carshow.forms.CarForm;
import carshow.images.ImageUtil;
import carshow.services.CarService;

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
            Model model, final RedirectAttributes redirectAttributes) {
        List<String> imageErrors = new LinkedList<>();
        byte[] imageBytes = ImageUtil.validateImage(image, imageErrors);
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
            carEntity.setIfExists(Boolean.TRUE);
            carService.saveCar(carEntity);
            redirectAttributes.addFlashAttribute("successMessage", "addcontent.success");
            return "redirect:/";
        }
    }
    
    
    
}
