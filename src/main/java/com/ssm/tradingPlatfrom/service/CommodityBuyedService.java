package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.CommodityRecord;

import java.util.List;

public interface CommodityBuyedService {
    Boolean insertCommodityOrder(CommodityRecord commodityRecord);

    List<CommodityRecord> findCommodityOrderBidByID(int bid);

    List<CommodityRecord> findCommodityOrderUidByID(int uid);

    Boolean sendCommodityAfter(String id);

    Boolean sendCommodityReceiving(String id);

    CommodityRecord findCommodityOrderByID(int id);

    List<CommodityRecord> findALLCommodityOrder();
}
