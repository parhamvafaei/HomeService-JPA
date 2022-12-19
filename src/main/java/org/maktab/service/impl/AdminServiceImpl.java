package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Admin;
import org.maktab.entity.person.Expert;
import org.maktab.entity.person.ExpertStatus;
import org.maktab.exceptionhandler.ExpertAddException;
import org.maktab.exceptionhandler.NotFoundServiceException;
import org.maktab.repository.AdminRepository;
import org.maktab.repository.impl.ExpertRepositoryImpl;
import org.maktab.repository.impl.ServiceRepositoryImpl;
import org.maktab.repository.impl.SubServiceRepositoryImpl;
import org.maktab.service.AdminService;
import org.maktab.service.ExpertService;
import org.maktab.service.ServiceService;
import org.maktab.service.SubServiceService;
import org.maktab.util.JpaConnection;


import java.util.List;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService {


    private final SubServiceService subServiceService = new SubServiceServiceImpl
            (new SubServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));

    private final ServiceService serviceService = new ServiceServiceImpl
            (new ServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));
    private final ExpertService expertService = new ExpertServiceImpl
            (new ExpertRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public List<SubService> LoadSubServices() {
        return subServiceService.findAll();
    }

    @Override
    public void changePassword(Admin admin, String password) {

        try {
            admin.setPassword(password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(admin);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public void editSubService(SubService subService, Double price, String description) {
        if (!(subServiceService.isExistsById(subService.getId())))
            throw new NotFoundServiceException("this SubService doesnt exist !");
        boolean condition = price == null && description == null;
        while (!(condition)) {
            if (price == null)
                subService.setDescription(description);
            else if (description == null) {
                subService.setPrice(price);
            } else {
                subService.setDescription(description);
                subService.setPrice(price);
            }
            condition = true;
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            subServiceService.saveOrUpdate(subService);
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
    public void addExpertToSubService(Expert expert, SubService subService) {

        if (expert.getStatus() == ExpertStatus.CONFIRMED && subServiceService.checkSubServiceByName(subService)) {
            List<Expert> experts = subService.getExperts();
            experts.add(expert);
            subService.setExperts(experts);
            try {
                repository.getEntityManager().getTransaction().begin();
                subServiceService.saveOrUpdate(subService);
                repository.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                repository.getEntityManager().getTransaction().rollback();
                throw new RuntimeException();
            }

        } else
            throw new ExpertAddException();
    }

    @Override
    public void deleteExpertOfSubService(Expert expert, SubService subService) {

        if (subService.getExperts().contains(expert)) {
            List<Expert> experts = subService.getExperts();
            experts.remove(expert);
            subService.setExperts(experts);
            try {
                repository.getEntityManager().getTransaction().begin();
                subServiceService.saveOrUpdate(subService);
                repository.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                repository.getEntityManager().getTransaction().rollback();
                throw new RuntimeException();
            }


        } else
            throw new RuntimeException("delete expert of subService failed!");
    }


    @Override
    public Long confirmExpert(Expert expert) {

        expert.setExpertStatus(ExpertStatus.CONFIRMED);
        try {
            repository.getEntityManager().getTransaction().begin();
            expertService.saveOrUpdate(expert);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
        return expert.getId();
    }

    @Override
    public Boolean checkSubServiceByName(SubService subService) {
        return subServiceService.checkSubServiceByName(subService);
    }
}
