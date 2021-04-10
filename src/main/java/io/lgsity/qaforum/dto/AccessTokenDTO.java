package io.lgsity.qaforum.dto;

import lombok.Data;

/**
 * @Author shulinYuan
 * @Date 2021/4/8 14:48
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;

    private String state;

}
