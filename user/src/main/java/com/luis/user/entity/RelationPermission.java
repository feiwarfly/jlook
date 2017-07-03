package com.luis.user.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/2.
 * 角色权限关联表，用户权限关联表，组织权限管理表
 */
@Entity
@Table(name = "TB_RELATION_PERMISSION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"RELATION_FROM_ID", "RELATION_PERMISSION_ID"})
})
public class RelationPermission {

    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger relationId;
    /**
     * 角色ID,用户ID,组织
     */
    @Column(precision = 30, scale = 0, name = "RELATION_FROM_ID")
    private BigInteger relationFromId;
    /**
     * 权限ID
     */
    @Column(precision = 30, scale = 0, name = "RELATION_PERMISSION_ID")
    private BigInteger relationPermissionId;


    public BigInteger getRelationId() {
        return relationId;
    }

    public void setRelationId(BigInteger relationId) {
        this.relationId = relationId;
    }

    public BigInteger getRelationFromId() {
        return relationFromId;
    }

    public void setRelationFromId(BigInteger relationFromId) {
        this.relationFromId = relationFromId;
    }

    public BigInteger getRelationPermissionId() {
        return relationPermissionId;
    }

    public void setRelationPermissionId(BigInteger relationPermissionId) {
        this.relationPermissionId = relationPermissionId;
    }
}
