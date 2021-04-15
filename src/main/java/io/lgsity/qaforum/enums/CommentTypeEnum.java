package io.lgsity.qaforum.enums;

import io.lgsity.qaforum.exception.CustomizeErrorCode;

/**
 * @Author shulinYuan
 * @Date 2021/4/15 10:13
 * @Version 1.0
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if(value.getType()==type)
                return true;
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
