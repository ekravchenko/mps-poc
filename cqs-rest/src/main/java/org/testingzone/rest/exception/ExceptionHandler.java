package org.testingzone.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testingzone.vo.error.ErrorInfo;

import java.util.Random;

public class ExceptionHandler {

    private static final int CODE_MAX_VALUE = 10000;
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

    public static ErrorInfo handle(Throwable e) {
        String code = generateNewCode();
        String message = e.getMessage();

        logError(code, e);

        return new ErrorInfo(code, message);
    }

    private static void logError(String code, Throwable e) {
        String message = String.format("Exception with ErrorId=%s", code);
        LOG.error(message, e);
    }

    private static String generateNewCode() {
        int code = new Random().nextInt(CODE_MAX_VALUE);
        return String.valueOf(code);
    }
}
