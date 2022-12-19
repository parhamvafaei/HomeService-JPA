package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.SubService;
import org.maktab.exceptionhandler.NotFoundServiceException;
import org.maktab.exceptionhandler.RepetitiveServiceException;
import org.maktab.repository.SubServiceRepository;
import org.maktab.service.SubServiceService;
import org.maktab.util.Util;

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
}
