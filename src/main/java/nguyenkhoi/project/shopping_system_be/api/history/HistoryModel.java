package nguyenkhoi.project.shopping_system_be.api.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryModel {
    private long bill_id;
    private String name;
    private int count;
    private int price;
}
