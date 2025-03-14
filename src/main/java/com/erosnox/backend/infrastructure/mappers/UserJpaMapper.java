package com.erosnox.backend.infrastructure.mappers;

import com.erosnox.backend.domain.entities.user.User;
import com.erosnox.backend.infrastructure.persistence.entities.user.UserEntity;

public class UserJpaMapper {
    public static UserEntity toJpa(User user) {
        new UserEntity();
        return UserEntity
                .builder()
                .username(user.getUsername())
                .passwordHash(user.getPasswordHash())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build();
    }

    public static User toEntity(UserEntity userEntity) {
        var user = new User(
                userEntity.getUsername(),
                userEntity.getPasswordHash(),
                userEntity.getRole());
        user.setId(userEntity.getId());
        return user;
    }
}
