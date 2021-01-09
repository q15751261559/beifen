package southWind.service;

import southWind.utils.ResultEntity;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface AdminLoginService {
    /**
     * 管理员登录
     * @param account :帐号
     * @param password :密码
     * @return ResultEntity :返回结果
     */
    ResultEntity adminLogin(String account,String password);
}
