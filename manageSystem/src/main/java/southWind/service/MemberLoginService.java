package southWind.service;

import southWind.utils.ResultEntity;

/**
 * @ClassName MemberService
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface MemberLoginService {
    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     */
    ResultEntity memberLogin(String account, String password);
}
