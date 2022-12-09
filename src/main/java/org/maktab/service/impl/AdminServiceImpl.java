package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Admin;
import org.maktab.entity.person.Expert;
import org.maktab.exceptionhandler.NotFoundServiceException;
import org.maktab.exceptionhandler.RepetitiveServiceException;
import org.maktab.repository.AdminRepository;
import org.maktab.repository.impl.ExpertRepositoryImpl;
import org.maktab.repository.impl.SubServiceRepositoryImpl;
import org.maktab.service.AdminService;
import org.maktab.service.ExpertService;
import org.maktab.service.SubServiceService;
import org.maktab.util.JpaConnection;
import org.maktab.util.Util;

import java.util.Arrays;
import java.util.List;

public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService {


    private final SubServiceService subServiceService = new SubServiceServiceImpl
            (new SubServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));
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
    public Long addSubService(SubService subService, String service) {
        while (subServiceService.isExistsById(subService.getId())){
            if (subServiceService.checkSubServiceByName(subService)) {
                throw new RepetitiveServiceException("already exist !");

            } else if (!(Util.isContain(service))) {
                throw new NotFoundServiceException("this service doesnt exist !");
            }else{
                subServiceService.saveOrUpdate(subService);
                return subService.getId();
            }
        }
        return null;
    }


    @Override
    public List<Service> loadServices() {
        return List.of(Service.getServices());
    }

    @Override
    public Long addExpertToSubService(Expert expert, SubService subService) {
        if (expert.getStatus() == ExpertStatus.NEW || expert.getStatus() == ExpertStatus.AWAITING_CONFIRMATION) {
            throw new NotAccessExpertException("expert has no access");
        }
        for (ExpertSubService expertSubService : expert.getExpertSubServices()) {
            if (expertSubService.getSubService().getName().equalsIgnoreCase(subService.getName())) {
                throw new DuplicateSubServiceExpertException("sub service exist for expert");
            }
        }
        checkSubServiceNameExist(!subServiceService.isNameExist(subService.getName()), "this sub service isn't exist");
        ExpertSubService expertSubService = new ExpertSubService(expert, subService, 0F);
        expertSubServiceService.saveOrUpdate(expertSubService);
    }
    }

    @Override
    public void deleteExpertOfSubService(Expert expert, SubService subService) {

    }

    @Override
    public Long confirmExpert(Expert expert) {
        return null;
    }
}
