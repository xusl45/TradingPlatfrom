package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommoditySort;
import com.ssm.tradingPlatfrom.entity.User;
import com.ssm.tradingPlatfrom.service.CommodityService;
import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//商品展示控制层
@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/findCommoditySort")//得到分类列表
    @ResponseBody
    private ServerResponse findCommoditySort() {
        List<CommoditySort> commoditySorts = commodityService.findCommoditySort();
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }
    
    @RequestMapping("/findALLCommodity")//得到所有商品
    @ResponseBody
    private ServerResponse findALLCommodity() {
        List<Commodity> commoditySorts = commodityService.findALLCommodity();
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("商品全部信息",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取所有商品信息失败");
        }

    }

    @RequestMapping("/findOneCommodity")//得到模糊查询商品
    @ResponseBody
    private ServerResponse findOneCommodity(String name) {
        List<Commodity> commoditySorts = commodityService.findOneCommodity(name);
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }

    @RequestMapping("/findCommodityOfSort")//查找某一类商品
    @ResponseBody
    private ServerResponse findCommodityOfSort(String id) {
        List<Commodity> commoditySorts = commodityService.findCommodityOfSort(Integer.parseInt(id));
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }


}
