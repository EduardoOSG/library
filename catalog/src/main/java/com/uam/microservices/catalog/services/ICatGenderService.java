package com.uam.microservices.catalog.services;

import com.uam.microservices.catalog.dtos.IdentityNameDTO;

import java.util.List;

public interface ICatGenderService {
    IdentityNameDTO getById(Long id);

    List<IdentityNameDTO> getAll();
}
