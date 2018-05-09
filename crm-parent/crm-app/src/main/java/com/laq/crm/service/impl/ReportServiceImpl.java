package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laq.crm.dao.YgReportDao;
import com.laq.crm.model.YgReport;
import com.laq.crm.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private YgReportDao reportDao;

    /*
    通过名称查询客户名称和贡献金额
    1.
     */
    @Override
    public Map<String, Object> queryCustomersContribution(String name, Integer pageNum, Integer rows) {
        PageHelper.startPage(pageNum, rows);
        List<YgReport> list = reportDao.queryCustomersContribution(name);
        PageInfo<YgReport> info = new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;


    }
}
