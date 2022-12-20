package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.Order;
import org.maktab.entity.SubService;

public interface OrderService extends BaseService<Order> {
    void addOrder(Order order, SubService subService);
}
