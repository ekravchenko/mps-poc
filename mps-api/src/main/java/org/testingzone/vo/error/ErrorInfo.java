package org.testingzone.vo.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ErrorInfo {

    public final static ErrorInfo EMPTY = new ErrorInfo(null, null);

    private String errorId;
    private String message;
}
