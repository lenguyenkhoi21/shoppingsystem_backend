/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.history.bill;

import nguyenkhoi.project.shopping_system_be.api.history.DetailPOJO;
import nguyenkhoi.project.shopping_system_be.api.history.HistoryMapper;
import nguyenkhoi.project.shopping_system_be.api.history.HistoryModel;
import nguyenkhoi.project.shopping_system_be.common.mapper.BillMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Bill;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class BillService {
    private final BillMapper billMapper;
    private final HistoryMapper historyMapper;

    public BillService(BillMapper billMapper,
                       HistoryMapper historyMapper) {
        this.billMapper = billMapper;
        this.historyMapper = historyMapper;
    }

    @Transactional
    public GETBillResponse billResponse(String phone) {
        return GETBillResponse
                .builder()
                .billList(
                        billMapper.selectAllBillByPhone(
                                Bill
                                        .builder()
                                        .phone(phone)
                                        .build())
                                  .stream()
                                  .map(bill -> BillPOJO
                                          .builder()
                                          .bill_id(bill.getBill_id())
                                          .time(bill.getTime().toLocalDateTime().toLocalTime().toString())
                                          .date(bill.getTime().toLocalDateTime().toLocalDate().toString())
                                          .build())
                                  .collect(Collectors.toList())
                )
                .message(Constant.msgSuccess)
                .build();
    }

    @Transactional
    public GETBillDetailResponse detailResponse(long bill_id) {
        return GETBillDetailResponse
                .builder()
                .total(billMapper.selectBillById(bill_id).getTotal())
                .detail(historyMapper.selectUserHistoryDetails(
                        HistoryModel
                                .builder()
                                .bill_id(bill_id)
                                .build()
                        )
                        .stream()
                        .map(historyModel -> DetailPOJO
                                .builder()
                                .product_name(historyModel.getName())
                                .count(historyModel.getCount())
                                .sum(historyModel.getCount() * historyModel.getPrice())
                                .price(historyModel.getPrice())
                                .build()
                        )
                        .collect(Collectors.toList())
                )
                .message(Constant.msgSuccess)
                .build();
    }



}
