package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.person.Admin;
import org.maktab.repository.AdminRepository;
import org.maktab.service.AdminService;




public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService {


    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }


    @Override
    public void changePassword(Admin admin, String password) {

        try {
            admin.setPassword(password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(admin);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
    }


}
