package io.lgsity.qaforum.dto;

import io.lgsity.qaforum.pojo.User;
import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/10 16:28
 * @Version 1.0
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
