package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Expert;

import java.util.List;

public interface SubServiceService extends BaseService<SubService> {
    Boolean checkSubServiceByName(SubService subService);

    Long addSubService(SubService subService, String service);

    List<SubService> LoadSubServices();

    void editSubService(SubService subService, Double price, String description);

    void addExpertToSubService(Expert expert, SubService subService);

    void deleteExpertOfSubService(Expert expert, SubService subService);

}
