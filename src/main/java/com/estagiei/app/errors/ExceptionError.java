package com.estagiei.app.errors;

public abstract class ExceptionError {
    protected String title;
    protected int status;
    protected String detail;
    protected long timestamp;

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
}
