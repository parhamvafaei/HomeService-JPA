package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Service;

import org.maktab.repository.ServiceRepository;

import org.maktab.service.ServiceService;

import java.util.List;


public class ServiceServiceImpl extends BaseServiceImpl<Service, ServiceRepository> implements ServiceService {


    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }

    @Override
    public List<Service> loadServices() {
        return findAll();
    }
}
