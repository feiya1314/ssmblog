package blog.controller;

import blog.dto.output.Story;
import blog.service.IThemeStoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/get")
public class StoryThemeController {
    private Logger logger=Logger.getLogger(StoryThemeController.class);

    @Autowired
    private IThemeStoryService iThemeStoryService;

    @RequestMapping(value = "/dailySports",method = RequestMethod.GET)
    public ModelAndView getDailySports(){
        ModelAndView modelAndView = new ModelAndView();
        List<Story> stories=iThemeStoryService.getSportsThemeByNum(15);
        modelAndView.addObject("stories",stories);
        modelAndView.addObject("pageIdentity","dailySports");
        modelAndView.setViewName("storyTheme");
        return modelAndView;
    }

    @RequestMapping(value = "/dailyPsychology",method = RequestMethod.GET)
    public ModelAndView getDailyPsychology(){
        ModelAndView modelAndView = new ModelAndView();
        List<Story> stories=iThemeStoryService.getPsychologyThemeByNum(15);
        modelAndView.addObject("stories",stories);
        modelAndView.addObject("pageIdentity","dailyPsychology");
        modelAndView.setViewName("storyTheme");
        return modelAndView;
    }

    @RequestMapping(value = "/peopleRecommend",method = RequestMethod.GET)
    public ModelAndView getPeopleRecommend(){
        ModelAndView modelAndView = new ModelAndView();
        List<Story> stories=iThemeStoryService.getRecommendThemeByNum(15);
        modelAndView.addObject("stories",stories);
        modelAndView.addObject("pageIdentity","peopleRecommend");
        modelAndView.setViewName("storyTheme");
        return modelAndView;
    }
}
