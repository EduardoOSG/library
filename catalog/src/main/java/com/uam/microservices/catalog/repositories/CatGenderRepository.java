package com.uam.microservices.catalog.repositories;

import com.uam.microservices.catalog.entities.CatGenderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CatGenderRepository extends CrudRepository<CatGenderEntity, Long> {
    Set<CatGenderEntity> findAllByActiveIsTrue();


}
