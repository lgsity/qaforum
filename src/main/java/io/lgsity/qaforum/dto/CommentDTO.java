package io.lgsity.qaforum.dto;

import io.lgsity.qaforum.pojo.User;
import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/15 21:43
 * @Version 1.0
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private String content;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer likeCount;

    private Integer commentCount;

    private User user;
}
