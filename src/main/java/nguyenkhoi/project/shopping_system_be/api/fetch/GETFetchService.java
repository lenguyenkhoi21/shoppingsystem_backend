/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.fetch;

import nguyenkhoi.project.shopping_system_be.common.model.mongo.ProductMG;
import nguyenkhoi.project.shopping_system_be.common.repository.mongo.ProductMGRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GETFetchService {
    private final ProductMGRepo productMGRepo;

    public GETFetchService(ProductMGRepo productMGRepo) {
        this.productMGRepo = productMGRepo;
    }

    public GETFetchResponse getAllProduct() {
        List<FetchPOJO> list = productMGRepo
                .findAll()
                .stream()
                .map(productMG -> FetchPOJO
                        .builder()
                        .product_id(productMG.getProductId())
                        .name(productMG.getName())
                        .image(productMG.getImage())
                        .description(productMG.getDescription())
                        .price(productMG.getPrice())
                        .build())
                .collect(Collectors.toList());

        return GETFetchResponse
                .builder()
                .products(list)
                .build();
    }

    public GETProductResponse getProductById(long id) {
        ProductMG productMG = productMGRepo.findByProductId(id);
        return GETProductResponse
                .builder()
                .product_id(productMG.getProductId())
                .name(productMG.getName())
                .description(productMG.getDescription())
                .image(productMG.getImage())
                .price(productMG.getPrice())
                .build();
    }

    public GETTotalProductResponse getTotalProduct() {
        return GETTotalProductResponse
                .builder()
                .count( productMGRepo.findAll().toArray().length)
                .build();
    }
}
