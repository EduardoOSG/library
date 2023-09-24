package com.uam.microservices.catalog.repositories;

import com.uam.microservices.catalog.entities.CatEstatusEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CatEstatusRepository extends CrudRepository<CatEstatusEntity, Long> {

    Set<CatEstatusEntity> findAllByActiveIsTrue();

}
