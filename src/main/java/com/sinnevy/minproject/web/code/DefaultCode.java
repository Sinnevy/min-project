package com.sinnevy.minproject.web.code;

public interface DefaultCode {

    /**
     * 请求成功返回
     */
    String SUCCESS = "00000000";

    /**
     * 系统错误 兜底错误码
     */
    String SYS_ERROR = "99999999";

    /**
     * 参数校验失败
     */
    String INVALID_PARAM = "00000001";

    /**
     * 用户登录 认证失败错误码
     */
    String AUTHC_ERROR = "00000002";

    /**
     * 接口鉴权错误码
     */
    String ACCESS_DENIED = "00000003";

}
