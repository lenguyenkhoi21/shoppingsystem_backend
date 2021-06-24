package nguyenkhoi.project.shopping_system_be.api.favoruite;

import nguyenkhoi.project.shopping_system_be.common.model.mongo.FavoriteMG;
import nguyenkhoi.project.shopping_system_be.common.repository.mongo.FavoriteMGRepo;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FavoriteService {
    private final FavoriteMGRepo favoriteMGRepo;

    public FavoriteService(FavoriteMGRepo favoriteMGRepo) {
        this.favoriteMGRepo = favoriteMGRepo;
    }

    public GETFavoriteResponse favoriteResponse(String phone){
        return GETFavoriteResponse
                .builder()
                .favorite(
                    favoriteMGRepo
                        .findAllByPhoneAndLove(phone, true)
                        .stream()
                        .map(favoriteMG -> FavoritePOJO
                                .builder()
                                .product_id(favoriteMG.getProductId())
                                .product_name(favoriteMG.getProductName())
                                .product_image(favoriteMG.getProductImage())
                                .build())
                        .collect(Collectors.toList()))
                .message(Constant.msgSuccess)
                .build();
    }

    public PATCHFavoriteResponse patchFavoriteResponse(PATCHFavoritePayload payload) {
        FavoriteMG favoriteMG = favoriteMGRepo
                .findByProductIdAndPhone(
                        payload.getProduct_id(),
                        payload.getPhone());

        favoriteMG.setLove(payload.isStatus());

        favoriteMGRepo.save(favoriteMG);

        return PATCHFavoriteResponse
                .builder()
                .message(Constant.msgSuccess)
                .build();
    }
}
