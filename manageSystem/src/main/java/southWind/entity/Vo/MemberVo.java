package southWind.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName memberVo
 * @Description TODO
 * @Author 南风
 * @Date 2021/1/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVo {
private String Id;
private String name;
private String type;
private String price;
private Date time;
}
