/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.security;

import nguyenkhoi.project.shopping_system_be.common.model.mybatis.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserPrincipal implements UserDetails {
    private String phone;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String phone,
                         String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.phone = phone;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal createUserPrincipal(User user) {
        return new UserPrincipal(
                user.getPhone(),
                user.getPassword(),
                Arrays.asList( new SimpleGrantedAuthority(user.getRole())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
