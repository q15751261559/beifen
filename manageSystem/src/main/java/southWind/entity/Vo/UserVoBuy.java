package southWind.entity.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName UserVoBuy
 * @Description TODO
 * @Author 南风
 * @Date 2021/1/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVoBuy {
    private String protect;
    private Date time;
}
