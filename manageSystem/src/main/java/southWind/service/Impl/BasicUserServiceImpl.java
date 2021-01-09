package southWind.service.Impl;

import southWind.dao.BasicUserDao;
import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;
import southWind.factory.DaoFactory;
import southWind.service.BasicUserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BasicUserServiceImpl
 * @Description TODO
 * @Author
 * @Date 2020/12/31
 **/

public class BasicUserServiceImpl  implements BasicUserService {
    private BasicUserDao basicUserDao = DaoFactory.getBasicUserDaoInstance();

    @Override
    public List<UserVo> findUser(String userName) {
        List<UserVo> userVos=null;
        try {
            userVos=basicUserDao.findBasicUserByUserName(userName);
        }catch (SQLException e){
            System.err.println("查询出现问题");
        }
        return userVos;
    }

    @Override
    public List<UserOutComeVo> findUserOutCome(String id) {
        List<UserOutComeVo> userOutComeVos=null;
        try{
            userOutComeVos=basicUserDao.findUserOutComeById(id);
        }catch (SQLException e){
            System.err.println("查询出现问题");
        }
        return userOutComeVos;
    }
}

