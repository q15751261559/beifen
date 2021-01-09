package southWind.service.Impl;

import southWind.dao.UserManagementDao;
import southWind.entity.User;
import southWind.entity.Vo.UserVoBuy;
import southWind.factory.DaoFactory;
import southWind.service.UserManagementService;

import java.rmi.ServerError;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserManagementServiceImpl
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/

public class UserManagementServiceImpl  implements UserManagementService {
    private  final  UserManagementDao userManagementDao=DaoFactory.getUserManagementDaoInstance();
    @Override
    public int addUser(User user) {
        int n=0;
        try{
            n= userManagementDao.insertUser(user);
        }catch (SQLException e){
            System.err.println("新增用户出现异常");
        }
        return n;
    }

    @Override
    public int deleteUser(User user) {
        int n=0;
        try{
            n=userManagementDao.removeUser(user);
        }catch (SQLException e){
            System.err.println("删除用户出现异常");
        }
        return n;
    }

    @Override
    public int changeUser(User user) {
        int n=0;
        try{
            n=userManagementDao.updateUser(user);
        }catch (SQLException e){
            System.err.println("修改用户出现异常");
        }
        return n;
    }

    @Override
    public List<User> findUser(String id) {
       List<User> userList=null;
       try{
           userList=userManagementDao.getAll(id);
       }catch (SQLException e)
       {
           System.err.println("查询出现问题");
       }
       return userList;
    }

    @Override
    public List<UserVoBuy> findUserProduct(String id) {
        List<UserVoBuy> userVoBuys=null;
        try{
            userVoBuys=userManagementDao.findUserProtectById(id);
        }catch (SQLException e){
            System.err.println("查询出现问题" );
        }
        return userVoBuys;
    }


}
