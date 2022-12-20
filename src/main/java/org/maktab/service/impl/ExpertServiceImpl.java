package org.maktab.service.impl;

import org.maktab.base.service.impl.BaseServiceImpl;
import org.maktab.entity.person.Expert;
import org.maktab.entity.person.ExpertStatus;
import org.maktab.repository.ExpertRepository;
import org.maktab.service.ExpertService;

import javax.validation.constraints.Email;
import java.io.*;
import java.util.Optional;


public class ExpertServiceImpl extends BaseServiceImpl<Expert, ExpertRepository> implements ExpertService {
    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }

    @Override
    public void changeEmail(Long id, @Email String email) {
        Optional<Expert> expert = repository.findById(id);
        if (expert.isPresent()) {
            expert.get().setEmail(email);

            try {
                repository.getEntityManager().getTransaction().begin();
                saveOrUpdate(expert.get());
                repository.getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                repository.getEntityManager().getTransaction().rollback();
                throw new RuntimeException();
            }
        } else
            throw new NullPointerException();


    }

    @Override
    public Long confirmExpert(Expert expert) {

        expert.setExpertStatus(ExpertStatus.CONFIRMED);
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(expert);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
        return expert.getId();
    }

    @Override
    public void setProfileImage(File image, Long id) {
        Expert expert = repository.findById(id).orElseThrow();
        byte[] bytes;
        if (image.getName().matches("/*jpg")) {
            try (FileInputStream reader = new FileInputStream(image)) {
                bytes = reader.readAllBytes();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else
            throw new RuntimeException();

        expert.setPhoto(bytes);
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(expert);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public void changePassword(Expert expert, String password) {

        try {
            expert.setPassword(password);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        try {
            repository.getEntityManager().getTransaction().begin();
            saveOrUpdate(expert);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            throw new RuntimeException();
        }


    }
}