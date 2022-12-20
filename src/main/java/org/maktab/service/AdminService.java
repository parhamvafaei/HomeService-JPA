package org.maktab.service;


import org.maktab.base.service.BaseService;
import org.maktab.entity.Service;
import org.maktab.entity.SubService;
import org.maktab.entity.person.Admin;
import org.maktab.entity.person.Expert;

import java.util.List;

//    move to sub service
//    move to service-service
//get permission to expert just when is confirmed


public interface AdminService extends BaseService<Admin> {

    void changePassword(Admin admin, String password);


}
