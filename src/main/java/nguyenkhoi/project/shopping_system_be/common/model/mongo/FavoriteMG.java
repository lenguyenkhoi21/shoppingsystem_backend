/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteMG {
    @Id
    private String id;
    private String phone;
    private long productId;
    private String productName;
    private String productImage;
    private boolean love;
}
