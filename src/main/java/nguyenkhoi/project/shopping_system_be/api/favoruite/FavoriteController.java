/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.favoruite;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;


    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }


    @GetMapping("/{phone}")
    @PreAuthorize("hasRole('USER')")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public GETFavoriteResponse favoriteResponse(@PathVariable String phone) {
        return favoriteService.favoriteResponse(phone);
    }

    @PatchMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public PATCHFavoriteResponse patchFavoriteResponse(@RequestBody PATCHFavoritePayload payload) {
        return favoriteService.patchFavoriteResponse(payload);
    }
}
