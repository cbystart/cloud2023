package cby.springcloud.dao;


import cby.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    void create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
