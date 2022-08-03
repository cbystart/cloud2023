package cby.springcloud.service;

import cby.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    void create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
