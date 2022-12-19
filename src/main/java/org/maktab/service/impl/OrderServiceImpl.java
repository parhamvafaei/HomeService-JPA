package org.maktab.service.impl;


import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Order;
import org.maktab.repository.OrderRepository;
import org.maktab.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
