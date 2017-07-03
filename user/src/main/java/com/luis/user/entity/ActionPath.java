package com.luis.user.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

/**
 * Created by luis on 2017/7/3.
 * 事件表
 */
@Entity
@Table(name = "TB_ACTION_PATH")
public class ActionPath {
    /**
     * ID
     */
    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger actionId;
    /**
     * 事件备注
     */
    @Column(length = 255)
    private String actionComment;
    /**
     * 事件地址
     */
    @Column(length = 255, unique = true)
    private String actionName;

    public BigInteger getActionId() {
        return actionId;
    }

    public void setActionId(BigInteger actionId) {
        this.actionId = actionId;
    }

    public String getActionComment() {
        return actionComment;
    }

    public void setActionComment(String actionComment) {
        this.actionComment = actionComment;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
