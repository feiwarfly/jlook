package com.luis.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/2.
 * 权限表
 */
@Entity
@Table(name = "TB_PERMISSION")
public class Permission {

    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger permissionId;
    /**
     * 权限名称
     */
    @Column(length = 255)
    private String permissionName;
    /**
     * 权限标识
     */
    @Column(length = 255, unique = true, nullable = false)
    private String permissionCode;
    /**
     * 权限备注
     */
    @Column(length = 2000)
    private String permissionComment;

    public BigInteger getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(BigInteger permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionComment() {
        return permissionComment;
    }

    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment;
    }
}
