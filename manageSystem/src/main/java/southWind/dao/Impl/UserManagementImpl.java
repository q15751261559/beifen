package southWind.dao.Impl;

import jdk.nashorn.internal.scripts.JD;
import southWind.dao.UserManagementDao;
import southWind.dao.UserManagementDao;
import southWind.entity.User;
import southWind.entity.Vo.UserVo;
import southWind.entity.Vo.UserVoBuy;
import southWind.entity.order;
import southWind.utils.DateUtils;
import southWind.utils.JdbcUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserManagementImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/

public class UserManagementImpl implements UserManagementDao {
    DateUtils utils=new DateUtils();
    @Override
    public int insertUser(User user) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql2="SELECT 客户编号 FROM 客户";
        PreparedStatement pstmt2=connection.prepareStatement(sql2);
        ResultSet rs=pstmt2.executeQuery();
        String id="";
        while(rs.next())
        {
            id=rs.getString("客户编号");
        }
        String sql="INSERT INTO 客户 (客户编号,客户姓名,联系方式,联系地址,信用度) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,String.valueOf(Integer.parseInt(id)+1));
        pstmt.setString(2,user.getUserName());
        pstmt.setString(3,user.getUserPhone());
        pstmt.setObject(4,user.getUserAddress());
        pstmt.setObject(5,"100");
        int n=pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int removeUser(User user) throws SQLException {
       JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
       Connection connection=jdbcUtil.getConnection();
       String sql="DELETE FROM 客户 WHERE 客户编号 = ?";
       PreparedStatement pstmt=connection.prepareStatement(sql);
       pstmt.setString(1,user.getUserId());
       int n=pstmt.executeUpdate();
       pstmt.close();
       connection.close();
       return  n;
    }

    @Override
    public int updateUser(User user) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="UPDATE 客户 SET 客户姓名=?,联系方式=?,联系地址=?,信用度=? WHERE 客户编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,user.getUserName());
        pstmt.setString(2,user.getUserPhone());
        pstmt.setString(3,user.getUserAddress());
        pstmt.setString(4,user.getUserCredit());
        pstmt.setString(5,user.getUserId());
        int n=pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<User> getAll(String userId) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT 客户姓名,联系方式,联系地址,信用度 FROM 客户 WHERE 客户编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,userId);
        ResultSet rs=pstmt.executeQuery();
        List<User> userList=new ArrayList<>();
        User user=new User();
        while (rs.next())
        {
            user.setUserName(rs.getString("客户姓名"));
            user.setUserPhone(rs.getString("联系方式"));
            user.setUserAddress(rs.getString("联系方式"));
            user.setUserCredit(rs.getString("信用度"));
            userList.add(user);
        }

        return userList;
    }

    public int updateOrder(order order)throws SQLException
    {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="UPDATE 订单 SET 订单产品=?,购买时间=? WHERE 订单编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,order.getOrderProductId());
        pstmt.setTimestamp(2,new Timestamp(order.getOrderDatetime().getTime()));
        pstmt.setString(3,order.getOrderId());
        int n=pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public List<UserVoBuy> findUserProtectById(String userId) throws SQLException {
        JdbcUtil jdbcUtil= JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT 所购产品,消费时间 FROM 客户 WHERE 客户编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,userId);
        ResultSet rs=pstmt.executeQuery();
      List<UserVoBuy> voBuys=new ArrayList<>();
        while(rs.next()){
            UserVoBuy voBuy= UserVoBuy.builder()
                    .protect(rs.getString("所购产品"))
                    .time(rs.getTimestamp("消费时间"))
                    .build();
            voBuys.add(voBuy);
        }
        rs.close();
        pstmt.close();
        connection.close();
        return voBuys;
    }
}
