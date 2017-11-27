package core.utils;

import blog.controller.EntryImageController;
import blog.dao.*;
import blog.service.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author feiya1314
 */
public class DataUpdateUtil {
    private ApplicationContext context;
    private Logger logger=Logger.getLogger(DataUpdateUtil.class);

    public DataUpdateUtil() {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml");
    }

    public DataUpdateUtil(ApplicationContext context) {
        this.context = context;
    }

    private void insertTopNews(List<TopStory> list) {
        ITopNewsService iTopNewsService = (ITopNewsService) context.getBean("topNewsService");
        //List<TopStory> list= new SpiderUtil().getTopStories();
        iTopNewsService.insertTopStories(list);
    }

    public void insertStoriesByDate(String date) {
        IStoryService iStoryService = (IStoryService) context.getBean("storyService");
        List<Story> list = new SpiderUtil().getStoryByDate(date);
        iStoryService.insertStories(list);
    }

    public void insertStories(List<Story> list) {
        if (list != null) {
            IStoryService iStoryService = (IStoryService) context.getBean("storyService");
            //List<Story> list=new SpiderUtil().getStoryByDate(date);
            iStoryService.insertStories(list);
        }
    }

    public void insertStoryDetails() {
        StoryDetails storyDetails = new SpiderUtil().getStoryDetails("4772126");
        IStoryDetailService iStoryDetailService = (IStoryDetailService) context.getBean("storyDetailService");
        iStoryDetailService.insertStoryDetail(storyDetails);
    }

    public void insertStoryDetails(Integer id){
        StoryDetails storyDetails = new SpiderUtil().getStoryDetails(String.valueOf(id));
        if (storyDetails != null) {
            IStoryDetailService iStoryDetailService = (IStoryDetailService) context.getBean("storyDetailService");
            iStoryDetailService.insertStoryDetail(storyDetails);
        }
    }
    public void insertStoryDetails(HashSet<Integer> todayStoryIdList) {
        if (todayStoryIdList != null) {
            int id = 0;
            Iterator<Integer> iterator=todayStoryIdList.iterator();

            while(iterator.hasNext()){
                id=iterator.next();
                logger.debug("insert story detail id == "+id);
                StoryDetails storyDetails = new SpiderUtil().getStoryDetails(String.valueOf(id));
                if (storyDetails != null) {
                    IStoryDetailService iStoryDetailService = (IStoryDetailService) context.getBean("storyDetailService");
                    iStoryDetailService.insertStoryDetail(storyDetails);
                }
            }
        }
    }

    //test insert topnewslist todaystories and todaystorydetail at the same time
    public void insertTodayStories() {
        final HashSet<Integer> todayStoryIdSet;
        final List<Story> todayStoryList;
        final List<TopStory> topStoryList;
        SpiderUtil spiderUtil = new SpiderUtil();
        topStoryList = spiderUtil.getTopStories();
        if (null != topStoryList) {
            todayStoryIdSet = spiderUtil.getTodayStoryIdSet();
            todayStoryList = spiderUtil.getTodayStoryList();
        } else {
            todayStoryIdSet = null;
            todayStoryList = null;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertStories(todayStoryList);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                insertStoryDetails(todayStoryIdSet);
            }
        }).start();

        insertTopNews(topStoryList);

    }

    public void updateTodayStories() {
        IStoryService iStoryService = (IStoryService) context.getBean("storyService");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        List<Story> list = new SpiderUtil().getStoryByDate(simpleDateFormat.format(new Date()));
        //iStoryService.insertStories(list);
        //TODO implements update stories
    }
    public void updateHotNews()throws IOException{

        final HashSet<Integer> integers=new HashSet<>();
        final HotNews[] hotNews=new SpiderUtil().getHotNews().getRecent();
        for (int i = 0; i <hotNews.length ; i++) {
            integers.add(hotNews[i].getNews_id());
        }
        System.out.println("get integer length"+integers.size());
        final IHotNewsService iHotNewsService=(IHotNewsService)context.getBean("hotNewsService");
        new Thread(new Runnable() {
            @Override
            public void run() {
                iHotNewsService.insertHotNews(hotNews);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertStoryDetails(integers);
            }
        }).start();
    }

    public void insertPastStory(){
        new InsertPastStoryuitl().insertPastStory();
    }

    public void insertThemeStory()throws IOException{
        SpiderUtil spiderUtil=new SpiderUtil();
        final StoryThemes[] sportsThemes;
        final HashSet<Integer> integers=new HashSet<>();
        final StoryThemes[] psychologyThemes;
        final StoryThemes[] recommendThemes;
        final IThemeStoryService storyService=(IThemeStoryService)context.getBean("themeStoryService");
        sportsThemes=spiderUtil.getStoryThemesByid("8").getStories();
        psychologyThemes=spiderUtil.getStoryThemesByid("13").getStories();
        recommendThemes=spiderUtil.getStoryThemesByid("12").getStories();
        for (int i = 0; i < sportsThemes.length; i++) {
            integers.add(sportsThemes[i].getId());
        }
        for (int i = 0; i < psychologyThemes.length; i++) {
            integers.add(psychologyThemes[i].getId());
        }
        for (int i = 0; i < recommendThemes.length; i++) {
            integers.add(recommendThemes[i].getId());
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                storyService.insertPsychologyTheme(psychologyThemes);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                storyService.insertRecommendTheme(recommendThemes);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                storyService.insertSportsTheme(sportsThemes);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                insertStoryDetails(integers);
            }
        }).start();
    }


    public static void main(String[] args) throws IOException{
        DataUpdateUtil dataUpdateUtil = new DataUpdateUtil();
        //dataUpdateUtil.insertTodayStories();
        //dataUpdateUtil.updateHotNews();
        dataUpdateUtil.insertThemeStory();

        /*dataUpdateUtil.insertStoryDetails(9656917);
        dataUpdateUtil.insertStoryDetails(9656954);
        dataUpdateUtil.insertStoryDetails(9657070);
        dataUpdateUtil.insertStoryDetails(9656827);*/
    }
}
