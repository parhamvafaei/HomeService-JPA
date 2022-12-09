package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.person.Client;

public interface ClientService extends BaseService<Client> {
    void changePassword(String email);
}
