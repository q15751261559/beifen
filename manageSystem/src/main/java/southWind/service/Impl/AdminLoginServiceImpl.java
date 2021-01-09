package southWind.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;
import southWind.dao.AdminLoginDao;
import southWind.dao.AdminLoginDao;
import southWind.dao.MemberLoginDao;
import southWind.dao.MemberLoginDao;
import southWind.dao.UserLoginDao;
import southWind.dao.UserLoginDao;
import southWind.entity.LoginAdmin;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;
import southWind.factory.DaoFactory;
import southWind.service.AdminLoginService;
import southWind.service.AdminLoginService;
import southWind.utils.ResultEntity;

import java.sql.SQLException;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class AdminLoginServiceImpl implements AdminLoginService {
    private final AdminLoginDao adminDao= DaoFactory.getAdminDaoInstance();
    private  final MemberLoginDao memberDao=DaoFactory.getMemberDaoInstance();
    private final UserLoginDao userDao=DaoFactory.getUserDaoInstance();
    @Override
    public ResultEntity adminLogin(String account, String password) {
        ResultEntity resultEntity;
        LoginAdmin admin=null;
        try {
            admin=adminDao.findAdminByAccount(account);
        }catch (SQLException e){
            System.err.println("帐号查询出现了异常");
        }
        if(admin!=null){
            //比较密码
            if(DigestUtils.md5Hex(password).equals(admin.getPassword())) {
                resultEntity = ResultEntity.builder().code(0).userAccount(admin.getAccount()).userName(admin.getAdmin_name()).message("欢迎"+admin.getAdmin_name()+"您的登录").data(admin).build();
            }
            else {//帐号存在，密码输入错误
                resultEntity=ResultEntity.builder().code(3).message("密码错误").data(admin).build();
            }

        }else {
            resultEntity=ResultEntity.builder().code(4).message("帐号不存在").build();
        }

        return resultEntity;
    }
}
