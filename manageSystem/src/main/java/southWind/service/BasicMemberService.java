package southWind.service;

import southWind.entity.Member;
import southWind.entity.Vo.MemberVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BasicMemberService
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/31
 **/

public interface BasicMemberService  {
    /**
     * 查询员工基本信息
     * @param memberId
     * @return
     * @throws SQLException
     */
    List<Member> findMember(String memberId) throws SQLException;

    /**
     * 查找员工的收入情况
     * @param memberId
     * @return
     * @throws SQLException
     */
    List<MemberVo> findMemberInCome(String memberId) throws SQLException;
}
