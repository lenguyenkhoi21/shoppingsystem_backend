/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.repository.mongo;

import nguyenkhoi.project.shopping_system_be.common.model.mongo.ProductMG;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMGRepo extends MongoRepository<ProductMG, String> {
    List<ProductMG> findAllByNameLike(String name);
    ProductMG findByProductId(long productId);
}
