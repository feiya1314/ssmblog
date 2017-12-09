package blog.controller;

import blog.dao.SimpleUser;
import blog.dto.input.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("userAuthenticationManager")
    protected AuthenticationManager authenticationManager;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(RegisterUser user ){
        ModelAndView modelAndView=new ModelAndView();
        //TODO 存储账号密码
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(SimpleUser user,HttpServletRequest httpServletRequest){
       /* SimpleUser simpleUser=new SimpleUser();
        simpleUser.setUsername(user.getUsername());
        simpleUser.setPassword(user.getPassword());*/
        ModelAndView modelAndView=new ModelAndView("redirect:"+user.getCurrentUrl().substring(5));
        modelAndView.addObject("user",user);
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        token.setDetails(httpServletRequest);
        Authentication  authentication=authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        httpServletRequest.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,SecurityContextHolder.getContext());
        return modelAndView;
    }
}
