package com.ssm.tradingPlatfrom.service;

import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommoditySort;

import java.util.List;

public interface CommodityService {
    List<CommoditySort> findCommoditySort();

    List<Commodity> findALLCommodity();

    List<Commodity> findOneCommodity(String name);

    List<Commodity> findCommodityOfSort(int id);
}
