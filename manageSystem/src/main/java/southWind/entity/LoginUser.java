package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginUser
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginUser {
    private int id;
    private String account;
    private String password;
    private String user_name;
}
