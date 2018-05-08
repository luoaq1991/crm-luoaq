package com.laq.crm.model;

import java.util.Date;

public class YgDataDic extends BaseModel {
    /**
     * id
     */
    private Integer id;

    /**
     * data_dic_name
     */
    private String dataDicName;

    /**
     * data_dic_value
     */
    private String dataDicValue;

    /**
     * is_valid
     */
    private Byte isValid;

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

    public String getDataDicName() {
        return dataDicName;
    }

    public void setDataDicName(String dataDicName) {
        this.dataDicName = dataDicName;
    }

    public String getDataDicValue() {
        return dataDicValue;
    }

    public void setDataDicValue(String dataDicValue) {
        this.dataDicValue = dataDicValue;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
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