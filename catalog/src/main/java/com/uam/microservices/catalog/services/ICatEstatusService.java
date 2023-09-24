package com.uam.microservices.catalog.services;

import com.uam.microservices.catalog.dtos.IdentityNameDTO;

import java.util.List;

public interface ICatEstatusService {
    IdentityNameDTO getById(Long Id);

    List<IdentityNameDTO> getAll();
}
