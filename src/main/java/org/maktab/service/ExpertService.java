package org.maktab.service;

import org.maktab.base.service.BaseService;
import org.maktab.entity.person.Expert;

public interface ExpertService extends BaseService<Expert> {


    void changePassword(Expert expert, String password);
}
