/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.mapper;

import nguyenkhoi.project.shopping_system_be.common.model.mybatis.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User authenticateUser(User user);
    int insertUser(User user);
    User selectUserProfile(User user);
    int updateProfile(User user);
}
