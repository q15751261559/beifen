package southWind.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class order {
    private String orderId;
    private String orderProductId;
    private String orderProductName;
    private Date orderDatetime;
    private String userId;
    private String userName;
    private String userCredit;
    private String productType;
    private String price;
    private Date productDatetime;
}
