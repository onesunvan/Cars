package carshow.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    public static final String DEFAULT_ERROR_VIEW = "errorpage";

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
            ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject("code", "resource.not.found");
        mav.addObject("exception_message", e.toString());
        return mav;
    }
}