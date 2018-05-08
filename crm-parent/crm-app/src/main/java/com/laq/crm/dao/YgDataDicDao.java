package com.laq.crm.dao;

import com.laq.crm.model.YgDataDic;
import com.laq.framework.dao.BaseDao;

import java.util.List;

public interface YgDataDicDao extends BaseDao<Integer, YgDataDic> {

    List<YgDataDic> queryDataDicValueByDataDicName(String dicName);

}