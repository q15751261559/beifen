package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Member
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private String memberId;
    private String memberName;
    private String memberDepartment;
    private String productType;
    private String taskId;
    private String income;
    private String memberPhone;
}
