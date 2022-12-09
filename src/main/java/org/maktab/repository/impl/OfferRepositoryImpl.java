package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.Offer;
import org.maktab.repository.OfferRepository;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer> implements OfferRepository {
    public OfferRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }
}
