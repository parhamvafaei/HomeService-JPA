package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.SubService;
import org.maktab.repository.SubServiceRepository;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService> implements SubServiceRepository {
    public SubServiceRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public Boolean checkSubServiceByName(SubService subService) {
        Object result = em.createQuery("select from " + getEntityClass().getSimpleName() + " s where s.getName()= :name")
                .setParameter("name", subService.getName()).getSingleResult();
        if (result==null) {
            return false;
        }
        return true;
    }
}
