package blog.filters;

import blog.dto.input.LoginForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.utils.SecurityUtils;
import core.utils.StringUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AjaxUsernamePasswordAuthFilter extends UsernamePasswordAuthenticationFilter {
    private LoginForm loginForm;

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        if (SecurityUtils.isAjaxRequest(request)) {
            return this.loginForm.getPassword();
        } else {
            return super.obtainPassword(request);
        }
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (SecurityUtils.isAjaxRequest(request)) {
            getLoginForm(request);
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        if (SecurityUtils.isAjaxRequest(request)) {
            return this.loginForm.getUsername();
        } else {
            return super.obtainUsername(request);
        }
    }

    private void getLoginForm(HttpServletRequest request){
        try {
            StringBuffer sb = new StringBuffer();
            String line = null;
            BufferedReader reader;
            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            if (!StringUtil.isEmpty(sb.toString())) {
                ObjectMapper mapper = new ObjectMapper();
                loginForm = mapper.readValue(sb.toString(), LoginForm.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
