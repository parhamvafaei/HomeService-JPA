package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Expert;
import org.maktab.entity.person.ExpertStatus;
import org.maktab.exceptionhandler.ExpertAddException;
import org.maktab.exceptionhandler.NotFoundServiceException;
import org.maktab.exceptionhandler.RepetitiveServiceException;
import org.maktab.repository.SubServiceRepository;
import org.maktab.service.SubServiceService;
import org.maktab.util.Util;

import java.util.List;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService, SubServiceRepository> implements SubServiceService {

    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }

    @Override
    public Boolean checkSubServiceByName(SubService subService) {
        return repository.checkSubServiceByName(subService);
    }


    @Override
    public Long addSubService(SubService subService, String service) {
        if (!(isExistsById(subService.getId())))
            throw new NotFoundServiceException("this SubService doesnt exist !");

        if (checkSubServiceByName(subService))
            throw new RepetitiveServiceException("this SubService was already added!");

        if (!(Util.isContain(service)))
            throw new NotFoundServiceException("this SubService was already added!");

        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(subService);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
        return subService.getId();


    }

    @Override
    public List<SubService> LoadSubServices() {
        return findAll();
    }


    @Override
    public void editSubService(SubService subService, Double price, String description) {
        if (!(isExistsById(subService.getId())))
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
            saveOrUpdate(subService);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
    }


    @Override
    public void addExpertToSubService(Expert expert, SubService subService) {

        if (expert.getStatus() == ExpertStatus.CONFIRMED && checkSubServiceByName(subService)) {
            List<Expert> experts = subService.getExperts();
            experts.add(expert);
            subService.setExperts(experts);
            try {
                repository.getEntityManager().getTransaction().begin();
                saveOrUpdate(subService);
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
                saveOrUpdate(subService);
                repository.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                repository.getEntityManager().getTransaction().rollback();
                throw new RuntimeException();
            }


        } else
            throw new RuntimeException("delete expert of subService failed!");
    }
}
