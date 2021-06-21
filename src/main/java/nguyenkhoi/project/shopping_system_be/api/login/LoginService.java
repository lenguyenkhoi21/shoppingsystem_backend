/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.login;

import nguyenkhoi.project.shopping_system_be.common.security.JwtTokenProvider;
import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public LoginService(AuthenticationManager authenticationManager,
                        JwtTokenProvider tokenProvider) {

        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    public POSTLoginResponse login(POSTLoginPayload payload) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        payload.getPhone(),
                        payload.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);

        return POSTLoginResponse
                .builder()
                .message(Constant.msgSuccess)
                .token(token)
                .build();
    }
}
