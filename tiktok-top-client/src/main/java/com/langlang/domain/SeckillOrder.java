package com.langlang.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeckillOrder implements Serializable {
    private String orderid;

    private String userid;

    private String productid;

    private String productname;

    private BigDecimal seckillprice;

    private BigDecimal originalprice;

    private Integer quantity;

    private String orderstatus;

    private Date ordertime;

    private Date paymenttime;

    private String shippingaddress;

    private String contactphone;

    private String paymentmethod;

    private String orderremark;
}