package org.maktab.service.impl;

import org.maktab.base.service.BaseService;
import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.person.Client;
import org.maktab.repository.ClientRepository;
import org.maktab.service.ClientService;

import java.time.LocalDateTime;
import java.util.List;

public class ClientServiceImpl extends BaseServiceImpl<Client, ClientRepository> implements ClientService {

    private final ServiceService serviceService = new ServiceServiceImpl(new ServiceRepositoryImpl(HibernateUtil.getEmf().createEntityManager()));
    private final SubServiceService subServiceService = new SubServiceServiceImpl(new SubServiceRepositoryImpl(HibernateUtil.getEmf().createEntityManager()));
    private final OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl(HibernateUtil.getEmf().createEntityManager()));

    @Override
    public void signUp(Customer customer) {
        if (isEmailExist(customer.getEmail()))
            throw new DuplicateEmailException("this email is exist");
        else if (isNationalCodeExist(customer.getNationalCode()))
            throw new DuplicateNationalCodeException("this national code is exist");
        checkEmailAndNationalCode(customer);
        customer.setCredit(0D);
        customer.setSignUpTime(LocalDateTime.now());
        this.saveOrUpdate(customer);
    }

    @Override
    public void addOrder(Order order) {
        order.setStatus(OrderStatus.WAIT_SUGGESTION_EXPERT);
        orderService.saveOrUpdate(order);
    }

    @Override
    public void changePassword(String password, Customer customer) {
        customer.setPassword(password);
        try {
            Validation.checkPassword(customer);
            saveOrUpdate(customer);
        } catch (IncorrectFormatPasswordException e) {
            throw new IncorrectFormatPasswordException(e.getMessage());
        }
    }

    @Override
    public List<Service> showAllServices() {
        return serviceService.loadAll();
    }

    @Override
    public List<SubService> showAllSubServices() {
        return subServiceService.loadAll();
    }
}

