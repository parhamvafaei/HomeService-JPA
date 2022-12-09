package org.maktab.repository.impl;

import jakarta.persistence.EntityManager;
import org.maktab.base.repository.impl.BaseRepositoryImpl;
import org.maktab.entity.person.Client;
import org.maktab.repository.ClientRepository;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client> implements ClientRepository {

    public ClientRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Client> getEntityClass() {
        return Client.class;
    }
}
