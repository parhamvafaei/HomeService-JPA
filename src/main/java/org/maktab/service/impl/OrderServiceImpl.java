package org.maktab.service.impl;


import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Order;
import org.maktab.entity.OrderStatus;
import org.maktab.entity.SubService;
import org.maktab.repository.OrderRepository;
import org.maktab.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Order, OrderRepository> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }

    @Override
    public void addOrder(Order order, SubService subService) {
        order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT);
        order.setSubService(subService);
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(order);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }

    }
}
