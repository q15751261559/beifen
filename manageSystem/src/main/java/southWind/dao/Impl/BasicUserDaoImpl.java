package southWind.dao.Impl;

import southWind.dao.BasicUserDao;
import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;
import southWind.factory.DaoFactory;
import southWind.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BasicUserDaoImpl
 * @Description TODO
 * @Author
 * @Date 2020/12/31
 **/

public class BasicUserDaoImpl implements BasicUserDao {
    @Override
    public List<UserVo> findBasicUserByUserName(String userName) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT 客户编号,客户姓名,联系方式,联系地址,信用度 FROM 客户 WHERE 客户编号 LIKE ? or 客户姓名 LIKE ? or 联系地址 like ?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        System.out.println(userName);
        pstmt.setString(1,userName+"%");
        pstmt.setString(2,"%"+userName+"%");
        pstmt.setString(3,"%"+userName+"%");
        System.out.println(pstmt);
        ResultSet rs=pstmt.executeQuery();
        List<UserVo> userList=new ArrayList<>();
        while(rs.next())
        {
            UserVo vo=UserVo.builder()
                    .id(rs.getString("客户编号"))
                    .name(rs.getString("客户姓名"))
                    .phone(rs.getString("联系方式"))
                    .address(rs.getString("联系地址"))
                    .credit(rs.getString("信用度"))
                    .build();
            userList.add(vo);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
       return  userList;
    }


    @Override
    public List<UserVo> findBasicUserAll() throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT 客户编号,客户姓名,联系方式,联系地址,信用度 FROM 客户";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<UserVo> userList=new ArrayList<>();
        while(rs.next())
        {
            UserVo vo=UserVo.builder()
                    .id(rs.getString("客户编号"))
                    .name(rs.getString("客户姓名"))
                    .phone(rs.getString("联系方式"))
                    .address(rs.getString("联系地址"))
                    .credit(rs.getString("信用度"))
                    .build();
            userList.add(vo);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return  userList;
    }

    @Override
    public List<UserOutComeVo> findUserOutComeById(String userId) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="select 客户编号,客户姓名,所购产品,价格,消费时间\n" +
                "From 客户,产品\n" +
                "where 客户.所购产品=产品.产品名称 and 客户编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,userId);
        ResultSet rs=pstmt.executeQuery();
        List<UserOutComeVo> vo=new ArrayList<>();
        while(rs.next())
        {
            UserOutComeVo vo1=UserOutComeVo.builder()
                    .id(rs.getString("客户编号"))
                    .name(rs.getString("客户姓名"))
                    .price(rs.getString("价格"))
                    .time(rs.getDate("消费时间"))
                    .build();
            vo.add(vo1);
        }
        rs.close();
        connection.close();
        pstmt.close();
        return vo;
    }
}
