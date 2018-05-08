package com.laq.crm.service;

import com.laq.crm.model.YgCustomerLoss;

import java.util.Map;

public interface ICustomerLossService {
    Map<String, Object> queryCustomerLossesByParams(YgCustomerLoss customerLoss);
}
