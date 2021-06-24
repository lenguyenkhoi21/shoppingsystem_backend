package nguyenkhoi.project.shopping_system_be.api.favoruite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GETFavoriteResponse {
   private List<FavoritePOJO> favorite;
   private String message;
}
