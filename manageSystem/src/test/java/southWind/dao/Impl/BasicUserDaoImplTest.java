package southWind.dao.Impl;

import org.junit.Test;
import southWind.dao.BasicUserDao;
import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;
import southWind.factory.DaoFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BasicUserDaoImplTest {
    private  final BasicUserDao basicUserDao= DaoFactory.getBasicUserDaoInstance();


    @Test
    public void findUserOutComeById() throws SQLException {
        List<UserOutComeVo> list=DaoFactory.getBasicUserDaoInstance().findUserOutComeById("1");
        list.forEach(System.out::println);
    }

    @Test
    public void findBasicUserAll()throws SQLException {
        List<UserVo> list=DaoFactory.getBasicUserDaoInstance().findBasicUserAll();
        list.forEach(System.out::println);
    }

    @Test
    public void findBasicUserByUserName()throws SQLException  {
        List<UserVo> list=DaoFactory.getBasicUserDaoInstance().findBasicUserByUserName("3");
        list.forEach(System.out::println);
    }
}