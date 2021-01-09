package southWind.dao;

import southWind.entity.LoginAdmin;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;

import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface AdminLoginDao {
    /**
     * 根据帐号查询管理员
     * @param account
     * @return
     * @throws SQLException 如果出现异常会抛出
     */
    LoginAdmin findAdminByAccount(String account) throws SQLException;


}
