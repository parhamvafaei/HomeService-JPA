package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.Order;
import org.maktab.repository.OrderRepository;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {
    public OrderRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
