package io.lgsity.qaforum.pojo;

import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/9 12:01
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
