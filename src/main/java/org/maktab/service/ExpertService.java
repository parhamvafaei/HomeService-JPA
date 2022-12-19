package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.person.Expert;

import java.io.File;


public interface ExpertService extends BaseService<Expert> {


    void changePassword(Expert expert, String password);

    void changeEmail(Long id , String email);

    void setProfileImage(File image , Long id);
}
