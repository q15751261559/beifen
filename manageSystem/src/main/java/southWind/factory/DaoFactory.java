package southWind.factory;

import southWind.dao.*;
import southWind.dao.AdminLoginDao;
import southWind.dao.Impl.*;
import southWind.dao.Impl.AdminLoginDaoImpl;
import southWind.dao.Impl.MemberLoginDaoImpl;
import southWind.dao.MemberLoginDao;

import java.lang.reflect.Member;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class DaoFactory {
    /**
     * 获得AdminDaoImpl实例
     * @return
     */
    public static AdminLoginDao getAdminDaoInstance(){
        return new AdminLoginDaoImpl();
    }

    /**
     * 获得UserDaoIMPL实例
     * @return
     */
    public static UserLoginDao getUserDaoInstance(){
        return new UserLoginDaoImpl();
    }
    /**
     * 获得UserDaoIMPL实例
     * @return
     */
    public static MemberLoginDao getMemberDaoInstance(){
        return new MemberLoginDaoImpl();
    }

    /**
     * 获得UserDao的实例
     * @return
     */
    public static UserManagementDao getUserManagementDaoInstance(){
        return new UserManagementImpl();
    }

    /**
     * 获得BasicUserDao的实例
     * @return
     */
    public static BasicUserDao getBasicUserDaoInstance(){
        return new BasicUserDaoImpl();
    }

    /**
     * 获得BasicMemberDao的实例
     * @return
     */
    public static BasicMemberDao getBasicMemberDaoInstance(){
        return new BasicMemberDaoImpl();
    }
}
