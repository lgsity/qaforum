package io.lgsity.qaforum.exception;

/**
 * @Author shulinYuan
 * @Date 2021/4/14 20:04
 * @Version 1.0
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你要找的问题不存在，要不换个问题试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
