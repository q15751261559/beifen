package southWind.service.Impl;

import southWind.dao.BasicMemberDao;
import southWind.entity.Member;
import southWind.entity.Vo.MemberVo;
import southWind.factory.DaoFactory;
import southWind.service.BasicMemberService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BasicMemberServiceImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/31
 **/

public class BasicMemberServiceImpl  implements BasicMemberService {
    private  final  BasicMemberDao basicMemberDao= DaoFactory.getBasicMemberDaoInstance();

    @Override
    public List< Member> findMember(String memberId) throws SQLException {
        List<Member> memberList=null;
        try{
            memberList=basicMemberDao.findBasicMember(memberId);

        }catch (SQLException e){
            System.err.println("查询出现问题");
        }
        return  memberList;
    }

    @Override
    public List<MemberVo> findMemberInCome(String memberId) throws SQLException {
        List<MemberVo> memberVos=null;
        try{
            memberVos=basicMemberDao.findBasicMemberIncome(memberId);
        }catch (SQLException e){
            System.err.println("查询出现异常");
        }
        return memberVos;
    }
}
