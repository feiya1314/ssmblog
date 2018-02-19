package blog.controller;

import blog.dto.output.IndexInitData;
import blog.dto.output.MoreStories;
import blog.dto.output.Story;
import blog.dto.output.TopNews;
import blog.service.IStoryService;
import blog.service.ITopNewsService;
import core.ajaxResult.AjaxResult;
import core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class IndexController {
    @Autowired
    private ITopNewsService iTopNewsService;
    @Autowired
    private IStoryService iStoryService;
    @ResponseBody
    @RequestMapping(value = "/moreStories",method = RequestMethod.GET)
    public AjaxResult getMoreStories(String date){
        MoreStories moreStories=new MoreStories();
        //moreStories.setStories(iStoryService.getStoryByDate(date));
        moreStories.setStories(iStoryService.getStoryByNum(20));
        return AjaxResult.getOK(moreStories);
    }

    @ResponseBody
    @RequestMapping(value = "/topNewsByJs",method = RequestMethod.GET)
    public AjaxResult getTopNewsByJs(){
        IndexInitData indexInitData=new IndexInitData();
        //List<Story> stories=iStoryService.getStoryByDate("20171114");
        //List<Story> stories=iStoryService.getStoryByNum(40);
        List<Story> stories=iStoryService.getStoryByDate(StringUtil.getCurrentDate());
        if(stories==null||stories.size()==0){
            //TODO by lastDay
            stories=iStoryService.getStoryByDate(StringUtil.getLastDay());
        }
        List<TopNews>topNews=iTopNewsService.getTopNewsByJs();
        indexInitData.setStories(stories);
        indexInitData.setTopNews(topNews);
        return AjaxResult.getOK(indexInitData);
    }
@RequestMapping(value = "/topnews",method = RequestMethod.GET)
    public ModelAndView getTopNews(String date){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("TopNewsList", iTopNewsService.getTopNews(date));
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml","classpath:spring-mybatis.xml","classpath:spring-mvc.xml");
        ITopNewsService tet=(ITopNewsService)context.getBean("topNewsService");
        List<TopNews> t=tet.getTopNews("20170604");
        System.out.println("out put date 20170604");
        System.out.println(t.get(0).getTitle());
       // IUserService userService=(IUserService) context.getBean("userService");
        //System.out.println(userService.selectByPrimaryKey(1));
    }
}
