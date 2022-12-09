package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.SubService;
import org.maktab.repository.SubServiceRepository;
import org.maktab.repository.impl.SubServiceRepositoryImpl;
import org.maktab.service.SubServiceService;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService, SubServiceRepository> implements SubServiceService {

    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }

    @Override
    public Boolean checkSubServiceByName(SubService subService) {
        return repository.checkSubServiceByName(subService);
    }
}
