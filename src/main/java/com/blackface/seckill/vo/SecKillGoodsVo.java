package com.blackface.seckill.vo;

import com.blackface.seckill.domain.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author:lwenm
 * Description:
 * Date:2019/5/21
 * Time:22:36
 **/

@Data
public class SecKillGoodsVo extends Goods {

    private Long secId;

    private Integer seckillStock;

    private Double seckillPrice;

    private Date startDate;

    private Date endDate;

}
