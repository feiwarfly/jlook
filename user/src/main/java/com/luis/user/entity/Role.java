package com.luis.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/2.
 * 角色表
 */
@Entity
@Table(name = "TB_ROLE")
public class Role {

    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger roleId;

    /**
     * 角色名称
     */
    @Column(length = 64)
    private String roleName;
    /**
     * 角色类型[1用户角色，2组织角色]
     */
    @Column
    private Integer roleType;

    public BigInteger getRoleId() {
        return roleId;
    }

    public void setRoleId(BigInteger roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}
