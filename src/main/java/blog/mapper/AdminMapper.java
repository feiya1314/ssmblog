package blog.mapper;

import blog.dao.Admin;
import blog.dao.AdminDetailInfo;

public interface AdminMapper {
    Admin getAdminByName(String adminname);
    int insertAdminDetailInfo(AdminDetailInfo adminDetailInfo);
}
