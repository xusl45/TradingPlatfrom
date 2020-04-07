package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.CommoditySort;
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
    private ServerResponse insertCommoditySize(String uid,String price,String size ,String commodityID) {
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
        System.out.println(uid+"许舒隆大帅哥");
        List<CommodityStorage> commodityStorages = commodityTradingService.showALLCommoditySize(Integer.parseInt(uid));
        if (commodityStorages!= null) {
            return  ServerResponse.createBySuccess("添加预售商品成功",commodityStorages);
        }else {
            return  ServerResponse.createByError("添加预售商品失败");
        }

    }


}
