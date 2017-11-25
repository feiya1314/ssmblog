package core.utils;

import blog.dao.Story;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StorageIdUtil implements Runnable {
    private IdStorage idStorage;
    int startDate;
    int number;

    private ApplicationContext context;
    private SpiderUtil spiderUtil = new SpiderUtil();
    private DataUpdateUtil dataUpdateUtil = new DataUpdateUtil();

    private List<Story> stories = new ArrayList<>();
    private Integer[] ids = null;

    /*startdate format yyyyMMDD*/
    public StorageIdUtil(IdStorage idStorage,ApplicationContext context,int startDate,int number) {
        this.idStorage = idStorage;
        this.context=context;
        this.startDate=startDate;
        this.number=number;
    }

    @Override
    public void run() {
        int start;
        int end;
        int offssize;
        if(number<0){
            start=number;
            end=-1;
            offssize=-1;
        }else{
            start=1;
            end=number;
            offssize=1;
        }
        String time=String.valueOf(startDate);
        Calendar calendar=Calendar.getInstance();//20171114
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        calendar.set(Integer.parseInt(time.substring(0,4)),Integer.parseInt(time.substring(4,6))-1,Integer.parseInt(time.substring(6,8)));
        for (int i=start; i <= end; i++) {
            calendar.add(Calendar.DATE,offssize);
            String date=simpleDateFormat.format(calendar.getTime());
            stories = spiderUtil.getStoryByDate(date);
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
