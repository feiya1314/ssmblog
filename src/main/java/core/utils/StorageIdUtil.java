package core.utils;

import blog.dao.Story;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class StorageIdUtil implements Runnable {
    private IdStorage idStorage;

    private ApplicationContext context;
    private SpiderUtil spiderUtil = new SpiderUtil();
    private DataUpdateUtil dataUpdateUtil = new DataUpdateUtil();

    private List<Story> stories = new ArrayList<>();
    private Integer[] ids = null;

    public StorageIdUtil(IdStorage idStorage,ApplicationContext context) {
        this.idStorage = idStorage;
        this.context=context;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            int date=20171029+i;
            stories = spiderUtil.getStoryByDate(String.valueOf(date));
            ids = spiderUtil.getIds();
            try {
                idStorage.addIds(ids);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataUpdateUtil.insertStories(stories);
        }
        ids=new Integer[1];
        ids[0]=0;
        try{
            idStorage.addIds(ids);
            System.out.println("time to end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Storage Thread end");
    }
}
