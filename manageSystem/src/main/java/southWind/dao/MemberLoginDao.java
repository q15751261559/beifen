package southWind.dao;

import southWind.entity.LoginMember;

import java.sql.SQLException;

/**
 * @ClassName MemberDao
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/29
 **/

public interface MemberLoginDao {
    /**
     * 根据帐号查询员工
     * @param account
     * @return
     * @throws SQLException
     */
    LoginMember findMemberByAccount(String account) throws SQLException;



}
