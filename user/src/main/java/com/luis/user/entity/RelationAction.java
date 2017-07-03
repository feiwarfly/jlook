package com.luis.user.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/3.
 */
@Entity
@Table(name = "TB_RELATION_ACTION", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"RELATION_PERMISSION_ID", "RELATION_ROLE_ID"})
})
public class RelationAction {

    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger relationId;

    /**
     * 角色ID,用户ID,组织
     */
    @Column(precision = 30, scale = 0, name = "RELATION_PERMISSION_ID")
    private BigInteger relationPermissionId;
    /**
     * 权限ID
     */
    @Column(precision = 30, scale = 0, name = "RELATION_ACTION_ID")
    private BigInteger relationActionId;


    public BigInteger getRelationId() {
        return relationId;
    }

    public void setRelationId(BigInteger relationId) {
        this.relationId = relationId;
    }

    public BigInteger getRelationPermissionId() {
        return relationPermissionId;
    }

    public void setRelationPermissionId(BigInteger relationPermissionId) {
        this.relationPermissionId = relationPermissionId;
    }

    public BigInteger getRelationActionId() {
        return relationActionId;
    }

    public void setRelationActionId(BigInteger relationActionId) {
        this.relationActionId = relationActionId;
    }
}
