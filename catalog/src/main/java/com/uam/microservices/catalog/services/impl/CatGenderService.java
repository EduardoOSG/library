package com.uam.microservices.catalog.services.impl;

import com.uam.microservices.catalog.dtos.IdentityNameDTO;
import com.uam.microservices.catalog.entities.CatGenderEntity;
import com.uam.microservices.catalog.exceptions.GenericException;
import com.uam.microservices.catalog.repositories.CatGenderRepository;
import com.uam.microservices.catalog.services.ICatGenderService;
import com.uam.microservices.catalog.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CatGenderService implements ICatGenderService {

    @Autowired
    private CatGenderRepository catGenderRepository;

    @Override
    public IdentityNameDTO getById(Long id){

        return buildIdentityNameDTO(getCatGenderEntity(id));

    }

    @Override
    public List<IdentityNameDTO> getAll(){

        return  catGenderRepository.findAllByActiveIsTrue().stream()
                .map(this::buildIdentityNameDTO).collect(Collectors.toList());

    }

    private IdentityNameDTO buildIdentityNameDTO(CatGenderEntity estatusEntity){

        return IdentityNameDTO.builder()
                .id(estatusEntity.getId())
                .name(estatusEntity.getName())
                .build();

    }

    private CatGenderEntity getCatGenderEntity(Long estatusId){

        if (estatusId == null || estatusId <= 0 ){

            throw new GenericException(String.format(Constants.MENSSAGE_ERROR_REQUIRED, "employeeId"));

        }

        return catGenderRepository.findById(estatusId).orElseThrow(()
                -> new NoSuchElementException(String.format(Constants.MENSSAGE_ERROR_NOT_EXIST, "of catalog")));
    }
}
