package nguyenkhoi.project.shopping_system_be.api.history;

import nguyenkhoi.project.shopping_system_be.common.mapper.BillMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Bill;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    private final BillMapper billMapper;
    private final HistoryMapper historyMapper;

    public HistoryService(BillMapper billMapper,
                          HistoryMapper historyMapper) {
        this.billMapper = billMapper;
        this.historyMapper = historyMapper;
    }

    @Transactional
    public GETHistoryResponse getHistoryResponse (String phone) {

        List<HistoryPOJO> historyPOJOS = billMapper.selectAllBillByPhone(Bill
                .builder()
                .phone(phone)
                .build())
                .stream()
                .map(bill -> HistoryPOJO
                        .builder()
                        .bill_id(bill.getBill_id())
                        .total(bill.getTotal())
                        .time(bill.getTime().toLocalDateTime().toLocalTime().toString())
                        .date(bill.getTime().toLocalDateTime().toLocalDate().toString())
                        .build())
                .collect(Collectors.toList());

        historyPOJOS.forEach(historyPOJO -> historyPOJO.setDetail(
                historyMapper.selectUserHistoryDetails(HistoryModel
                .builder()
                .bill_id(historyPOJO.getBill_id())
                .build())
                .stream()
                .map(model -> DetailPOJO
                        .builder()
                        .product_name(model.getName())
                        .count(model.getCount())
                        .sum(model.getCount() * model.getPrice())
                        .price(model.getPrice())
                        .build())
                .collect(Collectors.toList())
        ));

        return GETHistoryResponse
                .builder()
                .history(historyPOJOS)
                .message(Constant.msgSuccess)
                .build();
    }
}
