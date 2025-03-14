package com.erosnox.backend.application.contracts.usecases.user.admin;

import com.erosnox.backend.application.models.response.user.UserResponse;
import java.util.List;

public interface FindAllUsersUsecase {
    List<UserResponse> execute();
}
