package blog.controller;

import blog.dto.input.RegisterUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(RegisterUser user ){
        ModelAndView modelAndView=new ModelAndView();
        //TODO 存储账号密码
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
