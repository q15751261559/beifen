package southWind.service;

import org.junit.Test;
import southWind.dao.BasicUserDao;
import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;
import southWind.factory.ServiceFactory;

import java.util.List;

import static org.junit.Assert.*;

public class BasicUserServiceTest {
    private final BasicUserService basicUserService= ServiceFactory.getBasicUserServiceInstance();
    @Test
    public void findUser() {
        List<UserVo> voList=basicUserService.findUser("1");
        voList.forEach(System.out::println);
    }
    @Test
    public void findUserOutCome(){
        List<UserOutComeVo> vos=basicUserService.findUserOutCome("1");
        vos.forEach(System.out::println);
    }
}