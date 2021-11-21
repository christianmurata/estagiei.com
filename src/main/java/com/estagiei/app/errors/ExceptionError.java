package com.estagiei.app.errors;

import java.util.Map;

public abstract class ExceptionError {
    protected String title;
    protected int status;
    protected String detail;
    protected long timestamp;
    protected Map<String, String> fields;

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getFields() {
        return fields;
    }
}
