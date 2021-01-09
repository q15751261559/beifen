package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Protect
 * @Description TODO
 * @Author 南风
 * @Date 2021/1/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Protect {
    private String protectId;
    private String protectName;
    private Date createTime;
    private String protectType;
    private String price;
}
