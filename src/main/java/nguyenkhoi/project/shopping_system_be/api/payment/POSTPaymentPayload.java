package nguyenkhoi.project.shopping_system_be.api.payment;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class POSTPaymentPayload {
    List<CartPOJO> cart;
    @NotEmpty
    private String phone;
    private int total;
}
