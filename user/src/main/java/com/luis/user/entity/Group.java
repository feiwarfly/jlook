package com.luis.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by luis on 2017/7/2.
 * 组织
 */
@Entity
@Table(name = "TB_GROUP")
public class Group {
    /**
     * 组织ID
     */
    @Id
    @Column(precision = 30, scale = 0)
    private BigInteger groupId;
    /**
     * 组织管理员ID
     */
    @Column(precision = 30, scale = 0)
    private BigInteger groupUserId;
    /**
     * 组织全称
     */
    @Column(length = 255)
    private String groupFullName;
    /**
     * 组织简称
     */
    @Column(length = 64)
    private String groupSimpleName;
    /**
     * 组织机构代码
     */
    @Column(length = 255)
    private String groupCode;
    /**
     * 组织机构代码证书图片
     */
    @Column(length = 2000)
    private String groupCodeImage;
    /**
     * 组织机构审核状态[0未审核，1已审核]
     */
    @Column(nullable = false)
    private Integer groupAuditStatus;
    /**
     * 组织机构审核人员
     */
    @Column(precision = 30, scale = 0)
    private BigInteger groupAuditUserId;
    /**
     * 组织机构审核时间
     */
    @Column
    private Timestamp groupAuditTime;

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
    }

    public BigInteger getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(BigInteger groupUserId) {
        this.groupUserId = groupUserId;
    }

    public String getGroupFullName() {
        return groupFullName;
    }

    public void setGroupFullName(String groupFullName) {
        this.groupFullName = groupFullName;
    }

    public String getGroupSimpleName() {
        return groupSimpleName;
    }

    public void setGroupSimpleName(String groupSimpleName) {
        this.groupSimpleName = groupSimpleName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupCodeImage() {
        return groupCodeImage;
    }

    public void setGroupCodeImage(String groupCodeImage) {
        this.groupCodeImage = groupCodeImage;
    }

    public Integer getGroupAuditStatus() {
        return groupAuditStatus;
    }

    public void setGroupAuditStatus(Integer groupAuditStatus) {
        this.groupAuditStatus = groupAuditStatus;
    }

    public BigInteger getGroupAuditUserId() {
        return groupAuditUserId;
    }

    public void setGroupAuditUserId(BigInteger groupAuditUserId) {
        this.groupAuditUserId = groupAuditUserId;
    }

    public Timestamp getGroupAuditTime() {
        return groupAuditTime;
    }

    public void setGroupAuditTime(Timestamp groupAuditTime) {
        this.groupAuditTime = groupAuditTime;
    }
}
