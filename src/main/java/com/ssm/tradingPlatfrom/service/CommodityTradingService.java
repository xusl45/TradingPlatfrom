package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.CommodityStorage;

import java.util.List;

public interface CommodityTradingService {
    Boolean insertCommoditySize(CommodityStorage commodityStorage);

    List<CommodityStorage> showALLCommoditySize(int uid);

    Boolean deleteCommoditySize(int id);
}
