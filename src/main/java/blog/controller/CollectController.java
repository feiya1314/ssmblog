package blog.controller;

import blog.dto.input.CollectForm;
import core.ajaxResult.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class CollectController {
    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult collectStory(CollectForm collectForm){

        return AjaxResult.getOK();
    }
}
