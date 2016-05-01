package com.tess.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tess.entities.Car;
import com.tess.entities.CarOrder;
import com.tess.entities.User;
import com.tess.exceptions.OrderNotFoundException;
import com.tess.services.CarService;
import com.tess.services.OrderService;
import com.tess.services.UserService;

/**
 *
 * @author ivan
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private CarService carService;

	@RequestMapping(method = RequestMethod.POST)
	public String postOrder(@RequestParam("carId") Integer carId, Principal principal, Model model,
			final RedirectAttributes redirectAttributes) {
		User user = userService.getUserByName(principal.getName());
		Car car = carService.getCarById(Long.valueOf(carId));
		orderService.makeAnOrder(user, car);
		redirectAttributes.addFlashAttribute("successMessage", "ordercar.success");
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getOrders(@RequestParam(value = "pageNumber", required = false) Integer pageNumber, Model model,
			Principal principal, SecurityContextHolderAwareRequestWrapper request) {
		if (pageNumber == null) {
			pageNumber = 1;
		}
		List<CarOrder> orders;
		Long amount;
		if (request.isUserInRole("ROLE_USER")) {
			orders = orderService.getUserOrdersOnPage(pageNumber, principal.getName());
			amount = orderService.getAmountOfUserOrders(principal.getName());
		} else {
			orders = orderService.getOrdersOnPage(pageNumber);
			amount = orderService.getAmountOfOrders();
		}
		model.addAttribute("orders", orders);
		model.addAttribute("amount", amount);
		model.addAttribute("pageNumber", pageNumber);
		return "orders";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String orderAction(@PathVariable("id") Integer id, @RequestParam("action") String action, Model model,
			RedirectAttributes redirectAttributes, Principal principal,
			SecurityContextHolderAwareRequestWrapper request) {
		try {
			if (request.isUserInRole("ROLE_ADMIN")) {
				switch (action) {
				case "accept":
					orderService.acceptOrder(Long.valueOf(id));
					redirectAttributes.addFlashAttribute("successMessage", "orders.accepted");
					break;
				case "decline":
					orderService.declineOrder(Long.valueOf(id));
					redirectAttributes.addFlashAttribute("successMessage", "orders.declined");
					break;
				default:
					return "redirect:/403";
				}
			} else if (request.isUserInRole("ROLE_USER")) {
				
			}
			return "redirect:/orders";
		} catch (IllegalStateException ex) {
			return "redirect:/403";
		} catch (OrderNotFoundException ex) {
			model.addAttribute("code", "order.ordernotfound");
			return "errorpage";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showOrderDetail(@PathVariable("id") Integer id, Model model, Principal principal,
			SecurityContextHolderAwareRequestWrapper request) {
		try {
			CarOrder order;
			if (request.isUserInRole("ROLE_USER")) {
				order = orderService.getUserOrder(Long.valueOf(id), principal.getName());
			} else {
				order = orderService.getOrder(Long.valueOf(id));
			}
			model.addAttribute("order", order);
			return "order-detail";
		} catch (OrderNotFoundException ex) {
			model.addAttribute("code", "order.ordernotfound");
			return "errorpage";
		}
	}
}
