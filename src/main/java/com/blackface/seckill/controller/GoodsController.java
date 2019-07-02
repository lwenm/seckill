package com.blackface.seckill.controller;

import com.blackface.seckill.domain.SecUser;
import com.blackface.seckill.redis.RedisService;
import com.blackface.seckill.vo.SecKillGoodsVo;
import com.blackface.seckill.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author:lwenm
 * Description: 商品相关控制类
 * Date:2019/5/16
 * Time:21:32
 **/

@Controller
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    RedisService redisService;

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/to_list")
    public String toGoodsList(Model model, SecUser user) {

//        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
//            return "login";
//        }
//
//        String token = StringUtils.isEmpty(cookieToken) ? paramToken : cookieToken;
//        SecUser user = redisService.get(AccToken.getToken, token, SecUser.class);
//        if(user == null){
//            return "login";
//        }

        List<SecKillGoodsVo> secGoods = goodsService.getSecKillGoodsList();

        model.addAttribute("goodsList", secGoods);

        return "goods_list";
    }


    @GetMapping("/to_detail/{id}")
    public String toDetail(Model model, SecUser user, @PathVariable Long id) {


        SecKillGoodsVo goods = goodsService.getSecKillGoods(id);
        System.out.println(goods.toString()+"-------------------------------");
        model.addAttribute("goods", goods);
        model.addAttribute("user", user);

        long startAt = goods.getStartDate().getTime();
        long endAt = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();


        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if(now < startAt ) {//秒杀还没开始，倒计时
            miaoshaStatus = 0;
            remainSeconds = (int)((startAt - now )/1000);
        }else  if(now > endAt){//秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        }else {//秒杀进行中
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods_detail";
    }
}
