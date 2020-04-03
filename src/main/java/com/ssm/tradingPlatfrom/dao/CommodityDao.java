package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.CommoditySort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {
    List<CommoditySort> findCommoditySort(); // 查找商品列别
}
