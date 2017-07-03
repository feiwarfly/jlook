package com.luis.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by luis on 2017/7/2.
 * 用户
 */
@Entity
@Table(name = "TB_USER")
public class User {
    /**
     * ID
     */
    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger userId;
    /**
     * 用户名
     */
    @Column(length = 64, unique = true, nullable = false)
    private String userName;
    /**
     * 密码
     */
    @Column(length = 255, nullable = false)
    private String userPassword;
    /**
     * 姓名
     */
    @Column(length = 64)
    private String userRealName;
    /**
     * 用户手机号码
     */
    @Column(length = 64, unique = true)
    private String userCall;
    /**
     * 手机是否验证[0未验证，1已验证]
     */
    @Column(nullable = false)
    private Integer userCallReal;
    /**
     * 用户类型[0普通用户，1组织管理员，2后台管理用户]
     */
    @Column(nullable = false)
    private Integer userType;
    /**
     * 用户邮箱
     */
    @Column(length = 255)
    private String userEmail;
    /**
     * 用户邮箱是否验证[0未验证，1已验证]
     */
    @Column(nullable = false)
    private Integer userEmailReal;
    /**
     * QQ登录标记
     */
    @Column(length = 255)
    private String userQqKey;
    /**
     * sina登录
     */
    @Column(length = 255)
    private String userSinaKey;
    /**
     * 微信登录key
     */
    @Column(length = 255)
    private String userWeixinKey;
    /**
     * 创建时间
     */
    @Column(nullable = false)
    private Timestamp userCreateTime;
    /**
     * 用户头像
     */
    @Column(length = 2000)
    private String userHeaderImage;


    public String getUserHeaderImage() {
        return userHeaderImage;
    }

    public void setUserHeaderImage(String userHeaderImage) {
        this.userHeaderImage = userHeaderImage;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserCall() {
        return userCall;
    }

    public void setUserCall(String userCall) {
        this.userCall = userCall;
    }

    public Integer getUserCallReal() {
        return userCallReal;
    }

    public void setUserCallReal(Integer userCallReal) {
        this.userCallReal = userCallReal;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserEmailReal() {
        return userEmailReal;
    }

    public void setUserEmailReal(Integer userEmailReal) {
        this.userEmailReal = userEmailReal;
    }

    public String getUserQqKey() {
        return userQqKey;
    }

    public void setUserQqKey(String userQqKey) {
        this.userQqKey = userQqKey;
    }

    public String getUserSinaKey() {
        return userSinaKey;
    }

    public void setUserSinaKey(String userSinaKey) {
        this.userSinaKey = userSinaKey;
    }

    public String getUserWeixinKey() {
        return userWeixinKey;
    }

    public void setUserWeixinKey(String userWeixinKey) {
        this.userWeixinKey = userWeixinKey;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }
}
