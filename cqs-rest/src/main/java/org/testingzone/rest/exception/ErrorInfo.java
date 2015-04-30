package org.testingzone.rest.exception;

@SuppressWarnings("UnusedDeclaration")
public final class ErrorInfo {

    private final static int DEFAULT_TRACE_DEPTH = 7;

    private final String error;
    private final String message;
    private final String details;

    public ErrorInfo(Exception e) {
        this(e, DEFAULT_TRACE_DEPTH);
    }

    public ErrorInfo(Exception e, int traceDepth) {
        this.error = e.getClass().getSimpleName();
        this.message = e.getMessage();
        this.details = printStackTrace(e, traceDepth);
    }

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

    private String printStackTrace(Exception e, int traceDepth) {
        StringBuilder stringBuilder = new StringBuilder();
        String clazz = e.getClass().getName();
        String msg = e.getMessage();
        String template = msg != null ? "%s : %s " : "%s ";
        stringBuilder.append(String.format(template, clazz, msg));

        StackTraceElement[] stackTrace = e.getStackTrace();
        if (stackTrace != null) {
            int depth = Math.min(stackTrace.length, traceDepth);
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
