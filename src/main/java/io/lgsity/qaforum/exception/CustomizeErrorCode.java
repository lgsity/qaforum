package io.lgsity.qaforum.exception;

/**
 * @Author shulinYuan
 * @Date 2021/4/14 20:04
 * @Version 1.0
 */
public enum  CustomizeErrorCode implements ICustomizeErrorCode {
    NO_LOGIN(1000,"登录后才能评论,请先登录！"),
    QUESTION_NOT_FOUND(1001,"你要找的问题不存在，要不换个问题试试？"),
    TARGET_PARAM_NOT_FOUND(1002,"未选中任何问题或评论进行回复"),
    SYS_ERROR(1003,"服务器冒烟了，请稍后再来试试吧！"),
    TYPE_PARAM_WRONG(1004,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(1005,"回复的评论不存在了！");

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
