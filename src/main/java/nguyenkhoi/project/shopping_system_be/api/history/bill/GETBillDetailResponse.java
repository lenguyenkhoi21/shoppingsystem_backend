/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.history.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenkhoi.project.shopping_system_be.api.history.DetailPOJO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GETBillDetailResponse {
    private int total;
    private List<DetailPOJO> detail;
    private String message;
}
