package southWind.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;
import southWind.dao.UserLoginDao;
import southWind.entity.LoginUser;
import southWind.factory.DaoFactory;
import southWind.utils.ResultEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class UserLoginServiceImpl implements southWind.service.UserLoginService {
    private final UserLoginDao userDao= DaoFactory.getUserDaoInstance();
    @Override
    public ResultEntity userLogin(String account, String password) {
     ResultEntity resultEntity;
        LoginUser user=null;
        try{
            user=userDao.findUserByAccount(account);
        }catch (SQLException e){
            System.err.println("根据帐号查询用户信息出现了SQL异常");
        }
        if(user!=null){
            if(DigestUtils.md5Hex(password).equals(user.getPassword())){
                resultEntity=ResultEntity.builder().code(1).userAccount(user.getAccount()).userId(String.valueOf(user.getId())).userName(user.getUser_name()).message("欢迎"+user.getUser_name()+"您的登录").data(user).build();
            }else {
                resultEntity=ResultEntity.builder().code(3).message("密码错误").build();
            }
        }else {
            resultEntity=ResultEntity.builder().code(4).message("帐号不存在").build();
        }

     return resultEntity;
    }
}
