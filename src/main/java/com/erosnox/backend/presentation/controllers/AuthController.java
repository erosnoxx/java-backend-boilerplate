package com.erosnox.backend.presentation.controllers;

import com.erosnox.backend.application.contracts.usecases.user.auth.LoginUsecase;
import com.erosnox.backend.application.contracts.usecases.user.auth.RegisterUsecase;
import com.erosnox.backend.application.enums.Roles;
import com.erosnox.backend.application.models.request.user.LoginRequest;
import com.erosnox.backend.application.models.request.user.RegisterRequest;
import com.erosnox.backend.application.models.response.user.LoginResponse;
import com.erosnox.backend.application.models.response.user.RegisterResponse;
import com.erosnox.backend.infrastructure.config.security.SecurityUtils;
import com.erosnox.backend.presentation.schemas.ResponsePresenter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/auth")
public class AuthController {
    @Autowired
    private LoginUsecase loginUsecase;
    @Autowired
    private RegisterUsecase registerUsecase;

    @PostMapping("/login")
    public ResponseEntity<ResponsePresenter<LoginResponse>> login(
            @RequestBody @Valid LoginRequest request) {
        var response = loginUsecase.execute(request);
        var presenter = new ResponsePresenter<>(response);

        presenter.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(getClass())
                        .register(null)).withRel("register"));

        return ResponseEntity.ok(presenter);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponsePresenter<RegisterResponse>> register(
            @RequestBody @Valid RegisterRequest request) {
        var response = registerUsecase.execute(request, Roles.USER);
        var presenter = new ResponsePresenter<>(response);

        presenter.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(getClass())
                        .login(null)).withRel("login"));

        return ResponseEntity.ok(presenter);
    }
}
