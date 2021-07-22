/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.mapper;

import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {
    int insertBill(Bill bill);
    Bill selectLastInsertBillByPhone(Bill bill);
    List<Bill> selectAllBillByPhone(Bill bill);
    Bill selectBillById(long bill);
}
