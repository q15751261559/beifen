package southWind.dao;

import southWind.entity.User;
import southWind.entity.Vo.UserVo;
import southWind.entity.Vo.UserVoBuy;
import southWind.entity.order;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserManagement
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/30
 **/

public interface UserManagementDao {
    /**
     * 增加用户
     * @param user 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertUser(User user) throws SQLException;

    /**
     * 删除用户
     * @param user
     * @return
     * @throws SQLException
     */

    int removeUser(User user) throws  SQLException;

    /**
     * 修改信息
     * @param user
     * @return
     * @throws SQLException
     */
    int updateUser(User user) throws  SQLException;

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     * @throws SQLException
     */
   List<User> getAll (String userId) throws SQLException;
    /**
     * 根据用户id查询用户所购买的信息
     * @param userId
     * @return
     * @throws SQLException
     */
    List<UserVoBuy> findUserProtectById(String userId) throws  SQLException;

    int updateOrder(order order) throws SQLException;

}
