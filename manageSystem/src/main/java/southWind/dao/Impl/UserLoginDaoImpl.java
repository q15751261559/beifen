package southWind.dao.Impl;

import southWind.dao.UserLoginDao;
import southWind.dao.UserLoginDao;
import southWind.entity.LoginUser;
import southWind.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public LoginUser findUserByAccount(String account) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT * FROM t_user WHERE account = ?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,account);
        ResultSet rs=pstmt.executeQuery();
        LoginUser user=null;
        while (rs.next()){
            int id=rs.getInt("id");
            String UserAccount=rs.getString("account");
            String Password=rs.getString("password");
            String UserName=rs.getString("user_name");
            user=new LoginUser();
            user.setId(id);
            user.setAccount(UserAccount);
            user.setPassword(Password);
            user.setUser_name(UserName);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return user;
    }
}
