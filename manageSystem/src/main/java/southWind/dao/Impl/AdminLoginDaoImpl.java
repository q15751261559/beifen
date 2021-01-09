package southWind.dao.Impl;

import southWind.dao.AdminLoginDao;
import southWind.dao.AdminLoginDao;
import southWind.entity.LoginAdmin;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;
import southWind.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName AdminDaoImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class AdminLoginDaoImpl implements AdminLoginDao {

    @Override
    public LoginAdmin findAdminByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT * FROM t_admin WHERE account = ?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,account);
        ResultSet rs=pstmt.executeQuery();
        LoginAdmin admin=null;
        while (rs.next()){
            int id=rs.getInt("id");
            String adminAccount=rs.getString("account");
            String Password=rs.getString("password");
            String adminName=rs.getString("admin_name");
            admin=new LoginAdmin();
            admin.setId(id);
            admin.setAccount(adminAccount);
            admin.setPassword(Password);
            admin.setAdmin_name(adminName);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return admin;
    }




}
