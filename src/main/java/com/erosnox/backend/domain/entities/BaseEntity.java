package com.erosnox.backend.domain.entities;

public abstract class BaseEntity<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
