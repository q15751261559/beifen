package southWind.service;

import org.junit.Test;
import southWind.factory.ServiceFactory;
import southWind.utils.ResultEntity;
import sun.security.util.Password;

import java.sql.ResultSet;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private final AdminLoginService adminService= ServiceFactory.getAdminServiceInstance();
    private final UserLoginService userService =ServiceFactory.getUserServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity=adminService.adminLogin("123456", "123456");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }

}