package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.Order;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Client;

import java.util.List;

public interface ClientService extends BaseService<Client> {

    void changePassword(Client client, String password);

}
