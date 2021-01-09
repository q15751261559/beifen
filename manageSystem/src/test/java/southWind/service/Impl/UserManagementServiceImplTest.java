package southWind.service.Impl;

import org.junit.Test;
import southWind.entity.User;
import southWind.entity.Vo.UserVoBuy;
import southWind.factory.ServiceFactory;
import southWind.service.UserManagementService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class UserManagementServiceImplTest {
    private final UserManagementService userManagementService= ServiceFactory.getUserManagementServiceInstance();
    @Test
    public void addUser() {
        User user=User.builder().userId("6").userName("大大").userProduct("Java").userDateTime(LocalDateTime.now()).build();
        userManagementService.addUser(user);
    }

    @Test
    public void deleteUser() {
        User user=User.builder().userId("6").build();
        userManagementService.deleteUser(user);

    }

    @Test
    public void changeUser() {
        User user=User.builder().userName("潇潇").userPhone("123456789").userAddress("江苏省南京市江宁区").userId("6").build();
        userManagementService.changeUser(user);

    }

    @Test
    public void findUser() {
        User user=User.builder().userId("1").build();
        userManagementService.findUser(user.getUserId());
    }

    @Test
    public void findUserProduct() {
        List<UserVoBuy> list=userManagementService.findUserProduct("1");
        list.forEach(System.out::println);
    }
}