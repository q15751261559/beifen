package southWind.factory;

import southWind.service.*;
import southWind.service.Impl.*;
import southWind.service.Impl.MemberLoginServiceImpl;
import southWind.service.Impl.UserLoginServiceImpl;
import southWind.service.MemberLoginService;
import southWind.service.UserLoginService;

import java.lang.reflect.Member;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class ServiceFactory {
    public static AdminLoginService getAdminServiceInstance(){
        return new AdminLoginServiceImpl();
    }
    public  static UserLoginService getUserServiceInstance(){return  new UserLoginServiceImpl(); }
    public static MemberLoginService getMemberServiceInstance(){ return new MemberLoginServiceImpl();}
    public  static UserManagementService getUserManagementServiceInstance(){return new UserManagementServiceImpl();
    }
    public static BasicUserService getBasicUserServiceInstance(){return  new BasicUserServiceImpl();}
    public static BasicMemberService getBasicMemberServiceInstance(){return new BasicMemberServiceImpl();}
}
