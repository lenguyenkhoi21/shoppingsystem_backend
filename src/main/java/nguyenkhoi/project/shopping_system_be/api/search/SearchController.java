/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public GETSearchResponse searchResponse(@PathVariable String name) {
        return service.Search(name);
    }
}
