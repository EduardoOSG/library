package com.uam.microservices.catalog.services.impl;

import com.uam.microservices.catalog.dtos.IdentityNameDTO;
import com.uam.microservices.catalog.entities.CatEstatusEntity;
import com.uam.microservices.catalog.exceptions.GenericException;
import com.uam.microservices.catalog.repositories.CatEstatusRepository;
import com.uam.microservices.catalog.services.ICatEstatusService;
import com.uam.microservices.catalog.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CatEstatusService implements ICatEstatusService {

    @Autowired
    private CatEstatusRepository catEstatusRepository;

    @Override
    public IdentityNameDTO getById(Long id){

        return buildIdentityNameDTO(getCatEstatusEntity(id));

    }

    @Override
    public List<IdentityNameDTO> getAll(){

        return  catEstatusRepository.findAllByActiveIsTrue().stream()
                .map(this::buildIdentityNameDTO).collect(Collectors.toList());

    }

    private IdentityNameDTO buildIdentityNameDTO(CatEstatusEntity estatusEntity){

        return IdentityNameDTO.builder()
                .id(estatusEntity.getId())
                .name(estatusEntity.getName())
                .build();

    }

    private CatEstatusEntity getCatEstatusEntity(Long estatusId){

        if (estatusId == null || estatusId <= 0 ){

            throw new GenericException(String.format(Constants.MENSSAGE_ERROR_REQUIRED, "employeeId"));

        }

        return catEstatusRepository.findById(estatusId).orElseThrow(()
                -> new NoSuchElementException(String.format(Constants.MENSSAGE_ERROR_NOT_EXIST, "of catalog")));
    }


}
