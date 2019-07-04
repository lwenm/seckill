package com.blackface.seckill.controller;

import com.blackface.seckill.domain.OrderInfo;
import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.service.impl.SecKillServiceImpl;
import com.blackface.seckill.vo.SecKillGoodsVo;
import com.blackface.seckill.result.CodeMsg;
import com.blackface.seckill.service.impl.GoodsServiceImpl;
import com.blackface.seckill.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/27
 * Time:20:58
 **/
@Controller
@RequestMapping("/seckill")
public class SecKillController {


    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    SecKillServiceImpl secKillService;


    @PostMapping("/do_seckill")
    public String doKill(Model model, SecUser user, @RequestParam("goodsId") long goodsId){


        SecKillGoodsVo goodsVo = goodsService.getSecKillGoods(goodsId);

        //判断库存
        int stock = goodsVo.getSeckillStock();
        if(stock<=0){
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER);
            return "seckill_fail";
        }


        //防止重复秒杀
        OrderInfo order =  orderService.getOrderInfoByUserIdAndGoodId(user.getId(),goodsVo.getId());
        if(order!=null){
            model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA );
            return "seckill_fail";
        }

        //判断库存  写入订单  写入秒杀订单
         OrderInfo orderInfo = secKillService.kill(user,goodsVo);

        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goodsVo);


        return "order_detail";
    }


}
