package cby.springcloud.controller;

import cby.springcloud.pojo.CommonResult;
import cby.springcloud.pojo.Payment;
import cby.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        try {
            paymentService.create(payment);
            return new CommonResult<Payment>(200,"插入数据库成功, serverPort = " + serverPort);
        } catch (Exception e) {
            return new CommonResult<Payment>(444,"插入数据库失败");
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        try {
            Payment payment = paymentService.getPaymentById(id);
            if (payment != null) {
                return new CommonResult<Payment>(200,"查询成功, serverPort = " + serverPort,payment);
            }
            return new CommonResult<Payment>(444,"未查询到相关记录");
        } catch (Exception e) {
            return new CommonResult<Payment>(444,"查询失败");
        }
    }


}
