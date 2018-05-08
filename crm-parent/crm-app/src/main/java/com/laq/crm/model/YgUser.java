package com.laq.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laq.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YgUser extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * user_name
     */
    private String userName;

    /**
     * user_pwd
     */
    private String userPwd;

    /**
     * true_name
     */
    private String trueName;

    /**
     * email
     */
    private String email;

    /**
     * phone
     */
    private String phone;

    /**
     * is_valid
     * 是否删除
     */
    private Integer isValid;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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