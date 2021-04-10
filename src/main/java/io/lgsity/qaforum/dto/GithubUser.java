package io.lgsity.qaforum.dto;

import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/8 15:29
 * @Version 1.0
 */
@Data
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}
