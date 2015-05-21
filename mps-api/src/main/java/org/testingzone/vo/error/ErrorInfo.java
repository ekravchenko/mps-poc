package org.testingzone.vo.error;

import lombok.Value;

@Value
public final class ErrorInfo {

    public final static ErrorInfo EMPTY = new ErrorInfo(null, null);

    private final String errorId;
    private final String message;
}
