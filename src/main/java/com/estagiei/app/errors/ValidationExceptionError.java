package com.estagiei.app.errors;

import java.util.Map;

public class ValidationExceptionError extends ExceptionError {
    private Map<String, String> fields;

    public Map<String, String> getFields() {
        return fields;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private Map<String, String> fields;

        private Builder() {}

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder fields(Map<String, String> fields) {
            this.fields = fields;
            return this;
        }

        public ValidationExceptionError build() {
            ValidationExceptionError validationExceptionError = new ValidationExceptionError();
            validationExceptionError.detail = this.detail;
            validationExceptionError.timestamp = this.timestamp;
            validationExceptionError.title = this.title;
            validationExceptionError.status = this.status;
            validationExceptionError.fields = this.fields;
            return validationExceptionError;
        }
    }
}
