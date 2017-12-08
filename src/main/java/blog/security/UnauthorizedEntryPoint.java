package blog.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnauthorizedEntryPoint extends LoginUrlAuthenticationEntryPoint
{
    private static final Log logger = LogFactory.getLog(UnauthorizedEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("Pre-authenticated entry point UnauthorizedEntryPoint called. Rejecting access");
        }
        if(isAjaxRequest(request)){
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
            response.setStatus(403);
        }else{
            super.commence( request, response, authException);
        }

    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }

}
