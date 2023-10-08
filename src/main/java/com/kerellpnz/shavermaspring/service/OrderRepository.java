package com.kerellpnz.shavermaspring.service;

import com.kerellpnz.shavermaspring.domain.ShavermaOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<ShavermaOrder, Long> {

    List<ShavermaOrder> findByDeliveryZip(String deliveryZip);

    List<ShavermaOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    @Query("select o from ShavermaOrder o where o.deliveryCity='Seattle'")
    List<ShavermaOrder> readOrdersDeliveredInSeattle();
}
