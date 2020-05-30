package com.ssm.tradingPlatfrom.controller;

import com.ssm.tradingPlatfrom.entity.Commodity;
import com.ssm.tradingPlatfrom.entity.CommodityBanner;
import com.ssm.tradingPlatfrom.entity.CommoditySort;
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

    @RequestMapping("/findCommodityBanner")//得到导航栏
    @ResponseBody
    private ServerResponse findCommodityBanner() {
        List<CommodityBanner> commodityBanners = commodityService.findCommodityBanner();
        if (commodityBanners!= null) {
            return  ServerResponse.createBySuccess("Banner广告位获取成功",commodityBanners);
        }else {
            return  ServerResponse.createByError("Banner广告位获取成功");
        }
    }

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

    @RequestMapping("/findHotCommodity")//得到模糊查询商品
    @ResponseBody
    private ServerResponse findHotCommodity() {
        List<Commodity> commoditySorts = commodityService.findHotCommodity();
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("获取热搜商品",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取热搜商品失败");
        }

    }

    @RequestMapping("/findOneCommodityById")//根据id查询商品
    @ResponseBody
    private ServerResponse findOneCommodityById(String id) {
        Commodity commoditySort = commodityService.findOneCommodityById(Integer.parseInt(id));
        if (commoditySort!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",commoditySort);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }

    @RequestMapping("/findCommodityOfSort")//查找某一类商品
    @ResponseBody
    private ServerResponse findCommodityOfSort(String id) {
        List<Commodity> commoditySorts = commodityService.findCommodityOfSort(Integer.parseInt(id));
        System.out.println(commoditySorts);
        if (commoditySorts!= null) {
            return  ServerResponse.createBySuccess("商品全部类别",commoditySorts);
        }else {
            return  ServerResponse.createByError("获取商品全部类别失败");
        }

    }


    @RequestMapping("/findCommoditySortById")//根据商品id查询商品对应类别
    @ResponseBody
    private ServerResponse findCommoditySortById(String id) {
        CommoditySort commoditySort = commodityService.findCommoditySortById(Integer.parseInt(id));
        if (commoditySort!= null) {
            return  ServerResponse.createBySuccess("商品id对应类别",commoditySort);
        }else {
            return  ServerResponse.createByError("获取商品id对应类别失败");
        }

    }


    @RequestMapping("/stopCommodity")
    @ResponseBody
    private ServerResponse stopCommodity(String id) {
        Boolean change = commodityService.stopCommodity(Integer.parseInt(id));
        if (change) {
            return  ServerResponse.createBySuccess("停止展示商品成功",change);
        }else {
            return  ServerResponse.createByError("停止展示商品失败");
        }
    }

    @RequestMapping("/openCommodity")
    @ResponseBody
    private ServerResponse openCommodity(String id) {
        Boolean change = commodityService.openCommodity(Integer.parseInt(id));
        if (change) {
            return  ServerResponse.createBySuccess("启用展示商品成功",change);
        }else {
            return  ServerResponse.createByError("启用展示商品失败");
        }
    }

}
