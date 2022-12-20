package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.Service;
import java.util.List;


public interface ServiceService extends BaseService<Service> {


    List<Service> loadServices();
}
