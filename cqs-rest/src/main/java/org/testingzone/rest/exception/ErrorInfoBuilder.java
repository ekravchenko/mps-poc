package org.testingzone.rest.exception;

import org.testingzone.vo.error.ErrorInfo;

public class ErrorInfoBuilder {

    private final static int DEFAULT_TRACE_DEPTH = 7;

    public static ErrorInfo build(Throwable e) {
        return build(e, DEFAULT_TRACE_DEPTH);
    }

    public static ErrorInfo build(Throwable e, int stackTraceDepth) {
        final String error = e.getClass().getSimpleName();
        final String message = e.getMessage();
        final String stackTrace = printStackTrace(e, stackTraceDepth);
        return new ErrorInfo(error, message, stackTrace);
    }

    private static String printStackTrace(Throwable e, int stackTraceDepth) {
        StringBuilder stringBuilder = new StringBuilder();
        String clazz = e.getClass().getName();
        String msg = e.getMessage();
        String template = msg != null ? "%s : %s " : "%s ";
        stringBuilder.append(String.format(template, clazz, msg));

        StackTraceElement[] stackTrace = e.getStackTrace();
        if (stackTrace != null) {
            int depth = Math.min(stackTrace.length, stackTraceDepth);
            for (int i = 0; i < depth; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String traceLine = String.format("at %s", stackTraceElement.toString());
                stringBuilder.append(traceLine);
                stringBuilder.append("\n ");
            }

            int more = stackTrace.length - depth;
            if (more > 0) {
                stringBuilder.append(String.format("<%d more>", more));
            }

        }
        return stringBuilder.toString();
    }
}
