package blog.controller;

import blog.dto.output.StoryDetails;
import blog.service.IStoryDetailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/get")
@Controller
public class StoryDetailController {
    private Logger logger=Logger.getLogger(StoryDetailController.class);

    @Autowired
    private IStoryDetailService iStoryDetailService;

    @RequestMapping(value = "/entry/{id}",method = RequestMethod.GET)
    public ModelAndView getEntry(@PathVariable Integer id){

        StoryDetails storyDetails=iStoryDetailService.getStoryEntry(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("storydetails",storyDetails);
        modelAndView.setViewName("storydetail");
        return modelAndView;
    }
}
