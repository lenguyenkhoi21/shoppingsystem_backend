/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.history.bill;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history/bill")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{phone}")
    @PreAuthorize("hasRole('USER')")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public GETBillResponse getBillResponse(@PathVariable String phone) {
        return billService.billResponse(phone);
    }

    @GetMapping("/detail/{billId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public GETBillDetailResponse detailResponse(
            @PathVariable long billId) {
        return billService.detailResponse(billId);
    }
}
