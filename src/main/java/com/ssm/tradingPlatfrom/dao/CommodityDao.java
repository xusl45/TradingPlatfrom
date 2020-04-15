package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommodityBanner;
import com.ssm.tradingPlatfrom.entity.CommoditySort;
import com.ssm.tradingPlatfrom.entity.CommodityStorage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityDao {
    List<CommoditySort> findCommoditySort(); // 查找商品列别

    List<Commodity> findALLCommodity();//查找所有商品信息

    List<Commodity> findOneCommodity(String name);//模糊查询商品信息

    List<Commodity> findCommodityOfSort(int id);//查找某个系列商品的id

    List<CommodityBanner> findCommodityBanner(); //查找商品广告banner

    Commodity findCommodity(int id);//根据id查询某个单独的商品

    void updateCommodityPrice(CommodityStorage commodityStorage);//更新最低售价
}
