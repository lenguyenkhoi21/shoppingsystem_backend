/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.signup;

import nguyenkhoi.project.shopping_system_be.common.mapper.UserMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mongo.FavoriteMG;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.User;
import nguyenkhoi.project.shopping_system_be.common.repository.mongo.CartMGRepo;
import nguyenkhoi.project.shopping_system_be.common.repository.mongo.ProductMGRepo;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import nguyenkhoi.project.shopping_system_be.common.util.ResourceFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SignupService {
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final CartMGRepo cartMGRepo;
    private final ProductMGRepo productMGRepo;

    public SignupService(UserMapper userMapper,
                         PasswordEncoder encoder,
                         CartMGRepo cartMGRepo,
                         ProductMGRepo productMGRepo) {
        this.userMapper = userMapper;
        this.encoder = encoder;
        this.cartMGRepo = cartMGRepo;
        this.productMGRepo = productMGRepo;
    }

    @Transactional
    public POSTSignupResponse signup(POSTSignupPayload payload) throws Exception {
        User user = User
                .builder()
                .phone(payload.getPhone())
                .password(encoder.encode(payload.getPassword()))
                .name(payload.getName())
                .email(payload.getEmail())
                .avatar(ResourceFile.getAvatarImage())
                .build();

        if (userMapper.insertUser(user) == 1) {


            productMGRepo.findAll()
                         .forEach(productMG -> {
                             cartMGRepo.save(FavoriteMG
                                     .builder()
                                     .phone(user.getPhone())
                                     .product_id(productMG.getProduct_id())
                                     .product_name(productMG.getName())
                                     .product_image(productMG.getImage())
                                     .like(false)
                                     .build());
                         });



            return POSTSignupResponse
                     .builder()
                     .message(Constant.msgSuccess)
                     .build();
        }

        throw new Exception();
    }
}
