package carshow.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carshow.entities.Car;
import carshow.exceptions.CarNotFoundException;
import carshow.services.CarService;

/**
 *
 * @author ivan
 */
@Controller
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/{id}/img", method = RequestMethod.GET)
	public void getImage(@PathVariable("id") Long id, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		byte[] carImage = carService.getCarImageById(id);
		res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		res.getOutputStream().write(carImage);
		res.getOutputStream().close();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCars(@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "filter", required = false) String filter, Model model,
			SecurityContextHolderAwareRequestWrapper request) {
		List<Car> cars;
		if (number == null) {
			number = 1;
		}
		if (filter != null) {
			if (request.isUserInRole("ROLE_ADMIN")) {
				cars = carService.getCarsOnPageLike(number, filter);
			} else {
				cars = carService.getCarsOnPageLikeIfExists(number, filter);
			}
		} else {
			if (request.isUserInRole("ROLE_ADMIN")) {
				cars = carService.getCarsOnPage(number);
			} else {
				cars = carService.getCarsOnPageIfExists(number);
			}
		}
		model.addAttribute("cars", cars);
		return "cars";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable("id") Integer id, Model model) {
		try {
			Car car = carService.getCarById(Long.valueOf(id));
			model.addAttribute("car", car);
			return "car";
		} catch (CarNotFoundException ex) {
			model.addAttribute("code", "carnotfound");
			return "errorpage";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String carAction(@RequestParam("action") String action, @PathVariable("id") Integer id,
			Model model, RedirectAttributes redirectAttributes,
			Principal principal, SecurityContextHolderAwareRequestWrapper request) {
		try {
			if (request.isUserInRole("ROLE_ADMIN")) {
				switch (action) {
				case "disable":
					carService.disableCar(Long.valueOf(id));
					redirectAttributes.addFlashAttribute("successMessage", "car.cardeleted");
					return "redirect:/";
				case "restore":
					carService.restoreCar(Long.valueOf(id));
					redirectAttributes.addFlashAttribute("successMessage", "car.carrestored");
					return "redirect:/";
				}
			}
		} catch (CarNotFoundException ex) {
			model.addAttribute("code", "carnotfound");
			return "errorpage";
		}
		return "redirect:/403";
	}
}
