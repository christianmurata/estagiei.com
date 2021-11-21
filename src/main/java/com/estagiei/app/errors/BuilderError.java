package com.estagiei.app.errors;

import java.util.Map;

public class BuilderError<T extends ExceptionError> {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private Map<String, String> fields;

    private T instance;

    private BuilderError(Class<T> ErrorClass) {
        try {
            instance = ErrorClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T extends ExceptionError> BuilderError<T> newBuild(Class<T> errorClass) {
        return new BuilderError<>(errorClass);
    }

    public BuilderError<T> title(String title) {
        this.title = title;
        return this;
    }

    public BuilderError<T> status(int status) {
        this.status = status;
        return this;
    }

    public BuilderError<T> detail(String detail) {
        this.detail = detail;
        return this;
    }

    public BuilderError<T> timestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BuilderError<T> fields(Map<String, String> fields) {
        this.fields = fields;
        return this;
    }

    public T build() {
        instance.title = this.title;
        instance.detail = this.detail;
        instance.timestamp = this.timestamp;
        instance.status = this.status;
        instance.fields = this.fields;

        return instance;
    }
}
