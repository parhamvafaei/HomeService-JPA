package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.person.Manager;
import org.maktab.repository.ManagerRepository;

public class ManagerRepositoryImpl extends BaseRepositoryImpl<Manager> implements ManagerRepository {
    public ManagerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Manager> getEntityClass() {
        return Manager.class;
    }
}
