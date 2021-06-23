package nguyenkhoi.project.shopping_system_be.api.history;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetailPOJO {
    private String product_name;
    private int count;
    private int sum;
}
