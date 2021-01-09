package southWind.service;

import southWind.entity.User;
import southWind.entity.Vo.UserVoBuy;

import java.util.List;

/**
 * @ClassName UserManagementService
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/

public interface UserManagementService {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int changeUser(User user);

    /**
     * 查找用户的基本信息
     * @param id
     * @return
     */
    List<User> findUser(String id);

    /**
     * 查找用户的产品信息
     * @param id
     * @return
     */
    List<UserVoBuy> findUserProduct(String id);
}
