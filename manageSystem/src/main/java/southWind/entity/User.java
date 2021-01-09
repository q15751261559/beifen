package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userCredit;
    private String userProduct;
    private LocalDateTime userDateTime;
    private  String memberId;

}
