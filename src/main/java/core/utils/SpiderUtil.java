package core.utils;

import blog.dao.*;
import blog.service.IStoryDetailService;
import blog.service.IStoryService;
import blog.service.ITopNewsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SpiderUtil {

    private List<Story> todayStoryList;
    private HashSet<Integer> todayStoryIdSet;
    private Integer[] ids;
    public List<Story> getStoryByDate(String date){
        ObjectMapper oMapper=new ObjectMapper();
        PastNews pastNews;
        String urlPast;
        String result;
        Iterator<Story> iterator;
        Story story;
        List<Story> list=null;

        Integer[] ids=null;
        urlPast=RequestUrls.getPastNew(date);
        result=HttpClientHelper.sendGet(urlPast, null, "utf-8");
        System.out.println("result From zhihu -->"+result);
        if(result!=null&&result!=""){
            try {
                pastNews=oMapper.readValue(result, PastNews.class);
                list=pastNews.getStories();
                iterator=list.iterator();
                int index=0;
                ids=new Integer[list.size()];
                while(iterator.hasNext()){
                    story=iterator.next();
                    story.setDate(date);
                    ids[index++]=story.getId();
                }
                setIds(ids);

            } catch (JsonParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (JsonMappingException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return list;
    }
public HotNewsJson getHotNews()throws IOException{
    HotNewsJson hotNews=null;
    String hotNewsUrl;
    String result;
    ObjectMapper oMapper=new ObjectMapper();
    hotNewsUrl=RequestUrls.getHotNews();
    result=HttpClientHelper.sendGet(hotNewsUrl, null, "utf-8");
    if(result!=null&&result!=""){
          hotNews=oMapper.readValue(result, HotNewsJson.class);
    }
    return hotNews;
}

public StoryThemesJson getStoryThemesByid(String id)throws IOException{
    StoryThemesJson storyThemesJson=null;
    String themeUrl;
    String result;
    ObjectMapper oMapper=new ObjectMapper();
    themeUrl=RequestUrls.getThemesById(id);
    result=HttpClientHelper.sendGet(themeUrl, null, "utf-8");
    if(result!=null&&result!=""){
        storyThemesJson=oMapper.readValue(result, StoryThemesJson.class);
    }
    return storyThemesJson;

}
    private LatestNews getLatestNews(){
        LatestNews result=null;
        ObjectMapper oMapper=new ObjectMapper();
        String requestUrl=RequestUrls.getLatestNews();

        String jsonResult;
        jsonResult=HttpClientHelper.sendGet(requestUrl, null, "utf-8");

        if(jsonResult!=null&&jsonResult!=""){
            try {
                result=oMapper.readValue(jsonResult, LatestNews.class);

            } catch (JsonParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (JsonMappingException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return result;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public HashSet<Integer> getTodayStoryIdSet() {
        return todayStoryIdSet;
    }

    public void setTodayStoryIdSet(HashSet<Integer> todayStoryIdSet) {
        this.todayStoryIdSet = todayStoryIdSet;
    }

    public List<Story> getTodayStoryList() {
        return todayStoryList;
    }

    public void setTodayStoryList(List<Story> todayStoryList) {
        this.todayStoryList = todayStoryList;
    }

    public List<TopStory> getTopStories(){
        HashSet<Integer> todayStoryIdSet=new HashSet<>();
        LatestNews latestNews=getLatestNews();
        List<TopStory> topStories=latestNews.getTop_stories();
        List<Story> stories=latestNews.getStories();
        Iterator<TopStory>iterator=topStories.iterator();
        Iterator<Story> iterator1=stories.iterator();
        String date=latestNews.getDate();
        TopStory topStory=null;
        Story story=null;
        while (iterator.hasNext()){
            topStory=iterator.next();
            topStory.setDate(date);
            todayStoryIdSet.add(topStory.getId());
        }
        while (iterator1.hasNext()){
            story=iterator1.next();
            story.setDate(date);
            todayStoryIdSet.add(story.getId());
        }
        setTodayStoryIdSet(todayStoryIdSet);
        setTodayStoryList(stories);
        return topStories;
    }

    public StoryDetails getStoryDetails(String id){
        ObjectMapper oMapper=new ObjectMapper();
        String requestUrl=RequestUrls.getStoryDetails(id);
        StoryDetails storyDetails=null;
        String jsonResult;
        jsonResult=HttpClientHelper.sendGet(requestUrl, null, "utf-8");
        if(jsonResult!=null&&jsonResult!=""){
            try {
                storyDetails=oMapper.readValue(jsonResult, StoryDetails.class);
            } catch (JsonParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (JsonMappingException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return storyDetails;
    }

    //TODO to be continue
    public List<StoryDetails> getStoryDetailsList(String id){
        ObjectMapper oMapper=new ObjectMapper();
        String requestUrl=RequestUrls.getStoryDetails(id);
        List<StoryDetails> storyDetails=null;
        StoryDetails details=null;
        String jsonResult;
        jsonResult=HttpClientHelper.sendGet(requestUrl, null, "utf-8");
        if(jsonResult!=null&&jsonResult!=""){
            try {
                details=oMapper.readValue(jsonResult, StoryDetails.class);
            } catch (JsonParseException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (JsonMappingException e) {
                // TODO: handle exception
                e.printStackTrace();
            }catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return storyDetails;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml","classpath:spring-mybatis.xml","classpath:spring-mvc.xml");
       // ITopNewsService  iTopNewsService=(ITopNewsService)context.getBean("topNewsService");
        //List<TopStory> list= new SpiderUtil().getTopStories();
        StoryDetails storyDetails=new SpiderUtil().getStoryDetails("4772126");
        IStoryDetailService iStoryDetailService=(IStoryDetailService)context.getBean("storyDetailService");
        iStoryDetailService.insertStoryDetail(storyDetails);
       //iStoryService.insertStories(list);
       // iTopNewsService.insertTopStories(list);
        System.out.println("");
    }
}
