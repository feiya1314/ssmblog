package blog.controller;

import blog.dto.input.Blog;
import blog.service.imp.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class EditorController {
    @Autowired
    BlogService blogService;
    @RequestMapping(value = "/editor",method = RequestMethod.POST)
    public ModelAndView editorBlog(Blog blog){
        ModelAndView modelAndView=new ModelAndView();
        blog.dao.Blog saveBlog=new blog.dao.Blog();
        saveBlog.setUserid(Integer.valueOf(blog.getUserid()));
        saveBlog.setTitle(blog.getTitle());
        saveBlog.setMarkdown(blog.getMarkdown());
        saveBlog.setPreview(blog.getPreview());
        //saveBlog.setTime(new Date());
        blogService.creatBlog(saveBlog);
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
