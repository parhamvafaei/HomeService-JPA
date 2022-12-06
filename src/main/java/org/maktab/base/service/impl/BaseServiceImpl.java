package org.maktab.base.service.impl;



import org.maktab.base.entity.BaseEntity;
import org.maktab.base.repository.BaseRepository;
import org.maktab.base.service.BaseService;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl <E extends BaseEntity,R extends BaseRepository<E>>
        implements BaseService<E> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public Long saveOrUpdate(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.saveOrUpdate(e);
        repository.getEntityManager().getTransaction().commit();
        return e.getId();
    }



    @Override
    public void delete(E e) {
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean isExistsById(Long id) {
        return repository.isExistsById(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}