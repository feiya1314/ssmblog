package blog.controller;

import blog.service.*;
import core.ajaxResult.AjaxResult;
import core.ajaxResult.ResultCode;
import core.utils.DataUpdateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping(value = "/adminTopThanSky")
public class AdminUpdateStoryController {
    private Logger logger = Logger.getLogger(AdminUpdateStoryController.class);

    @Autowired
    private ITopNewsService iTopNewsService;
    @Autowired
    private IStoryService iStoryService;
    @Autowired
    private IStoryDetailService iStoryDetailService;
    @Autowired
    private IHotNewsService iHotNewsService;
    @Autowired
    private IThemeStoryService iThemeStoryService;
    @ResponseBody
    @RequestMapping(value = "/updateStory", method = RequestMethod.GET)
    public AjaxResult updateStory(){
        DataUpdateUtil dataUpdateUtil = new DataUpdateUtil(iTopNewsService,iStoryService,iStoryDetailService,iHotNewsService,iThemeStoryService);
        dataUpdateUtil.insertTodayStories();
        try{
            dataUpdateUtil.updateHotNews();
            dataUpdateUtil.insertThemeStory();
        }catch (IOException e){
            e.printStackTrace();
            return AjaxResult.getError(ResultCode.DBException);
        }
        return AjaxResult.getOK();
    }
}
