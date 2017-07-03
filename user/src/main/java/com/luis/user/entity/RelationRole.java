package com.luis.user.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/2.
 * 用户或抽象组织和角色的关系
 * */
@Entity
@Table(name = "TB_RELATION_ROLE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"RELATION_FROM_ID", "RELATION_ROLE_ID"})
})
public class RelationRole {

    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger relationId;
    /**
     * 用户或组织与角色的关系
     */
    @Column(precision = 30, scale = 0, name = "RELATION_FROM_ID")
    private BigInteger relationFromId;
    /**
     * 角色ID
     */
    @Column(precision = 30, scale = 0, name = "RELATION_ROLE_ID")
    private BigInteger relationRoleId;


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

    public BigInteger getRelationRoleId() {
        return relationRoleId;
    }

    public void setRelationRoleId(BigInteger relationRoleId) {
        this.relationRoleId = relationRoleId;
    }
}
