package blog.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping(value = "/api")
public class EntryImageController {
    private Logger logger=Logger.getLogger(EntryImageController.class);

    @RequestMapping(value = "/imgUrl",method = RequestMethod.GET)
    public void getEntryImage(String imgurl, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    throws IOException{
        logger.info(imgurl);
        URL url=new URL(imgurl);
        HttpURLConnection client=(HttpURLConnection)url.openConnection();
       // client.setRequestProperty("Accept:","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        client.setRequestProperty("Accept-Encoding","gzip, deflate");
        client.setRequestProperty("Referrer Policy","no-referrer-when-downgrade");
        client.setRequestProperty("Connection","keep-alive");
        client.setRequestProperty("Referer","http://pic3.zhimg.com/");
       // client.setRequestProperty("Accept-Language:","zh-CN,zh;q=0.8");
        client.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        client.connect();
        byte[] buf=new byte[2048];
        int size=0;
        httpServletResponse.setContentType("image/*");
        OutputStream outputStream=httpServletResponse.getOutputStream();
        InputStream inputStream=client.getInputStream();
        while ((size=inputStream.read(buf))!=-1){
            logger.info("size-->"+size);
            outputStream.write(buf,0,size);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
         //httpServletResponse.getWriter().write(imgurl);
    }
}
