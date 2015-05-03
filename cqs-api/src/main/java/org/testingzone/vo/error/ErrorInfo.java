package org.testingzone.vo.error;

import com.google.common.base.MoreObjects;

public final class ErrorInfo {

    public final static ErrorInfo EMPTY = new ErrorInfo(null, null, null);

    private final String error;
    private final String message;
    private final String details;

    public ErrorInfo(String error, String message, String details) {
        this.error = error;
        this.message = message;
        this.details = details;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("error", error)
                .add("message", message)
                .add("details", details)
                .toString();
    }
}
