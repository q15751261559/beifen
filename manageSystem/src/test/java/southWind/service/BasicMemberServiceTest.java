package southWind.service;

import org.junit.Test;
import southWind.entity.Member;
import southWind.entity.Vo.MemberVo;
import southWind.factory.ServiceFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BasicMemberServiceTest {
    private  final BasicMemberService basicMemberService= ServiceFactory.getBasicMemberServiceInstance();
    @Test
    public void findMember() throws SQLException {
        List<Member> memberList=basicMemberService.findMember("001");
        memberList.forEach(System.out::println);
    }

    @Test
    public void testFindMember() {
    }

    @Test
    public void findMemberInCome() throws SQLException {
        List<MemberVo> memberVoList=basicMemberService.findMemberInCome("001");
        memberVoList.forEach(System.out::println);

    }



}