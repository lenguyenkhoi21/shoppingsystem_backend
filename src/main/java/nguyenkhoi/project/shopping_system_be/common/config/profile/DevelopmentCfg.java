/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.config.profile;

import nguyenkhoi.project.shopping_system_be.api.init.DataPrdDummy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevelopmentCfg {
    @Bean
    public DataPrdDummy getDataPrdDummy() {
        return new DataPrdDummy();
    }
}
