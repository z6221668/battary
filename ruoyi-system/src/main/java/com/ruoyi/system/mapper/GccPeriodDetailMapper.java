package com.ruoyi.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GccPeriodDetailMapper {

    List<Map<String,Object>> getTotalSaleFeeGroupByMonth();

    List<Map<String,Object>> getTotalSaleFeeGroupByStation();

    List<Map<String,Object>> getTotalSaleFeeGroupByStationAndMonth();

    /**
     * 地图数据
     */
    List<Map<String,Object>> getAreaData();

    /**
     * 年数据
     */
    List<Map<String,Object>> getYearData(@Param("year") String year);

    /**
     * 获取年龄分布图
     */
    List<Map<String,Object>> getAgeData();

    /**
     * 获取职业及男女分布
     */
    List<Map<String,Object>> getOccupationData();

}
