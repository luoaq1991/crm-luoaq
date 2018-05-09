package com.laq.crm.service;

import java.util.Map;

public interface IReportService {
    Map<String, Object> queryCustomersContribution(String name, Integer pageNum, Integer rows);
}
