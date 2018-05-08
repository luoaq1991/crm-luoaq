package com.laq.crm.service;

import com.laq.common.util.Result;
import com.laq.crm.model.YgSaleChance;

import java.util.Map;

public interface IMarketingService {
    Map<String, Object> querySaleChancesByParams(YgSaleChance saleChance);

    Result updateMarketingChance(YgSaleChance saleChance);

    Result insertMarketingChance(YgSaleChance saleChance);

    Result deleteMarketingChance(Integer[] ids);

    YgSaleChance querySaleChanceBySid(Integer sid);
}
