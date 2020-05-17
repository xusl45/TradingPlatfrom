package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.CommodityRecord;
import com.ssm.tradingPlatfrom.service.CommodityBuyedService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//商品购买控制层
@Controller
public class CommodityBuyedController {

    @Autowired
    private CommodityBuyedService commodityBuyedService;

    @RequestMapping("/insertCommodityOrder")//增加购买订单
    @ResponseBody
    private ServerResponse insertCommodityOrder(String uid, String bid, String price, String tradingPrice, String commodityID
             , String storageID, String addressID, String size, String pay , String orderNumber) {
        CommodityRecord commodityRecord  = new CommodityRecord(Integer.parseInt(uid),Integer.parseInt(bid),Integer.parseInt(price),Integer.parseInt(tradingPrice),
                Integer.parseInt(storageID),Integer.parseInt(commodityID),Integer.parseInt(addressID),Integer.parseInt(size),Integer.parseInt(pay),orderNumber);
        Boolean insertCommodityOrder = commodityBuyedService.insertCommodityOrder(commodityRecord);
        if (insertCommodityOrder!= null) {
            return  ServerResponse.createBySuccess("添加预售商品成功",insertCommodityOrder);
        }else {
            return  ServerResponse.createByError("添加预售商品失败");
        }

    }

    @RequestMapping("/sendCommodityAfter")//点击发货之后
    @ResponseBody
    private ServerResponse sendCommodityAfter(String id) {
        Boolean sendCommodityOrder = commodityBuyedService.sendCommodityAfter(id);
        if (sendCommodityOrder!= null) {
            return  ServerResponse.createBySuccess("点击发货之后",sendCommodityOrder);
        }else {
            return  ServerResponse.createByError("点击发货之后操作失败");
        }
    }

    @RequestMapping("/sendCommodityReceiving")//点击收货之后
    @ResponseBody
    private ServerResponse sendCommodityReceiving(String id) {
        Boolean sendCommodityOrder = commodityBuyedService.sendCommodityReceiving(id);
        if (sendCommodityOrder!= null) {
            return  ServerResponse.createBySuccess("点击收货之后操作",sendCommodityOrder);
        }else {
            return  ServerResponse.createByError("点击收货之后操作失败");
        }
    }



    @RequestMapping("/findCommodityOrderBidByID")//查询购买者所有购买订单
    @ResponseBody
    private ServerResponse findCommodityOrderBidByID(String bid) {
        List<CommodityRecord> commodityRecord = commodityBuyedService.findCommodityOrderBidByID(Integer.parseInt(bid));
        if (commodityRecord != null) {
            return  ServerResponse.createBySuccess("查询购买者所有购买订单",commodityRecord);
        }else {
            return  ServerResponse.createByError("查询购买者所有购买订单失败");
        }

    }

    @RequestMapping("/findCommodityOrderUidByID")//查询出售者所有出售订单
    @ResponseBody
    private ServerResponse findCommodityOrderUidByID(String uid) {
        List<CommodityRecord> commodityRecord = commodityBuyedService.findCommodityOrderUidByID(Integer.parseInt(uid));
        if (commodityRecord != null) {
            return  ServerResponse.createBySuccess("查询出售者所有出售订单",commodityRecord);
        }else {
            return  ServerResponse.createByError("查询出售者所有出售订单");
        }

    }
    @RequestMapping("/findCommodityOrderByID")//根据id查询订单
    @ResponseBody
    private ServerResponse findCommodityOrderByID(String id) {
        CommodityRecord commodityRecord = commodityBuyedService.findCommodityOrderByID(Integer.parseInt(id));
        if (commodityRecord != null) {
            return  ServerResponse.createBySuccess("查询出售者所有出售订单",commodityRecord);
        }else {
            return  ServerResponse.createByError("查询出售者所有出售订单");
        }

    }

    @RequestMapping("/findALLCommodityOrder")//查询所有出售订单
    @ResponseBody
    private ServerResponse findALLCommodityOrder() {
        List<CommodityRecord> commodityRecord = commodityBuyedService.findALLCommodityOrder();
        if (commodityRecord != null) {
            return  ServerResponse.createBySuccess("查询所有出售订单",commodityRecord);
        }else {
            return  ServerResponse.createByError("查询所有出售订单");
        }

    }

}
