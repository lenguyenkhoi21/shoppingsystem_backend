/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.fetch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fetch")
public class FetchController {

    private final GETFetchService getFetchService;

    public FetchController(GETFetchService getFetchService) {
        this.getFetchService = getFetchService;
    }

    @GetMapping
    public GETFetchResponse fetchData() {
        return getFetchService.getAllProduct();
    }
}
