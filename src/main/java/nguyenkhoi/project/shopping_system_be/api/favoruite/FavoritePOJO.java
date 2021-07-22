package nguyenkhoi.project.shopping_system_be.api.favoruite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePOJO {
    private long product_id;
    private String product_name;
    private String product_image;
}
