package com.erosnox.backend.infrastructure.config.security;

import com.erosnox.backend.application.models.dto.UserDto;
import com.erosnox.backend.infrastructure.persistence.entities.user.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    public static UserDto getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(authentication instanceof UserEntity user)) {
            throw new IllegalStateException("Usuário não autenticado ou token inválido");
        }

        return new UserDto(user.getId(), user.getRole());
    }
}
