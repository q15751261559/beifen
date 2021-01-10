package southWind.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class order {
    private String orderId;
    private String orderProduct;
    private LocalDateTime orderDatetime;
}
