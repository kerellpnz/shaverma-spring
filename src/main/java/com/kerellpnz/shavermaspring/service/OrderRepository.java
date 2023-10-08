package com.kerellpnz.shavermaspring.service;

import com.kerellpnz.shavermaspring.domain.ShavermaOrder;

public interface OrderRepository {

    ShavermaOrder save(ShavermaOrder order);
}
