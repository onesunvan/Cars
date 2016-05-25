package carshow.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

public class AlwaysSaveRequestCache extends HttpSessionRequestCache
{
   @Override
   public void saveRequest(HttpServletRequest request, HttpServletResponse response)
   {
      final String SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
      DefaultSavedRequest savedRequest = new DefaultSavedRequest(request, new PortResolverImpl());
      request.getSession().setAttribute(SAVED_REQUEST, savedRequest);
      logger.debug("DefaultSavedRequest added to Session: " + savedRequest);
   }
}