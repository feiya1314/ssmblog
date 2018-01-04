package Demo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import net.bytebuddy.implementation.bytecode.Throw;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    //private String filePath;
    //public int[] getTopXY()
    /*public static BufferedImage roate(){

    }*/
    private Runtime runtime = Runtime.getRuntime();
    private double magicNum=1.3;
    public void init(){

    }
    public void jump(int time) throws IOException{
        runtime.exec("adb shell input swipe 200 250 300 250 "+time);
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void screenShot()throws IOException{
        runtime.exec("adb shell screencap -p //sdcard//autojump.png");
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        runtime.exec("adb pull //sdcard//autojump.png D://Desktop");
    }
    public static BufferedImage roate(BufferedImage bi) {
        int width = bi.getWidth();
        int height = bi.getHeight();
        BufferedImage bufferedImage = new BufferedImage(height, width, bi.getType());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bufferedImage.setRGB(j, i, bi.getRGB(width-i-1, j));
            }
        }
        return bufferedImage;
    }
    public void jumpNow(double magic) throws IOException{
        BufferedImage bi = (BufferedImage) ImageIO.read(new File("d://Desktop//autojump.png"));
        int height=bi.getHeight();
        int width=bi.getWidth();
        if(width>height){
            bi=ImageUtil.roate(bi);
        }
        height=bi.getHeight();
        width=bi.getWidth();
        int halfWidth=width>>1;
        int[] rgbBack = new int[3];
        int[] rgb = new int[3];

        int start=0;
        start=height>>>2;

        int[] targetTop=new int[3];
        int[] targetLeft=new int[3];
        int[] targetRight=new int[3];

        int topX=0;
        int topY=0;
        int xishu=1;
        int targetLeftX=0;
        int targetLeftY=0;
        int targetRightX=0;
        int targetRightY=0;
        for(int i=50;i<100;i++){
            int pixel = 16777216+bi.getRGB(i,start);
            rgb[0] = (pixel & 0xff0000) >> 16;
            rgb[1] = (pixel & 0xff00) >> 8;
            rgb[2] = (pixel & 0xff);
            if(Math.abs(rgb[0]-rgbBack[0])<5&&Math.abs(rgb[1]-rgbBack[1])<5&&Math.abs(rgb[2]-rgbBack[2])<5){
                continue;
            }
            rgbBack[0]=rgb[0];
            rgbBack[1]=rgb[1];
            rgbBack[2]=rgb[2];

        }
        System.out.println("background");
        System.out.println(rgbBack[0]+","+rgbBack[1]+","+rgbBack[2]);
        width-=50;
        int chazhi=0;
        boolean end=false;
        int x=0,y=0;
        for(int i=start;i<height;i++){
            for(int j=0;j<width;j++) {
                int pixel =16777216+bi.getRGB(j, i);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                chazhi=Math.abs(rgb[0]-rgbBack[0])+Math.abs(rgb[1]-rgbBack[1])+Math.abs(rgb[2]-rgbBack[2]);
                if(chazhi>55){
                    end=true;
                    x=j;
                    y=i;
                    break;
                }
            }
            if (end){
                break;
            }
        }
        System.out.println("top");
        System.out.println(x+","+y);
        System.out.println(rgb[0]+","+rgb[1]+","+rgb[2]);
        topX=x;
        topY=y;
        targetTop[0]=rgb[0];
        targetTop[1]=rgb[1];
        targetTop[2]=rgb[2];
        int abs=(topX-halfWidth)>0?(width-topX):topX;
        int dep=topY+240*xishu;
        targetRightX=topX;
        targetRightY=topY;
        int backTimes=0;
        boolean rightend=false;
        for (int i = topY+1; i <dep ; i++) {
            for(int j=1;j<abs*xishu;j++ ){
                int pixel =16777216+bi.getRGB(topX+j, i);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                chazhi=Math.abs(rgb[0]-targetTop[0])+Math.abs(rgb[1]-targetTop[1])+Math.abs(rgb[2]-targetTop[2]);
                if(Math.abs(rgb[0]-targetTop[0])<8&&Math.abs(rgb[1]-targetTop[1])<8&&Math.abs(rgb[2]-targetTop[2])<8){
                    if((topX+j)>targetRightX){
                        targetRightX=topX+j;
                        targetRightY=i;
                        targetRight[0]=rgb[0];
                        targetRight[1]=rgb[1];
                        targetRight[2]=rgb[2];
                        rightend=false;
                    }
                    if(backTimes>20){
                        rightend=true;
                        break;
                    }
                }
                chazhi=Math.abs(rgb[0]-rgbBack[0])+Math.abs(rgb[1]-rgbBack[1])+Math.abs(rgb[2]-rgbBack[2]);
                if(Math.abs(rgb[0]-rgbBack[0])<12&&Math.abs(rgb[1]-rgbBack[1])<12&&Math.abs(rgb[2]-rgbBack[2])<12){
                    continue;
                }
            }
            if (rightend){
                break;
            }
        }
        System.out.println("targetRight");
        System.out.println(targetRightX+","+targetRightY);
        System.out.println(targetRight[0]+","+targetRight[1]+","+targetRight[2]);

        System.out.println("center");
        int centerX=topX;
        int centerY=targetRightY;
        System.out.println(centerX+","+centerY);

        int[] tan= new int[]{55,60,100};
        int tanX=0;
        int tanY=0;
        boolean isTan=false;
        for (int i = height-40; i >topY ; i--) {
            for (int j = 40; j <width-40 ; j++) {
                int pixel =16777216+bi.getRGB(j, i);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                //chazhi=Math.abs(rgb[0]-tan[0])+Math.abs(rgb[1]-tan[1])+Math.abs(rgb[2]-tan[2]);
                if(Math.abs(rgb[0]-tan[0])<5&&Math.abs(rgb[1]-tan[1])<5&&Math.abs(rgb[2]-tan[2])<5) {
                    for(int k=1;k<10;k++){
                        pixel =16777216+bi.getRGB(j+k, i);
                        rgb[0] = (pixel & 0xff0000) >> 16;
                        rgb[1] = (pixel & 0xff00) >> 8;
                        rgb[2] = (pixel & 0xff);
                        if(Math.abs(rgb[0]-tan[0])<3&&Math.abs(rgb[1]-tan[1])<3&&Math.abs(rgb[2]-tan[2])<3) {
                            isTan=true;
                        }else {
                            isTan=false;
                            break;
                        }
                        pixel =16777216+bi.getRGB(j+4, i-k);
                        rgb[0] = (pixel & 0xff0000) >> 16;
                        rgb[1] = (pixel & 0xff00) >> 8;
                        rgb[2] = (pixel & 0xff);
                        if(Math.abs(rgb[0]-tan[0])<6&&Math.abs(rgb[1]-tan[1])<6&&Math.abs(rgb[2]-tan[2])<6) {
                            isTan=true;
                        }else {
                            isTan=false;
                            break;
                        }
                    }
                    if (isTan){
                        tanX=j;
                        tanY=i;
                        break;
                    }
                }
            }
            if (isTan){
                break;
            }
        }
        System.out.println("tan");
        System.out.println(tanX+","+tanY);

        int distance=(int)Math.sqrt(Math.pow((tanX-centerX),2)+Math.pow((tanY-centerY),2));
        jump((int)(distance*magic));
        System.out.println(distance);
    }
    public static void main(String[] args) throws IOException{
        ImageUtil imageUtil=new ImageUtil();
        imageUtil.jumpNow(1.34);
    }
}
