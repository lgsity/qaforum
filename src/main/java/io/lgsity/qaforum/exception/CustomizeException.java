package io.lgsity.qaforum.exception;

/**
 * @Author shulinYuan
 * @Date 2021/4/14 17:46
 * @Version 1.0
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
