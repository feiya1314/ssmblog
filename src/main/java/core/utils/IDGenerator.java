package core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDGenerator {

    public static int getID(){
        int id=0;
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        String dateM=formatter1.format(currentTime).substring(5)+dateString;
        id=Integer.valueOf(dateM);
        //System.out.println(dateM);
        return id;
    }

    public static void main(String[] args) {
        IDGenerator.getID();
    }
}
