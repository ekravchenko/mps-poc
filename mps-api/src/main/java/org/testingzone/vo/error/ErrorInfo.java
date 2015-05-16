package org.testingzone.vo.error;

import com.google.common.base.MoreObjects;

public final class ErrorInfo {

    public final static ErrorInfo EMPTY = new ErrorInfo(null, null);

    private final String errorId;
    private final String message;

    public ErrorInfo(String errorId, String message) {
        this.errorId = errorId;
        this.message = message;
    }

    public String getErrorId() {
        return errorId;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errorId", errorId)
                .add("message", message)
                .toString();
    }
}
