package com.ssm.tradingPlatfrom.service.impl;

import com.ssm.tradingPlatfrom.dao.CommodityBuyedDao;
import com.ssm.tradingPlatfrom.dao.CommodityDao;
import com.ssm.tradingPlatfrom.dao.UserDao;
import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommodityRecord;
import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.entity.UserMessage;
import com.ssm.tradingPlatfrom.service.CommodityBuyedService;
import com.ssm.tradingPlatfrom.service.CommodityTradingService;
import com.ssm.tradingPlatfrom.utils.OrderCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "commodityBuyedService")
public class CommodityBuyedServicelmpl implements CommodityBuyedService {

    @Resource
    private UserDao userDao;
    @Resource
    private CommodityDao commodityDao;
    @Autowired
    private CommodityTradingService commodityTradingService;
    @Autowired
    private CommodityBuyedDao commodityBuyedDao;


    @Override
    public Boolean insertCommodityOrder(CommodityRecord commodityRecord) {
        commodityBuyedDao.insertCommodityOrder(commodityRecord);
        commodityTradingService.deleteCommoditySize(commodityRecord.getStorageID());

        return true;
    }

    @Override
    public List<CommodityRecord> findCommodityOrderBidByID(int bid) {
        List<CommodityRecord> commodityRecords = commodityBuyedDao.findCommodityOrderBidByID(bid);
        return commodityRecords;
    }

    @Override
    public List<CommodityRecord> findCommodityOrderUidByID(int uid) {
        List<CommodityRecord> commodityRecords = commodityBuyedDao.findCommodityOrderUidByID(uid);
        return commodityRecords;
    }

    @Override
    public Boolean sendCommodityAfter(String id) {
        CommodityRecord commodityRecord = new CommodityRecord(Integer.parseInt(id),"SF"+ OrderCodeFactory.getReturnCode((long)Integer.parseInt(id)),1);
        commodityBuyedDao.sendCommodityAfter(commodityRecord);
        return true;
    }

    @Override
    public Boolean sendCommodityReceiving(String id) {
        CommodityRecord commodityRecord =commodityBuyedDao.findCommodityOrderByID(Integer.parseInt(id));
        User user = userDao.findUserMessageByID(commodityRecord.getUid());
        UserMessage userMessage = new UserMessage(user.getId(),user.getUserMessages().getRemainSum()+commodityRecord.getPrice());
        userDao.updateRemainingSum(userMessage);
        Commodity commodity = commodityDao.findCommodity(commodityRecord.getCommodityID());
        commodity.setSellNum(commodity.getSellNum()+1);
        commodityDao.updateSellNum(commodity);
        commodityBuyedDao.sendCommodityReceiving(Integer.parseInt(id));
        return true;
    }

    @Override
    public CommodityRecord findCommodityOrderByID(int id) {
        CommodityRecord commodityRecord =commodityBuyedDao.findCommodityOrderByID(id);
        return commodityRecord;
    }

    @Override
    public List<CommodityRecord> findALLCommodityOrder() {
        List<CommodityRecord> commodityRecords = commodityBuyedDao.findALLCommodityOrder();
        return commodityRecords;
    }
}
