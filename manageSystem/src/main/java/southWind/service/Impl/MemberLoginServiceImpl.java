package southWind.service.Impl;

import org.apache.commons.codec.digest.DigestUtils;
import southWind.dao.MemberLoginDao;
import southWind.dao.MemberLoginDao;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;
import southWind.factory.DaoFactory;
import southWind.service.MemberLoginService;
import southWind.service.MemberLoginService;
import southWind.utils.ResultEntity;

import java.sql.SQLException;

/**
 * @ClassName MemberServiceImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class MemberLoginServiceImpl  implements MemberLoginService {
    private final MemberLoginDao memberDao= DaoFactory.getMemberDaoInstance();
    @Override
    public ResultEntity memberLogin(String account, String password) {
        ResultEntity resultEntity;
        LoginMember member=null;
        try{
            member=memberDao.findMemberByAccount(account);
        }catch (SQLException e){
            System.err.println("根据帐号查询员工信息出现SQL异常");
        }
        if(member!=null){
            if(DigestUtils.md5Hex(password).equals(member.getPassword())){
                resultEntity=ResultEntity.builder().code(2).userAccount(member.getAccount()).userName(member.getMember_name()).message("欢迎"+member.getMember_name()+"您的登录").data(member).build();
            }else {
                resultEntity=ResultEntity.builder().code(3).message("密码错误").build();
            }
        }else {
            resultEntity=ResultEntity.builder().code(4).message("帐号不存在").build();
        }
        return resultEntity;
    }
}
