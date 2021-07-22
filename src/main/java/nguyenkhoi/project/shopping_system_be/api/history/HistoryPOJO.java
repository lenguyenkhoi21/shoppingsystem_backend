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
public class HistoryPOJO {
    private long bill_id;
    private String time;
    private String date;
    private int total;
    private List<DetailPOJO> detail;
}
