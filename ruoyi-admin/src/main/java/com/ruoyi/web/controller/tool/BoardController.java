package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.service.GccPeriodDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private GccPeriodDetailService gccPeriodDetailService;

    @GetMapping("/board1")
    public R board1() {
        List<Map<String, Object>> list = gccPeriodDetailService.getTotalSaleFeeGroupByMonth(new HashMap<>());
        return R.ok(list);
    }

    @GetMapping("/board2")
    public R board2() {
        List<Map<String, Object>> list = gccPeriodDetailService.getTotalSaleFeeGroupByStation(new HashMap<>());
        return R.ok(list);
    }

    @GetMapping("/board3")
    public R board3() {
        List<Map<String, Object>> list = gccPeriodDetailService.getTotalSaleFeeGroupByStationAndMonth(new HashMap<>());
        return R.ok(list);
    }

    @GetMapping("/areaData")
    public R areaData() {
        return R.ok(gccPeriodDetailService.getAreaData());
    }

    @GetMapping("/yearData")
    public R yearData(String year) {
        List<Map<String, Object>> list = gccPeriodDetailService.getYearData(year);
        return R.ok(list);
    }

    @GetMapping("/ageData")
    public R ageData() {
        List<Map<String, Object>> list = gccPeriodDetailService.getAgeData();
        return R.ok(list);
    }

    @GetMapping("/occupation")
    public R occupationData() {
        return R.ok(gccPeriodDetailService.getOccupationData());
    }

    @GetMapping("/prediction")
    public R prediction() {
        return R.ok(gccPeriodDetailService.getPrediction());
    }
}
