package com.laq.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laq.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YgRole extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * role_name
     */
    private String roleName;

    /**
     * role_remark
     * 备注
     */
    private String roleRemark;

    /**
     * create_date
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS, timezone = "GMT+8")
    private Date createDate;

    /**
     * update_date
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS, timezone = "GMT+8")
    private Date updateDate;

    /**
     * is_valid
     */
    private Integer isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
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

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}