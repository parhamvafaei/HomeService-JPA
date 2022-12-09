package org.maktab.service;


import org.maktab.base.service.BaseService;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Admin;
import org.maktab.entity.person.Expert;

import java.util.List;

public interface AdminService extends BaseService<Admin> {

    List<SubService> LoadSubServices();
    Long addSubService(SubService subService, String service);
    List<Service> loadServices();
    void addExpertToSubService(Expert expert , SubService subService);
    void deleteExpertOfSubService(Expert expert , SubService subService);
    Long confirmExpert(Expert expert);
    Boolean checkSubServiceByName(SubService subService);
    //change pass

}
