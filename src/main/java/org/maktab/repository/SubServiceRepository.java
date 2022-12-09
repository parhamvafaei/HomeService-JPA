package org.maktab.repository;

import org.maktab.base.repository.BaseRepository;
import org.maktab.entity.SubService;

public interface SubServiceRepository extends BaseRepository<SubService> {
    Boolean checkSubServiceByName(SubService subService);
}
