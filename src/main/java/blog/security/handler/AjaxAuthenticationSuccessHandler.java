package blog.security.handler;

import core.ajaxResult.AjaxResult;
import core.utils.SecurityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(SecurityUtils.isAjaxRequest(request)){
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(200);
            response.getWriter().print("{\"success\":true,\"errorCode\":0,\"msg\":\"request success\"}");
        }else{
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
