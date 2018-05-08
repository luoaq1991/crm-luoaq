package com.laq.crm.model;

import java.util.Date;

public class YgUserRole extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * user_id
     */
    private Integer userId;

    /**
     * role_id
     */
    private Integer roleId;

    /**
     * create_date
     */
    private Date createDate;

    /**
     * update_date
     */
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}