package com.laq.crm.model;

import java.util.Date;

public class YgCustomer extends BaseModel {
    /**
     * id
     * id
     */
    private Integer id;

    /**
     * khno
     * 客户编号
     */
    private String khno;

    /**
     * name
     * 客户名称
     */
    private String name;

    /**
     * area
     * 客户地区
     */
    private String area;

    /**
     * cus_manager
     * 客户经理
     */
    private String cusManager;

    /**
     * level
     * 客户等级
     */
    private String level;

    /**
     * myd
     * 客户满意度
     */
    private String myd;

    /**
     * xyd
     * 客户信用度
     */
    private String xyd;

    /**
     * address
     * 客户地址
     */
    private String address;

    /**
     * post_code
     * 邮政编码
     */
    private String postCode;

    /**
     * phone
     * 联系电话
     */
    private String phone;

    /**
     * fax
     * 传真
     */
    private String fax;

    /**
     * web_site
     * 网址
     */
    private String webSite;

    /**
     * yyzzzch
     * 营业执照注册号
     */
    private String yyzzzch;

    /**
     * fr
     * 法人
     */
    private String fr;

    /**
     * zczj
     * 注册资金(万元)
     */
    private String zczj;

    /**
     * nyye
     * 年营业额(万元)
     */
    private String nyye;

    /**
     * khyh
     * 开户银行
     */
    private String khyh;

    /**
     * khzh
     * 开户帐号
     */
    private String khzh;

    /**
     * dsdjh
     * 地税登记号
     */
    private String dsdjh;

    /**
     * gsdjh
     * 国税登记号
     */
    private String gsdjh;

    /**
     * state
     * 状态
     */
    private Integer state;

    /**
     * is_valid
     * 是否删除
     */
    private Integer isValid;

    /**
     * create_date
     * 创建时间
     */
    private Date createDate;

    /**
     * update_date
     * 更新时间
     */
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCusManager() {
        return cusManager;
    }

    public void setCusManager(String cusManager) {
        this.cusManager = cusManager;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMyd() {
        return myd;
    }

    public void setMyd(String myd) {
        this.myd = myd;
    }

    public String getXyd() {
        return xyd;
    }

    public void setXyd(String xyd) {
        this.xyd = xyd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getYyzzzch() {
        return yyzzzch;
    }

    public void setYyzzzch(String yyzzzch) {
        this.yyzzzch = yyzzzch;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj;
    }

    public String getNyye() {
        return nyye;
    }

    public void setNyye(String nyye) {
        this.nyye = nyye;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getKhzh() {
        return khzh;
    }

    public void setKhzh(String khzh) {
        this.khzh = khzh;
    }

    public String getDsdjh() {
        return dsdjh;
    }

    public void setDsdjh(String dsdjh) {
        this.dsdjh = dsdjh;
    }

    public String getGsdjh() {
        return gsdjh;
    }

    public void setGsdjh(String gsdjh) {
        this.gsdjh = gsdjh;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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