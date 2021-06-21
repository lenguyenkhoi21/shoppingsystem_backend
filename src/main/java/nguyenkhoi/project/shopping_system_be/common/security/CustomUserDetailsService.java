/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.security;

import nguyenkhoi.project.shopping_system_be.common.mapper.UserMapper;
import nguyenkhoi.project.shopping_system_be.common.model.mybatis.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phone)
            throws UsernameNotFoundException {
        User user = userMapper.authenticateUser(
                User
                .builder()
                .phone(phone)
                .build());

        if (user != null) {
            return UserPrincipal.createUserPrincipal(user);
        }

        throw new UsernameNotFoundException("");
    }
}
