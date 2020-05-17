package com.ssm.tradingPlatfrom.service.impl;


import com.ssm.tradingPlatfrom.dao.CommodityDao;
import com.ssm.tradingPlatfrom.dao.CommodityTradingDao;
import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommodityStorage;
import com.ssm.tradingPlatfrom.service.CommodityTradingService;
import com.ssm.tradingPlatfrom.utils.OrderCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "commodityTradingService")
public class CommodityTradingServicelmpl implements CommodityTradingService {

    @Autowired
    private CommodityTradingDao commodityTradingDao;
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public Boolean insertCommoditySize(CommodityStorage commodityStorage) {

        commodityStorage.setOrderNumber(OrderCodeFactory.getOrderCode((long)commodityStorage.getUid()));
        System.out.println(commodityStorage.getOrderNumber());
        commodityTradingDao.insertCommoditySize(commodityStorage);
        Commodity commodity = commodityDao.findCommodity(commodityStorage.getCommodityID());
        System.out.println(commodity.toString()+"xushulong");
        if ((commodity.getMinPrice()>=commodityStorage.getPrice())||(commodity.getMinPrice()==0))
        {
            commodityDao.updateCommodityPrice(commodityStorage);
        }
        return true;
    }

    @Override
    public List<CommodityStorage> showALLCommoditySize(int uid) {
        List<CommodityStorage> commodityStorages = commodityTradingDao.showALLCommoditySize(uid);
        return commodityStorages;
    }

    @Override
    public Boolean deleteCommoditySize(int id) {
        CommodityStorage commodityStorage = commodityTradingDao.findCommmoditySize(id);
        commodityTradingDao.deleteCommoditySize(id);
        CommodityStorage commodityStorages=commodityTradingDao.findMinpriceCommodityStore(commodityStorage.getCommodityID());
        if (commodityStorages != null) {
            System.out.println(commodityStorages.toString());
            commodityDao.updateCommodityPrice(commodityStorages);
        } else{
            CommodityStorage commodityStorage1 = new CommodityStorage();
            commodityStorage1.setCommodityID(commodityStorage.getCommodityID());
            commodityStorage.setPrice(0);
            commodityDao.updateCommodityPrice(commodityStorage1);
        }
        return true;
    }

    @Override
    public List<CommodityStorage> showALLCommoditySizeById(int commodityId) {
        List<CommodityStorage> commodityStorages = commodityTradingDao.showALLCommoditySizeById(commodityId);
        return commodityStorages;
    }

    @Override
    public List<CommodityStorage> findALLCommoditySize() {
        List<CommodityStorage> commodityStorages = commodityTradingDao.findALLCommoditySize();
        return commodityStorages;
    }
}
