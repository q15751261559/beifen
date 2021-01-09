package southWind.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserOutComeVo
 * @Description TODO
 * @Author 南风
 * @Date 2021/1/3
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOutComeVo {
    private String id;
    private String name;
    private String protect;
    private String price;
    private Date time;
}
