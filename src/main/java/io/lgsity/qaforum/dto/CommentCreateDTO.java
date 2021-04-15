package io.lgsity.qaforum.dto;

import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/15 8:23
 * @Version 1.0
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
