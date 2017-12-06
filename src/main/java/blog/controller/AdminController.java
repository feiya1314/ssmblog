package blog.controller;

import blog.dao.Admin;
import blog.dto.output.AdminSimpleInfo;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
        AdminSimpleInfo adminSimpleInfo=new AdminSimpleInfo();
        SecurityContext securityContext= SecurityContextHolder.getContext();
        /*securityContext.getAuthentication().*/
        Object admin=securityContext.getAuthentication().getPrincipal();
        if(admin instanceof Admin){
            adminSimpleInfo.setFreezen(((Admin) admin).isFreezen());
            adminSimpleInfo.setHeadUrl(((Admin) admin).getHeadUrl());
            adminSimpleInfo.setId(((Admin) admin).getId());
            adminSimpleInfo.setUsername(((Admin) admin).getUsername());
            adminSimpleInfo.setRole(((Admin) admin).getRole());
        }
        modelAndView.addObject("admin",adminSimpleInfo);
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}
