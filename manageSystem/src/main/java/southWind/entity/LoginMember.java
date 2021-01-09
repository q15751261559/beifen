package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginMember
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginMember {
    private int id;
    private String account;
    private String password;
    private String member_name;
    public int authority;
}
