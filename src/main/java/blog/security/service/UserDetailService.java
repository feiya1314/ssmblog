package blog.security.service;

import blog.dao.SimpleUser;
import blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SimpleUser user=userMapper.getBySimpleUserName(s);
        //可以先从缓存中查找，没有的话再从数据库查找
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
