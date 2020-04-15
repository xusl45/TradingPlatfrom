package com.ssm.tradingPlatfrom.dao;

import com.ssm.tradingPlatfrom.entity.CommodityStorage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityTradingDao {

    void insertCommoditySize(CommodityStorage commodityStorage);//插入单条预售信息

    List<CommodityStorage> showALLCommoditySize(int uid);//查找某人所有预售信息

    CommodityStorage findCommmoditySize(int id);//查找某条预售信息

    void deleteCommoditySize(int id);//删除某条预售信息

    CommodityStorage findMinpriceCommodityStore(int commodityID);//查询预售价格最低的id
}
