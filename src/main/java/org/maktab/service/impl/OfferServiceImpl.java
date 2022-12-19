package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.Offer;
import org.maktab.repository.OfferRepository;
import org.maktab.service.OfferService;

public class OfferServiceImpl extends BaseServiceImpl<Offer, OfferRepository> implements OfferService {
    public OfferServiceImpl(OfferRepository repository) {
        super(repository);
    }
}
