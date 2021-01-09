package southWind.dao;

import southWind.entity.Member;
import southWind.entity.User;
import southWind.entity.Vo.MemberVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BasicMemberDao
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/31
 **/

public interface BasicMemberDao {
    /**
     * 查找成员基本信息
     * @param  memberId
     * @return
     * @exception SQLException
     */
    List<Member> findBasicMember(String memberId) throws SQLException;

    /**
     *
     * 根据员工id查业绩
     * @param memberId
     * @return
     * @throws SQLException
     */
    List<MemberVo> findBasicMemberIncome(String memberId) throws SQLException;
}
