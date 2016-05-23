package carshow.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carshow.dto.UserDTO;
import carshow.entities.UserInformation;
import carshow.services.UserService;

/**
 *
 * @author ivan
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/userDatas")
    public String getUserDatas(Model model) {
        String username = SecurityContextHolder.getContext()
                .getAuthentication().getName();
        if (username.equals("anonymousUser")) {
            return "user-datas";
        }
        UserInformation user = userService.getUserByName(username)
                .getUserInformation();
        UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber());
        model.addAttribute("userDTO", userDTO);
        return "user-datas";
    }
    
    @RequestMapping(value = "/users/{name}/img", method = RequestMethod.GET)
    public void getUserAvatar(@PathVariable("name") String name, HttpServletRequest req, HttpServletResponse res,
    		Model model, Principal principal, SecurityContextHolderAwareRequestWrapper request) throws IOException {
    	if (request.isUserInRole("ROLE_USER") && !name.equals(request.getUserPrincipal().getName())) {
			return;
    	}
    	byte[] carImage = userService.getUserByName(name)
                .getUserInformation().getImage();
		res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        res.getOutputStream().write(carImage);
        res.getOutputStream().close();
    }
}
