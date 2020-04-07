package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.CommodityDao;
import com.ssm.tradingPlatfrom.entity.Commodity;
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
            commoditySort.setIsShow(null);
            commoditySort.setParentSort(null);
        }
        return commoditySorts;
    }

    @Override
    public List<Commodity> findALLCommodity() {
        List<Commodity> commoditys = commodityDao.findALLCommodity();
        return commoditys;
    }

    @Override
    public List<Commodity> findOneCommodity(String name) {
        List<Commodity> commoditys = commodityDao.findOneCommodity(name);
        return commoditys;
    }

    @Override
    public List<Commodity> findCommodityOfSort(int  id) {
        List<Commodity> commoditys = commodityDao.findCommodityOfSort(id);
        return commoditys;
    }
}
