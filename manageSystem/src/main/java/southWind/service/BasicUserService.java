package southWind.service;

import southWind.entity.User;
import southWind.entity.Vo.UserOutComeVo;
import southWind.entity.Vo.UserVo;

import java.util.List;

/**
 * @ClassName BaiscUserService
 * @Description TODO
 * @Author 86139
 * @Date 2020/12/31
 **/

public interface BasicUserService {
    /**
     * 查找用户的基本信息
     * @param id
     * @return
     */
    List<UserVo> findUser(String id);

    /**
     * 查找用户的消费情况
     * @param id
     * @return
     */
    List<UserOutComeVo> findUserOutCome(String id);
}
