package blog.mapper;

import blog.dao.SimpleUser;
import blog.dao.User;
import blog.dao.UserDetailInfo;
import blog.dto.output.UserDetails;
import core.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper extends IBaseMapper<User> {
	//通过会员id获取其详情
   public UserDetails getUserDetailsById(Integer id);
    //通过等级，用户名（模糊查询）获取会员列表
   public List<User> getUserListByLevel(@Param("level")Integer level,@Param("username")String username);
   //批量删除
   public void deleteByIdList(@Param("idList")List<Integer> idList);
   //查询一个用户名的
   public Integer getUserNameCount(String username);
   //根据用户名查询
   public User getByUserName(String username);
   public SimpleUser getBySimpleUserName(String username);
   int countId(int id);
   int countUsername(String username);
   int registerUser(UserDetailInfo userDetailInfo);
}