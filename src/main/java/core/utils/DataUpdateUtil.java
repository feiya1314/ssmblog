package core.utils;

import blog.dao.HotNews;
import blog.dao.Story;
import blog.dao.StoryDetails;
import blog.dao.TopStory;
import blog.service.IHotNewsService;
import blog.service.IStoryDetailService;
import blog.service.IStoryService;
import blog.service.ITopNewsService;
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

        final HashSet<Integer> integers=null;
        final HotNews[] hotNews=new SpiderUtil().getHotNews().getRecent();
        for(HotNews temp:hotNews){
            integers.add(temp.getNews_id());
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
        });
    }

    public void insertPastStory(){
        new InsertPastStoryuitl().insertPastStory();
    }
    public static void main(String[] args) throws IOException{
        DataUpdateUtil dataUpdateUtil = new DataUpdateUtil();
        dataUpdateUtil.insertTodayStories();
        dataUpdateUtil.updateHotNews();

        /*dataUpdateUtil.insertStoryDetails(9656917);
        dataUpdateUtil.insertStoryDetails(9656954);
        dataUpdateUtil.insertStoryDetails(9657070);
        dataUpdateUtil.insertStoryDetails(9656827);*/
    }
}
