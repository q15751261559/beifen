package southWind.dao;

import org.junit.Test;
import southWind.entity.Member;
import southWind.entity.Vo.MemberVo;
import southWind.factory.DaoFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BasicMemberDaoTest {
    private final BasicMemberDao basicMemberDao= DaoFactory.getBasicMemberDaoInstance();


    @Test
    public void testFindBasicMember() throws SQLException {
        List<Member> list=DaoFactory.getBasicMemberDaoInstance().findBasicMember("001");
        list.forEach(System.out::println);

    }

    @Test
    public void findBasicMemberIncome() throws SQLException {

    }

    @Test
    public void testFindBasicMemberIncome() throws SQLException{
        List<MemberVo> list=DaoFactory.getBasicMemberDaoInstance(). findBasicMemberIncome("001");
        list.forEach(System.out::println);
    }
}