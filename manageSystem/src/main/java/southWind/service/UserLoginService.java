package southWind.service;

import southWind.dao.AdminLoginDao;
import southWind.dao.UserLoginDao;
import southWind.factory.DaoFactory;
import southWind.utils.ResultEntity;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface UserLoginService {

    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    ResultEntity userLogin(String account, String password);
}
