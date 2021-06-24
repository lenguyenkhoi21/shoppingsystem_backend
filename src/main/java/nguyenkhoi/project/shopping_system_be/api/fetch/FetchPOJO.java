package nguyenkhoi.project.shopping_system_be.api.fetch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FetchPOJO {
    private long product_id;
    private String name;
    private String image;
    private String description;
    private int price;
}
