package southWind.dao;

import org.junit.Test;
import southWind.entity.LoginAdmin;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;
import southWind.factory.DaoFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminDaoTest {
    private final AdminLoginDao adminDao= DaoFactory.getAdminDaoInstance();
    private  final UserLoginDao userDao=DaoFactory.getUserDaoInstance();
    private  final MemberLoginDao memberDao=DaoFactory.getMemberDaoInstance();

    @Test
    public void findAdminByAccount() {
        LoginAdmin admin;
        try {
            admin=adminDao.findAdminByAccount("123456");
            assertEquals("测试帐号",admin.getAdmin_name());
            System.out.println(admin);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void findUserByAccount() {
        LoginUser user;
        try {
            user=userDao.findUserByAccount("794359756");
            assertEquals("浅梦",user.getUser_name());
            System.out.println(user);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void findMemberByAccount() {
        LoginMember member;
        try {
            member=memberDao.findMemberByAccount("2711664540");
            assertEquals("南风",member.getMember_name());
            System.out.println(member);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}