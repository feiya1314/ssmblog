package blog.controller;

import blog.dto.output.Story;
import blog.service.IHotNewsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/get")
public class HotNewsController {
    private Logger logger=Logger.getLogger(HotNewsController.class);
    @Autowired
    private IHotNewsService iHotNewsService;

    @RequestMapping(value = "/hotNews",method = RequestMethod.GET)
    public ModelAndView getHotNews(){
        ModelAndView modelAndView = new ModelAndView();
        List<Story> stories=iHotNewsService.getHotStoryByNum(15);
        modelAndView.addObject("stories",stories);
        modelAndView.setViewName("hotNews");
        return modelAndView;
    }

}
