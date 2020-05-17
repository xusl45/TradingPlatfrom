package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.CommodityRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityBuyedDao {

    //插入订单信息
    void insertCommodityOrder(CommodityRecord commodityRecord);
    //根据id查询某个具体的订单
    CommodityRecord findCommodityOrderByID(int id);
    //查询购买者所有购买订单
    List<CommodityRecord> findCommodityOrderBidByID(int bid);
    //查询出售者所有出售订单
    List<CommodityRecord> findCommodityOrderUidByID(int uid);
    //点击发货之后处理 state变化，邮编变化
    void sendCommodityAfter(CommodityRecord commodityRecord);
    //点击收货之后处理 state变化
    void sendCommodityReceiving(int id);
    //查询所有发货订单
    List<CommodityRecord> findALLCommodityOrder();
}
