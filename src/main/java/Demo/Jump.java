package Demo;

import java.io.IOException;

public class Jump {
    public static void main(String[] args)throws IOException{
        ImageUtil imageUtil=new ImageUtil();
        int i=0;
        double magic=1.34;
        while(true){
            imageUtil.screenShot();
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(i==8){
                i=0;
            }
            if(i<3){
                magic=1.34;
            }else {
                magic=1.30;
            }
            //test
            i++;
            imageUtil.jumpNow(magic);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
