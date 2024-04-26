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
                        continue;
                    }
                }
            }
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),i);
        }
        System.out.printf(map.toString());
    }
}
