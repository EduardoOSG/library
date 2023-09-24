package com.uam.microservices.catalog.controllers;

import com.uam.microservices.catalog.dtos.IdentityNameDTO;
import com.uam.microservices.catalog.services.ICatEstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estates")
public class CatEstatusController {

    @Autowired
    private ICatEstatusService catEstatusService;

    @GetMapping("{id}")
    public ResponseEntity<IdentityNameDTO> getById(@PathVariable("id") Long estateId) {

        return new ResponseEntity<>(catEstatusService.getById(estateId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<IdentityNameDTO>> getAll() {

        return new ResponseEntity<>(catEstatusService.getAll(), HttpStatus.OK);
    }

}
