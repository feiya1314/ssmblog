package blog.controller;

import blog.dao.SimpleUser;
import blog.dao.User;
import blog.dao.UserDetailInfo;
import blog.dto.input.RegisterUser;
import blog.dto.output.UserSimpleInfo;
import blog.service.IUserService;
import core.ajaxResult.AjaxResult;
import core.ajaxResult.ResultCode;
import core.utils.IDGenerator;
import core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    @Qualifier("userAuthenticationManager")
    protected AuthenticationManager authenticationManager;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(RegisterUser user ){
        ModelAndView modelAndView=new ModelAndView();
        //TODO 存储账号密码
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult register(SimpleUser user, HttpServletRequest httpServletRequest){
        UserDetailInfo userToDataBase=new UserDetailInfo();
        String phoneOrEmail=user.getRegisterPhoneOrEmail();

        if(StringUtil.isEmpty(user.getUsername())){
            //账户号必须输入
            return AjaxResult.getError(ResultCode.ParamException,"请输入用户名",new Integer(104));
        }else{
            if(!userExist(user.getUsername())) {
                userToDataBase.setUsername(user.getUsername());
            }else {
                //用户名已存在
                return AjaxResult.getError(ResultCode.ParamException,"用户名已存在",new Integer(105));
            }
        }
        if(StringUtil.isEmpty(user.getPassword())){
            //密码必须输入
            return AjaxResult.getError(ResultCode.ParamException,"密码必须输入",new Integer(106));
        }else{
            userToDataBase.setPassword(user.getPassword());
        }

        if (!StringUtil.isEmpty(phoneOrEmail)){
            if(StringUtil.checkEmail(phoneOrEmail)){
                userToDataBase.setEmail(phoneOrEmail);
            }else if(StringUtil.checkMobileNumber(phoneOrEmail)){
                userToDataBase.setPhone(phoneOrEmail);
            }else{
                //无效的手机号或邮箱
                return AjaxResult.getError(ResultCode.ParamException,"无效的手机号或邮箱",new Integer(103));
            }
        }

        int id=IDGenerator.getID();
        while(isRepeated(id)){
            id=IDGenerator.getID();
        }
        userToDataBase.setId(id);
        iUserService.registerUser(userToDataBase);
        UserSimpleInfo simpleInfo=new UserSimpleInfo();
        simpleInfo.setFreezen(false);
        simpleInfo.setUsername(userToDataBase.getUsername());
        simpleInfo.setId(userToDataBase.getId());
        simpleInfo.setRole(1);
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userToDataBase.getUsername(),userToDataBase.getPassword());
        token.setDetails(httpServletRequest);
        Authentication  authentication=authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        httpServletRequest.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,SecurityContextHolder.getContext());
        return AjaxResult.getOK("success",simpleInfo);
    }
    private boolean isRepeated(int id){
        int count=0;
        count=iUserService.countId(id);
        if(count>=1){
            return true;
        }
        return false;
    }
    private boolean userExist(String username){
        int count=0;
        count=iUserService.countUsername(username);
        if(count>=1){
            return true;
        }
        return false;
    }
}
