package com.theo.practica.service.impl;

import com.theo.practica.model.Pais;
import com.theo.practica.repository.PaisRepository;
import com.theo.practica.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    public PaisRepository paisRepo;

    @Override
    public List<Pais> listAll() {
        return paisRepo.findAll();
    }
}
