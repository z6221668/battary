package com.ruoyi.system.service;


import java.util.List;
import java.util.Map;

public interface GccPeriodDetailService {

    List<Map<String, Object>> getTotalSaleFeeGroupByMonth(Map<String,Object> map);

    List<Map<String, Object>> getTotalSaleFeeGroupByStation(Map<String,Object> map);

    List<Map<String, Object>> getTotalSaleFeeGroupByStationAndMonth(Map<String,Object> map);

    Map<String,Object> getAreaData();

    List<Map<String,Object>> getYearData(String year);

    List<Map<String,Object>> getAgeData();

    Map<String,Object> getOccupationData();

    List<Map<String,Object>> getPrediction();


}
