package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/adminTopThanSky")
public class AdminController {
    private org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(AdminController.class);
    @RequestMapping(value = "/adminfeiya", method = RequestMethod.GET)
    public ModelAndView GotoAdminPage(){
        logger.debug("proccessing GotoAdminPage");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","admin");
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
