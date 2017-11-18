package core.utils;

import org.springframework.context.ApplicationContext;

public class ObtainIdUtil implements Runnable {
    private IdStorage idStorage;
    private ApplicationContext context;
    //private SpiderUtil spiderUtil=new SpiderUtil();
    private DataUpdateUtil dataUpdateUtil=new DataUpdateUtil();

    private Integer[] ids=null;

    public ObtainIdUtil(IdStorage idStorage,ApplicationContext context){
        this.idStorage=idStorage;
        this.context=context;
    }

    @Override
    public void run() {
        while(true){
            try {
                ids=idStorage.getIds();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(ids!=null) {
                if(ids[0]==0){
                    System.out.println("Obtain End");
                    break;
                }
                System.out.println("ids content-->"+ids.toString());
                System.out.println("idssize content-->"+ids.length);
                for (int i = 0; i < ids.length; i++) {
                    dataUpdateUtil.insertStoryDetails(ids[i]);
                }
            }
        }

    }
}
