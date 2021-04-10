package io.lgsity.qaforum.pojo;

import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/9 21:01
 * @Version 1.0
 */
@Data
public class Question {

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

}
