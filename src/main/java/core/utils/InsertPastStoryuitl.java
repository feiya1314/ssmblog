package core.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertPastStoryuitl {
    public void insertPastStory(){
        IdStorage idStorage=new IdStorage();
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml");
        StorageIdUtil storageIdUtil=new StorageIdUtil(idStorage,context);
        ObtainIdUtil obtainIdUtil=new ObtainIdUtil(idStorage,context);
        ObtainIdUtil obtainIdUtil2=new ObtainIdUtil(idStorage,context);
        ObtainIdUtil obtainIdUtil3=new ObtainIdUtil(idStorage,context);
        System.out.println();
        long startTime = System.currentTimeMillis();
        new Thread(obtainIdUtil2).start();
        new Thread(obtainIdUtil).start();
        new Thread(storageIdUtil).start();
        new Thread(obtainIdUtil3).start();
        long endTime = System.currentTimeMillis();
        System.out.println("program running time "+(endTime-startTime)+"ms");
    }
    public static void main(String[] args) {


    }
}
