package com.laq.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laq.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YgCusDevPlan extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * sale_chance_id
     * 营销机会id
     */
    private Integer saleChanceId;

    /**
     * plan_item
     * 计划详情
     */
    private String planItem;

    /**
     * plan_date
     * 计划时间
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMDHMS, timezone = "GMT+8")
    private Date planDate;

    /**
     * exe_affect
     * 预期效果
     */
    private String exeAffect;

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

    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    public String getPlanItem() {
        return planItem;
    }

    public void setPlanItem(String planItem) {
        this.planItem = planItem;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getExeAffect() {
        return exeAffect;
    }

    public void setExeAffect(String exeAffect) {
        this.exeAffect = exeAffect;
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