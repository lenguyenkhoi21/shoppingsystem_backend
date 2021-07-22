/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.search;

import nguyenkhoi.project.shopping_system_be.common.repository.mongo.ProductMGRepo;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final ProductMGRepo productMGRepo;

    public SearchService(ProductMGRepo productMGRepo) {
        this.productMGRepo = productMGRepo;
    }

    public GETSearchResponse Search(String name) {
        return GETSearchResponse
                .builder()
                .products(
                        productMGRepo.findAllByNameLike(name)
                                     .stream()
                                     .map(productMG -> SearchPOJO
                                             .builder()
                                             .product_id(productMG.getProductId())
                                             .name(productMG.getName())
                                             .image(productMG.getImage())
                                             .description(productMG.getDescription())
                                             .price(productMG.getPrice())
                                             .build()
                                     )
                                     .collect(Collectors.toList())
                )
                .message(Constant.msgSuccess)
                .build();
    }
}
