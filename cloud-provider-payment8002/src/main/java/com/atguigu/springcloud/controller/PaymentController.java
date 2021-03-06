package com.atguigu.springcloud.controller;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    //数据的添加
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
       log.info("*****插入结果"+result);
        if (result>0) {
            return new CommonResult(200,"插入数据成功,端口号是："+port,result);
        }else {
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    //是数据的查询
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment=paymentService.getPaymentById(id);
       log.info("*****查询结果"+payment);
        if (payment!=null) {
            return new CommonResult(200,"查询数据成功，端口号是："+port,payment);
        }else {
            return new CommonResult(444,"没有查询到数据："+id,null);
        }
    }
}
