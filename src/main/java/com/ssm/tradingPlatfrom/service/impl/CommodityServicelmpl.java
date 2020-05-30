package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.CommodityDao;
import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommodityBanner;
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

    @Override
    public List<CommodityBanner> findCommodityBanner() {
        List<CommodityBanner> commodityBanners = commodityDao.findCommodityBanner();
        for (CommodityBanner commodityBanner:commodityBanners)
        {
            commodityBanner.setIsShow(null);
        }
        return commodityBanners;
    }

    @Override
    public Commodity findOneCommodityById(int id) {
        Commodity commodity = commodityDao.findCommodity(id);
        return commodity;
    }

    @Override
    public CommoditySort findCommoditySortById(int id) {
        CommoditySort commoditySort = commodityDao.findCommoditySortById(id);
        commoditySort.setIconPath(null);
        commoditySort.setParentSort(null);
        commoditySort.setIsShow(null);
        return commoditySort;
    }

    @Override
    public List<Commodity> findHotCommodity() {
        List<Commodity> commoditys = commodityDao.findHotCommodity();

        return commoditys;
    }

    @Override
    public Boolean stopCommodity(int id) {
        commodityDao.stopCommodity(id);
        return true;
    }

    @Override
    public Boolean openCommodity(int id) {
        commodityDao.openCommodity(id);
        return true;
    }
}
