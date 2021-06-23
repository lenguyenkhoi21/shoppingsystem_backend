package nguyenkhoi.project.shopping_system_be.api.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GETHistoryResponse {
    private List<HistoryPOJO> history;
    private String message;
}
