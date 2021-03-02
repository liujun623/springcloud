package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_KEY="http://localhost:8001";
    public static final String PAYMENT_KEY="http://CLOUDE-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("开始调用");
      return restTemplate.postForObject(PAYMENT_KEY+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")long id)
    {
        log.info("开始调用");
        return restTemplate.getForObject(PAYMENT_KEY+"/payment/getPaymentById/"+id,CommonResult.class);
    }
}
