package southWind.dao;

import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BasicUserDao
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/31
 **/

public interface BasicUserDao {
    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     * @throws SQLException
     */
    List<UserVo> findBasicUserByUserName(String userId) throws SQLException;

    /**
     * 根据用户id查询用户消费信息
     * @param userId
     * @return
     * @throws SQLException
     */
    List<UserOutComeVo> findUserOutComeById(String userId) throws  SQLException;
    /**
     * 查询所有用户信息
     * @param
     * @return
     * @throws SQLException
     */
    List<UserVo> findBasicUserAll()throws SQLException;
}
