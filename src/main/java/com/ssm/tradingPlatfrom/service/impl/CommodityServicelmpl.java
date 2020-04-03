package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.CommodityDao;
import com.ssm.tradingPlatfrom.entity.CommoditySort;
import com.ssm.tradingPlatfrom.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service(value = "commodityService")
public class CommodityServicelmpl implements CommodityService {

    @Resource
    private CommodityDao commodityDao;
    @Override
    public List<CommoditySort> findCommoditySort() {
        List<CommoditySort> commoditySorts = commodityDao.findCommoditySort();
        for (CommoditySort commoditySort :commoditySorts)
        {
            System.out.println(commoditySort.toString());
        }
        return commoditySorts;
    }
}
