package southWind.dao.Impl;

import jdk.nashorn.internal.scripts.JD;
import southWind.dao.BasicMemberDao;
import southWind.entity.Member;
import southWind.entity.Protect;
import southWind.entity.Task;
import southWind.entity.User;
import southWind.entity.Vo.MemberVo;
import southWind.utils.JdbcUtil;
import sun.nio.cs.ext.MS874;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName BasicMemberDaoImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/31
 **/

public class BasicMemberDaoImpl implements BasicMemberDao {
    @Override
    public List<Member> findBasicMember(String memberId) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT *FROM 联系人 WHERE 联系人编号=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,memberId);
        ResultSet rs=pstmt.executeQuery();
        Member member=new Member();
        List<Member> members=new ArrayList<>();
        while(rs.next()){
            String id=rs.getString("联系人编号");
            String name=rs.getString("姓名");
            String department=rs.getString("所属部门");
            String product=rs.getString("产品类型");
            String taskId=rs.getString("任务计划编号");
            String inCome=rs.getString("工资");
            String phone=rs.getString("联系方式");
            member.setMemberId(id);
            member.setMemberName(name);
            member.setMemberDepartment(department);
            member.setProductType(product);
            member.setTaskId(taskId);
            member.setIncome(inCome);
            member.setMemberPhone(phone);
            members.add(member);
        }

        rs.close();
        connection.close();
        pstmt.close();
        return members;

    }

    @Override
    public List<MemberVo> findBasicMemberIncome(String memberId) throws SQLException {
        JdbcUtil jdbcUtil=JdbcUtil.getInitJdbcUtil();
        Connection connection=jdbcUtil.getConnection();
        String sql="SELECT `客户编号`,`客户姓名`,`所购产品`,`价格`,`消费时间`\n" +
                "FROM `客户`,`联系人`,`产品`\n" +
                "WHERE `客户`.`联系人编号`=`联系人`.`联系人编号` AND `联系人`.`产品类型`=`产品`.`产品类型` AND `联系人`.`联系人编号`= ?\n";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setString(1,memberId);
        ResultSet rs=pstmt.executeQuery();
        List<MemberVo> memberVos=new ArrayList<>();
        while(rs.next()){
            MemberVo memberVo=MemberVo.builder()
                    .Id(rs.getString("客户编号"))
                    .name(rs.getString("客户姓名"))
                    .type(rs.getString("所购产品"))
                    .price(rs.getString("价格"))
                    .time(rs.getTimestamp("消费时间"))
                    .build();
            memberVos.add(memberVo);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return memberVos;
    }
}
