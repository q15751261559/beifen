package southWind.dao.Impl;

import southWind.dao.MemberLoginDao;
import southWind.dao.MemberLoginDao;
import southWind.entity.LoginMember;
import southWind.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName MemberDaoImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class MemberLoginDaoImpl implements MemberLoginDao {
    @Override
    public LoginMember findMemberByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT * FROM t_member WHERE account = ?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,account);
        ResultSet rs=pstmt.executeQuery();
        LoginMember member=null;
        while (rs.next()){
            int id=rs.getInt("id");
            String adminAccount=rs.getString("account");
            String Password=rs.getString("password");
            String adminName=rs.getString("member_name");
            member=new LoginMember();
            member.setId(id);
            member.setAccount(adminAccount);
            member.setPassword(Password);
            member.setMember_name(adminName);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return member;
    }

}
