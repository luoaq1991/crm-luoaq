package com.laq.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.laq.common.util.Result;
import com.laq.crm.dao.YgSaleChanceDao;
import com.laq.crm.model.YgSaleChance;
import com.laq.crm.service.IMarketingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketingServiceImpl implements IMarketingService {

    @Autowired
    private YgSaleChanceDao saleChanceDao;

    @Autowired(required = false)
    private HttpSession session;


    @Override
    public Map<String, Object> querySaleChancesByParams(YgSaleChance saleChance) {
        //多数据查询，需要分页
        PageHelper.startPage(saleChance.getPage(), saleChance.getRows());

        //查询
        Map<String, Object> params = new HashMap<>();

        //根据前端页面搜索项，判断非空
        if (StringUtil.isNotEmpty(saleChance.getCreateMan())) {
            params.put("creatMan", saleChance.getCreateMan());
        }

        if (StringUtil.isNotEmpty(saleChance.getCustomerName())) {
            params.put("customerName", saleChance.getCustomerName());
        }

        if (null != saleChance.getCreateDate()) {
            params.put("createDate", saleChance.getCreateDate());
        }

        if (null != saleChance.getState()) {
            params.put("state", saleChance.getState());
        }

        //逻辑删除数据无需显示，isValid = 1
        params.put("isValid", 1);

        List<YgSaleChance> list = saleChanceDao.find(params);

        //返回数据组装
        PageInfo<YgSaleChance> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;

    }

    @Override
    @Transactional
    public Result updateMarketingChance(YgSaleChance saleChance) {
        saleChance.setUpdateDate(new Date());
        long ste = saleChanceDao.updateSte(saleChance);
        if (ste == 1) {
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");
    }


    @Override
    @Transactional
    public Result insertMarketingChance(YgSaleChance saleChance) {
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());
        saleChance.setIsValid(1);
        saleChance.setState(1);
        saleChance.setDevResult(0);
        saleChance.setAssignTime(new Date());
        saleChance.setCreateMan((String) session.getAttribute("userInfo"));
        long ste = saleChanceDao.saveSte(saleChance);
        if (ste == 1) {
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    @Override
    public Result deleteMarketingChance(Integer[] ids) {
        //判断非空
        if (ids.length <= 0) {
            return Result.success("未选中记录");
        }
        int n = ids.length;
        Result result = new Result();

        for (int i = 0; i < n; i++) {
            YgSaleChance saleChance = new YgSaleChance();
            saleChance.setId(ids[i]);
            saleChance.setIsValid(0);
            saleChance.setUpdateDate(new Date(System.currentTimeMillis()));
            long ste = saleChanceDao.updateSte(saleChance);
            if (ste == 1) {
                result = Result.success("删除成功");
            } else {
                result = Result.fail("删除失败");
            }

        }

        return result;

    }

    @Override
    public YgSaleChance querySaleChanceBySid(Integer sid) {
        return saleChanceDao.get(sid);
    }


}
