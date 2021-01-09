package southWind.service;

import org.junit.Test;
import southWind.factory.ServiceFactory;
import southWind.utils.ResultEntity;

import static org.junit.Assert.*;

public class MemberServiceTest {
    private final MemberLoginService memberService= ServiceFactory.getMemberServiceInstance();
    @Test
    public void memberLogin() {
        ResultEntity resultEntity=memberService.memberLogin("2711664540", "123456");
        assertEquals(2,resultEntity.getCode());

        System.out.println(resultEntity);
    }
}