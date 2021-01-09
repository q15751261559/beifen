package southWind.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author 南风
 * @Date 2021/1/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String credit;
}
