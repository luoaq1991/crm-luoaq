package com.laq.crm.dao;

import com.laq.crm.model.YgReport;
import com.laq.framework.dao.BaseDao;

import java.util.List;

public interface YgReportDao extends BaseDao<Integer, YgReport> {

    List<YgReport> queryCustomersContribution(String name);
}
