/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.dev;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import nguyenkhoi.project.shopping_system_be.common.util.ResourceFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/text")
public class Dummy {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public Res res() throws Exception {
        return Res
                .builder()
                .message(ResourceFile.getLoremipsum())
                .build();
    }

}
