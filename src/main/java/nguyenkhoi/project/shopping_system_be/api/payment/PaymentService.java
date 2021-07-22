package nguyenkhoi.project.shopping_system_be.api.payment;

import nguyenkhoi.project.shopping_system_be.common.mapper.BillDetailMapper;
import nguyenkhoi.project.shopping_system_be.common.mapper.BillMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Bill;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Bill_Details;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private final BillMapper billMapper;
    private final BillDetailMapper billDetailMapper;


    public PaymentService(BillMapper billMapper,
                          BillDetailMapper billDetailMapper) {
        this.billMapper = billMapper;
        this.billDetailMapper = billDetailMapper;
    }

    @Transactional
    public POSTPaymentResponse payment(POSTPaymentPayload payload) {
        billMapper.insertBill(Bill
                .builder()
                .phone(payload.getPhone())
                .total(payload.getTotal())
                .build());

        Bill last = billMapper.selectLastInsertBillByPhone(Bill
                .builder()
                .phone(payload.getPhone())
                .build());

        payload.cart.forEach(cart -> {
            billDetailMapper.insertBillDetail(Bill_Details
                    .builder()
                    .bill_id(last.getBill_id())
                    .product_id(cart.getProduct_id())
                    .count(cart.getCount())
                    .build());
        });

        return POSTPaymentResponse
                .builder()
                .message(Constant.msgSuccess)
                .build();
    }
}
