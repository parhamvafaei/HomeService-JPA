package org.maktab.base.repository;



import jakarta.persistence.EntityManager;
import org.maktab.base.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {


    Long saveOrUpdate(E entity);

    void delete (E e);

    Optional<E> findById (Long id);

    List<E> findAll();

    boolean isExistsById(Long id);

    Long countAll();

    EntityManager getEntityManager();
}