package com.ssm.tradingPlatfrom.service.impl;


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

    @Override
    public Boolean insertCommoditySize(CommodityStorage commodityStorage) {

        commodityStorage.setOrderNumber(OrderCodeFactory.getOrderCode((long)commodityStorage.getUid()));
        System.out.println(commodityStorage.getOrderNumber());
        commodityTradingDao.insertCommoditySize(commodityStorage);
        return true;
    }

    @Override
    public List<CommodityStorage> showALLCommoditySize(int uid) {
        List<CommodityStorage> commodityStorages = commodityTradingDao.showALLCommoditySize(uid);
        return commodityStorages;
    }
}
