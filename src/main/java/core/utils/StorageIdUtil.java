package core.utils;

import blog.dao.Story;
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
            int date=20171031+i;
            stories = spiderUtil.getStoryByDate(String.valueOf(date));
            ids = spiderUtil.getIds();
            try {
                idStorage.addIds(ids);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataUpdateUtil.insertStories(stories);
        }
        idStorage.setEnd(true);
        System.out.println("Storage Thread end");
    }
}
