package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.CommodityStorage;
import com.ssm.tradingPlatfrom.service.CommodityTradingService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//商品交易控制层
@Controller
public class CommodityTradingController {


    @Autowired
    private CommodityTradingService commodityTradingService;

    @RequestMapping("/insertCommoditySize")//增加挂售商品尺码 价格 用户id
    @ResponseBody
    private ServerResponse insertCommoditySize(String uid, String price, String size , String commodityID) {
        CommodityStorage commodityStorage = new CommodityStorage(Integer.parseInt(uid),Integer.parseInt(price),Integer.parseInt(size),Integer.parseInt(commodityID));
        Boolean insertCommoditySize = commodityTradingService.insertCommoditySize(commodityStorage);
        if (insertCommoditySize!= null) {
            return  ServerResponse.createBySuccess("添加预售商品成功",insertCommoditySize);
        }else {
            return  ServerResponse.createByError("添加预售商品失败");
        }

    }

    @RequestMapping("/showALLCommoditySize")//展示自己所有挂售商品
    @ResponseBody
    private ServerResponse showALLCommoditySize(String uid) {
        List<CommodityStorage> commodityStorages = commodityTradingService.showALLCommoditySize(Integer.parseInt(uid));
        if (commodityStorages!= null) {
            return  ServerResponse.createBySuccess("添加预售商品成功",commodityStorages);
        }else {
            return  ServerResponse.createByError("添加预售商品失败");
        }

    }

    @RequestMapping("/deleteCommoditySize")//取消挂售
    @ResponseBody
    private ServerResponse deleteCommoditySize(String id) {
        Boolean deleteCommoditySize = commodityTradingService.deleteCommoditySize(Integer.parseInt(id));
        if (deleteCommoditySize!= null) {
            return  ServerResponse.createBySuccess("取消预售商品成功",deleteCommoditySize);
        }else {
            return  ServerResponse.createByError("取消预售商品失败");
        }

    }

    @RequestMapping("/showALLCommoditySizeById")//显示某个id商品的挂售信息
    @ResponseBody
    private ServerResponse showALLCommoditySizeById(String commodityId) {
        List<CommodityStorage> commodityStorages = commodityTradingService.showALLCommoditySizeById(Integer.parseInt(commodityId));
        if (commodityStorages!= null) {
            return  ServerResponse.createBySuccess("添加预售商品成功",commodityStorages);
        }else {
            return  ServerResponse.createByError("添加预售商品失败");
        }

    }

    @RequestMapping("/findALLCommoditySize")//展示所有挂售信息
    @ResponseBody
    private ServerResponse findALLCommoditySize() {
        List<CommodityStorage> commodityStorages = commodityTradingService.findALLCommoditySize();
        if (commodityStorages!= null) {
            return  ServerResponse.createBySuccess("展示所有预售商品成功",commodityStorages);
        }else {
            return  ServerResponse.createByError("展示预售商品失败");
        }

    }



}
