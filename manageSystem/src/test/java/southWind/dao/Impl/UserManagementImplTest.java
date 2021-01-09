package southWind.dao.Impl;

import org.junit.Test;
import southWind.dao.UserManagementDao;
import southWind.entity.User;
import southWind.entity.Vo.UserVoBuy;
import southWind.factory.DaoFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class UserManagementImplTest {
    private  final UserManagementDao userManagementDao= DaoFactory.getUserManagementDaoInstance();
    @Test
    public void insertUser() {
        int n=0;
        User user=User.builder()
                .userId("5")
                .userName("晓晓")
                .userProduct("Python")
                .userDateTime(LocalDateTime.now())
                .build();
        try{
            n=userManagementDao.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1,n);


    }

    @Test
    public void removeUser() {
        int n=0;
        User user =User.builder()
                .userId("5")
                .build();
        try{
            n=userManagementDao.removeUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertEquals(1,n);
    }

    @Test
    public void dropUser() {
        int n=0;
        User user=User.builder()
                .userName("小小")
                .userPhone("13921199146")
                .userAddress("江苏省南京市玄武区")
                .userId("5")
                .build();
        try {
            n=userManagementDao.updateUser(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        assertEquals(1,n);

    }



    @Test
    public void findUserProtectById() throws SQLException {
        List<UserVoBuy> list=DaoFactory.getUserManagementDaoInstance().findUserProtectById("1");
        list.forEach(System.out::println);

    }

    @Test
    public void testTestInsertUser() {
        User user=User.builder()
                .userName("便意轩")
                .userPhone("21414")
                .userAddress("12313312")
                .build();
        user.setUserId("111");
        try {
            DaoFactory.getUserManagementDaoInstance().insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}