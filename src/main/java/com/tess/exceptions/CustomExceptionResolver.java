package com.tess.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex) {
		return getCustomModelAndView(viewName, ex, null);
	}
	
	@Override
	protected ModelAndView getModelAndView(String viewName, Exception ex,
			HttpServletRequest request) {
		return getCustomModelAndView(viewName, ex, request);
	}
	
	private ModelAndView getCustomModelAndView(String viewName, Exception ex,
			HttpServletRequest request){
		ModelAndView mv = super.getModelAndView(viewName, ex);
                mv.addObject("message", ex.getMessage());
                ex.printStackTrace();
                mv.addObject("exception_message", ex.toString());
		return mv;
	}
}