package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Admin;
import org.maktab.entity.person.Expert;
import org.maktab.entity.person.ExpertStatus;
import org.maktab.exceptionhandler.ExpertAddException;
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
        if (subServiceService.isExistsById(subService.getId())){
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
    public void addExpertToSubService(Expert expert, SubService subService) {

        if (expert.getStatus()== ExpertStatus.CONFIRMED && subServiceService.checkSubServiceByName(subService)) {
            List<Expert> experts = subService.getExperts();
            experts.add(expert);
            subService.setExperts(experts);
        subServiceService.saveOrUpdate(subService);
    }else
        throw new ExpertAddException();
    }

    @Override
    public void deleteExpertOfSubService(Expert expert, SubService subService) {

        if (subService.getExperts().contains(expert)) {
            List<Expert> experts = subService.getExperts();
            experts.remove(expert);
            subService.setExperts(experts);
            subServiceService.saveOrUpdate(subService);

            }else
        throw new NotFoundServiceException("this sub service isn't exist for you");
    }


    @Override
    public Long confirmExpert(Expert expert) {

        return null;
    }

    @Override
    public Boolean checkSubServiceByName(SubService subService) {
        return null;
    }
}
