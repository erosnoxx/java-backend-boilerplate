package com.erosnox.backend.infrastructure.config.injection.user;

import com.erosnox.backend.application.contracts.repositories.UserRepository;
import com.erosnox.backend.application.contracts.services.LoginService;
import com.erosnox.backend.application.contracts.usecases.user.auth.LoginUsecase;
import com.erosnox.backend.application.contracts.usecases.user.auth.RegisterUsecase;
import com.erosnox.backend.application.usecases.user.auth.LoginUsecaseImpl;
import com.erosnox.backend.application.usecases.user.auth.RegisterUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserInjectionConfig {
    @Bean
    public LoginUsecase loginUsecase(LoginService loginService) {
        return new LoginUsecaseImpl(loginService);
    }

    @Bean
    public RegisterUsecase registerUsecase(UserRepository repository) {
        return new RegisterUsecaseImpl(repository);
    }
}
