package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.person.Expert;
import org.maktab.repository.ExpertRepository;
import org.maktab.service.ExpertService;

public class ExpertServiceImpl extends BaseServiceImpl<Expert, ExpertRepository> implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public void changePassword(String email) {

    }

    /add photo
}
