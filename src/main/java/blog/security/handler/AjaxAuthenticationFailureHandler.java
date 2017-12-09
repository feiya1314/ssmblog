package blog.security.handler;

import blog.security.UnauthorizedEntryPoint;
import core.utils.SecurityUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private static final Log logger = LogFactory.getLog(UnauthorizedEntryPoint.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(SecurityUtils.isAjaxRequest(request)){
            if(exception instanceof UsernameNotFoundException){
                logger.debug("onAuthenticationFailure-->UsernameNotFoundException "+"user not found");
                response.setHeader("Content-Type", "application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(401);
                response.getWriter().print("{\"success\":false,\"errorCode\":101,\"msg\":\"user name not found\"}");
                return;
            }
            if(exception instanceof BadCredentialsException){
                response.setHeader("Content-Type", "application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                logger.debug("onAuthenticationFailure-->BadCredentialsException "+"password is wrong");
                response.setStatus(401);
                response.getWriter().print("{\"success\":false,\"errorCode\":102,\"msg\":\"passowrd is wrong\"}");
                return;
            }
        }else{
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
