package com.ruoyi;

import com.ruoyi.system.service.GccPeriodDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RuoYiApplicationTest
{
    @Autowired
    private GccPeriodDetailService gccPeriodDetailService;
    @Test
    public void test(){
        gccPeriodDetailService.getAreaData();
    }
}
