package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.person.Client;
import org.maktab.repository.ClientRepository;
import org.maktab.service.ClientService;


public class ClientServiceImpl extends BaseServiceImpl<Client, ClientRepository> implements ClientService {


    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }


    @Override
    public void changePassword(Client client, String password) {

        try {
            client.setPassword(password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(client);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }

    }

}

