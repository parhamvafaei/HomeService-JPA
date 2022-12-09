package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.person.Expert;
import org.maktab.repository.ExpertRepository;

public class ExpertRepositoryImpl extends BaseRepositoryImpl<Expert> implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
