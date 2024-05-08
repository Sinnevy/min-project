package com.sinnevy.minproject.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6776469858965912764L;

    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账号 唯一登录名
     */
    private String account;
    /**
     * 账户密码
     */
    private String password;
    /**
     * 联系方式
     */
    private String telNumber;

}
