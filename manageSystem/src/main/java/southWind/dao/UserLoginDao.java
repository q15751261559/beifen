package southWind.dao;

import southWind.entity.LoginUser;

import java.sql.SQLException;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface UserLoginDao {
    /**
     * 根据帐号查询用户
     * @param account
     * @return
     * @throws SQLException
     */
    LoginUser findUserByAccount(String account) throws SQLException;
}
