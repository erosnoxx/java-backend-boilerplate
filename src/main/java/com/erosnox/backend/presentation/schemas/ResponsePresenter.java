package com.erosnox.backend.presentation.schemas;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter @Setter
public class ResponsePresenter<T> extends RepresentationModel<ResponsePresenter<T>> {
    private T data;

    public ResponsePresenter(T data) {
        this.data = data;
    }
}
