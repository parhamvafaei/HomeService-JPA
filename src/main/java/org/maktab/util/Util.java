package org.maktab.util;


import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.repository.impl.ServiceRepositoryImpl;
import org.maktab.repository.impl.SubServiceRepositoryImpl;
import org.maktab.service.ServiceService;
import org.maktab.service.impl.ServiceServiceImpl;
import org.maktab.service.impl.SubServiceServiceImpl;

import java.util.List;
import java.util.Optional;

public class Util {
    private static final ServiceService ServiceService = new ServiceServiceImpl
            (new ServiceRepositoryImpl(JpaConnection.getEntityManagerFactory().createEntityManager()));

    public static Boolean isContain(String service){
        List<Service> list = ServiceService.findAll();
        Optional<Service> matchingObject = list.stream().
               filter(s -> s.getName().equals(service)).
               findFirst();
        return matchingObject.isPresent();
    }
}
