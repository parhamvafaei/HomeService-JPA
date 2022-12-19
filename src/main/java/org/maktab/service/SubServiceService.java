package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.SubService;

public interface SubServiceService extends BaseService<SubService> {
    Boolean checkSubServiceByName(SubService subService);

    Long addSubService(SubService subService, String service);


}
