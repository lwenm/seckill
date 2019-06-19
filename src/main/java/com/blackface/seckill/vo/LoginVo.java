package com.blackface.seckill.vo;

import com.blackface.seckill.validator.IsMobile;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/13
 * Time:23:00
 **/

public class LoginVo {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min=32)
    private String password;

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginVo [mobile=" + mobile + ", password=" + password + "]";
    }
}
