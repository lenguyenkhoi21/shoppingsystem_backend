/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavoriteMGRepo extends MongoRepository<nguyenkhoi.project.shopping_system_be.common.model.mongo.FavoriteMG, String> {

}
