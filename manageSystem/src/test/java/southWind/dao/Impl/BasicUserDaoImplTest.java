package southWind.dao.Impl;

import org.junit.Test;
import southWind.dao.BasicUserDao;
import southWind.entity.Protect;
import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;
import southWind.entity.order;
import southWind.factory.DaoFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Test
    public void findBasicOrderAll()throws SQLException{
        List<order> list=DaoFactory.getBasicUserDaoInstance().findBasicOrderAll();
        list.forEach(System.out::println);
    }
    @Test
    public void findBasicProtectAll()throws SQLException{
        List<Protect> protects=DaoFactory.getBasicUserDaoInstance().findBasicProtectAll();
        protects.forEach(System.out::println);
        ArrayList<String> value=new ArrayList<>();
        for (Protect protect : protects)
        {
            value.add(protect.getProtectName());
        }
        String[] str=value.toArray(new String[value.size()]);
        System.out.println(Arrays.toString(str));
    }
    @Test
    public void testTestFindBasicUserByUserName() {
        String id="浅";
        List<order> orders=null;
        try {
            orders=DaoFactory.getBasicUserDaoInstance().findBasicOrderByOrderName(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        orders.forEach(System.out::println);
    }
}