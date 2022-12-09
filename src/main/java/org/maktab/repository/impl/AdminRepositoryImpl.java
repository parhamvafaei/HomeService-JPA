package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.person.Admin;
import org.maktab.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }


}
