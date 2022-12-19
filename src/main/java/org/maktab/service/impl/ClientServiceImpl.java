package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Order;
import org.maktab.entity.OrderStatus;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Client;
import org.maktab.repository.ClientRepository;
import org.maktab.repository.impl.OrderRepositoryImpl;
import org.maktab.repository.impl.ServiceRepositoryImpl;
import org.maktab.repository.impl.SubServiceRepositoryImpl;
import org.maktab.service.ClientService;
import org.maktab.service.OrderService;
import org.maktab.service.ServiceService;
import org.maktab.service.SubServiceService;
import org.maktab.util.JpaConnection;

import java.util.List;

public class ClientServiceImpl extends BaseServiceImpl<Client, ClientRepository> implements ClientService {


    private final SubServiceService subServiceService = new SubServiceServiceImpl
            (new SubServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));

    private final ServiceService serviceService = new ServiceServiceImpl
            (new ServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));
    private final OrderService orderService = new OrderServiceImpl
            (new OrderRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }


    @Override
    public void addOrder(Order order, SubService subService) {
        order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT);
        order.setSubService(subService);
        try {
            repository.getEntityManager().getTransaction().begin();
            orderService.saveOrUpdate(order);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }

    }

    @Override
    public void changePassword(Client client, String password) {

        try {
            client.setPassword(password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(client);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }

    }

    @Override
    public List<Service> loadServices() {
        return serviceService.findAll();
    }

    @Override
    public List<SubService> showAllSubServices() {
        return subServiceService.findAll();
    }
}

