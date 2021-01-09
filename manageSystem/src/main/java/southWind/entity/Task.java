package southWind.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName Task
 * @Description TODO
 * @Author 南风
 * @Date 2020/12/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Task {
    private String taskId;
    private String memberId;
    private String userMember;
    private String profit;
    private LocalDateTime TaskTime;
    private String 实施情况;
}
