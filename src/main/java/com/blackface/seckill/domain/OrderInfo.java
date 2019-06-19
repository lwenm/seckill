package com.blackface.seckill.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Long deliveryAddrId;

    private String goodsName;

    private Integer goodsCount;

    private Double goodsPrice;

    private int orderChannel;

    private int status;

    private Date createDate;

    private Date payDate;


}