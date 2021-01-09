package southWind.dao;

import org.junit.Test;
import southWind.entity.User;
import southWind.factory.DaoFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserManagementDaoTest {
    private  final UserManagementDao userManagementDao= DaoFactory.getUserManagementDaoInstance();
    @Test
    public void getAll() throws SQLException {
        List<User> userList=userManagementDao.getAll("1");
        System.out.println(userList);
    }
}