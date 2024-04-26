package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.mapper.GccPeriodDetailMapper;
import com.ruoyi.system.service.GccPeriodDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GccPeriodDetailServiceImpl implements GccPeriodDetailService {

    @Value("classpath:area.txt")
    private Resource resource;

    @Autowired
    private GccPeriodDetailMapper gccPeriodDetailMapper;

    @Override
    public List<Map<String, Object>> getTotalSaleFeeGroupByMonth(Map<String, Object> map) {
        return gccPeriodDetailMapper.getTotalSaleFeeGroupByMonth();
    }

    @Override
    public List<Map<String, Object>> getTotalSaleFeeGroupByStation(Map<String, Object> map) {
        return gccPeriodDetailMapper.getTotalSaleFeeGroupByStation();
    }

    @Override
    public List<Map<String, Object>> getTotalSaleFeeGroupByStationAndMonth(Map<String, Object> map) {
        return gccPeriodDetailMapper.getTotalSaleFeeGroupByStationAndMonth();
    }

    @Override
    public Map<String, Object> getAreaData() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = gccPeriodDetailMapper.getAreaData();
        map.put("listData", list);
        map.put("areaData", getFile(list));
        return map;
    }

    @Override
    public List<Map<String, Object>> getYearData(String year) {
        return gccPeriodDetailMapper.getYearData(year);
    }

    @Override
    public List<Map<String, Object>> getAgeData() {
        return gccPeriodDetailMapper.getAgeData();
    }

    @Override
    public Map<String, Object> getOccupationData() {
        Map<String, Object> res = new HashMap<>();
        List<Map<String, Object>> data = gccPeriodDetailMapper.getOccupationData();
        Set<String> strings = new HashSet<>();
        Set<String> occupationData = new HashSet<>();
        for (Map<String, Object> datum : data) {
            strings.add(datum.get("sex").toString());
            occupationData.add(datum.get("occupation").toString());
        }
        res.put("sexData", strings);
        res.put("occupationData", occupationData);
        res.put("data", data);
        return res;
    }

    public Map<String, Object> getFile(List<Map<String, Object>> list) {
        try {
            String file = new String(Files.readAllBytes(resource.getFile().toPath()));
            JSONArray jsonArray = JSON.parseArray(file);
            Map<String, Object> map = new LinkedHashMap<>();
            for (Map<String, Object> stringObjectMap : list) {
                String name = stringObjectMap.get("name").toString();
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    String name1 = jsonObject.getString("n");
                    if (!"区".equals(String.valueOf(name1.indexOf(name1.length() - 1))) || !"州".equals(String.valueOf(name1.indexOf(name1.length() - 1)))) {
                        name1 = name1 + "市";
                    }
                    if (name.equals(name1)) {
                        String[] value = jsonObject.getString("g").split(",");
                        map.put(name, value);
                        break;
                    }
                }
            }
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Map<String, Object>> getPrediction() {
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String lastYear = String.valueOf(Integer.parseInt(year) - 1);
        //获取当年记录
        List<Map<String, Object>> nowYearData = gccPeriodDetailMapper.getYearData(year);
        //获取去年记录
        List<Map<String, Object>> lastYearData = gccPeriodDetailMapper.getYearData(lastYear);
        //提取月份
        List<String> years = nowYearData.stream().map(
                map -> map.get("name").toString()
        ).collect(Collectors.toList());
        //获取今年记录总额及数量
        Integer nowTotal = nowYearData.stream().mapToInt(i -> Integer.valueOf(i.get("value").toString())).reduce(0, Integer::sum);
        Integer lastTotal = 0;
        Integer cz = 0;
        int times = nowYearData.size();
        if (times != 0) {
            for (int i = 0; i < times; i++) {
                Map<String, Object> map = lastYearData.get(i);
                lastTotal += Integer.valueOf(map.get("value").toString());
            }
            cz = (lastTotal - nowTotal) / times;
        }

        //查询去年数据和今年数据，今年没有的就添加
        for (Map<String, Object> lastYearDatum : lastYearData) {
            if (!years.contains(lastYearDatum.get("name").toString())) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", lastYearDatum.get("name").toString());
                map.put("value", Integer.valueOf(lastYearDatum.get("value").toString()) + cz);
                map.put("preFlag", 1);
                nowYearData.add(map);
            }
        }
        return nowYearData;
    }
}
