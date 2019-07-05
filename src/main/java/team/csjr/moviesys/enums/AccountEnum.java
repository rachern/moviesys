package team.csjr.moviesys.enums;

import lombok.Getter;

/**
 * @author ReMidDream
 * @date 2018/10/23 20:55
 **/
@Getter
public enum AccountEnum  {

    Error("500","系统异常"),
    USERNAME_EXIST("501","帐号名已经存在!"),
    EMAIL_EXIST("502","邮箱已经存在!"),
    UN_LOGIN("503","未登录!"),
    EXIST_TICKET("505","该座位已被购买!");

    private String code;

    private String message;

    AccountEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
