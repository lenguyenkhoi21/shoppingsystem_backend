/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.init;

import nguyenkhoi.project.shopping_system_be.common.mapper.ProductMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mongo.ProductMG;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.Product;
import nguyenkhoi.project.shopping_system_be.common.repository.mongo.ProductMGRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/init")
public class InitController {
    private final DataPrdDummy dataPrdDummy;
    private final ProductMapper productMapper;
    private final ProductMGRepo productMGRepo;

    public InitController(DataPrdDummy dataPrdDummy,
                          ProductMapper productMapper,
                          ProductMGRepo productMGRepo) {
        this.dataPrdDummy = dataPrdDummy;
        this.productMapper = productMapper;
        this.productMGRepo = productMGRepo;
    }



    @GetMapping
    public InitRes initRes() throws Exception {

        Product product1 = Product
                .builder()
                .name(dataPrdDummy.getName1())
                .image(dataPrdDummy.getImage1())
                .description(dataPrdDummy.getDescription1())
                .price(dataPrdDummy.getPrice1())
                .status(dataPrdDummy.isStatus1())
                .build();

        Product product2 = Product
                .builder()
                .name(dataPrdDummy.getName2())
                .image(dataPrdDummy.getImage2())
                .description(dataPrdDummy.getDescription2())
                .price(dataPrdDummy.getPrice2())
                .status(dataPrdDummy.isStatus2())
                .build();

        Product product3 = Product
                .builder()
                .name(dataPrdDummy.getName3())
                .image(dataPrdDummy.getImage3())
                .description(dataPrdDummy.getDescription3())
                .price(dataPrdDummy.getPrice3())
                .status(dataPrdDummy.isStatus3())
                .build();

        Product product4 = Product
                .builder()
                .name(dataPrdDummy.getName4())
                .image(dataPrdDummy.getImage4())
                .description(dataPrdDummy.getDescription4())
                .price(dataPrdDummy.getPrice4())
                .status(dataPrdDummy.isStatus4())
                .build();

        Product product5 = Product
                .builder()
                .name(dataPrdDummy.getName5())
                .image(dataPrdDummy.getImage5())
                .description(dataPrdDummy.getDescription5())
                .price(dataPrdDummy.getPrice5())
                .status(dataPrdDummy.isStatus5())
                .build();

        Product product6 = Product
                .builder()
                .name(dataPrdDummy.getName6())
                .image(dataPrdDummy.getImage6())
                .description(dataPrdDummy.getDescription6())
                .price(dataPrdDummy.getPrice6())
                .status(dataPrdDummy.isStatus6())
                .build();

        Product product7 = Product
                .builder()
                .name(dataPrdDummy.getName7())
                .image(dataPrdDummy.getImage7())
                .description(dataPrdDummy.getDescription7())
                .price(dataPrdDummy.getPrice7())
                .status(dataPrdDummy.isStatus7())
                .build();

        int res1 = productMapper.insertInit(product1);
        int res2 =productMapper.insertInit(product2);
        int res3 =productMapper.insertInit(product3);
        int res4 =productMapper.insertInit(product4);
        int res5 =productMapper.insertInit(product5);
        int res6 =productMapper.insertInit(product6);
        int res7 =productMapper.insertInit(product7);

        productMapper.selectAllProduct()
                     .stream()
                     .map(product -> ProductMG
                             .builder()
                             .product_id(product.getProduct_id())
                             .name(product.getName())
                             .image(product.getImage())
                             .description(product.getDescription())
                             .price(product.getPrice())
                             .status(product.isStatus())
                             .build())
                     .collect(Collectors.toList())
                     .forEach(productMGRepo::save);

        return InitRes
                .builder()
                .message("Success")
                .build();
    }
}
