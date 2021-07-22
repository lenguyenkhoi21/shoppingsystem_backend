package nguyenkhoi.project.shopping_system_be.api.favoruite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PATCHFavoritePayload {
    private String phone;
    private long product_id;
    private boolean status;
}
