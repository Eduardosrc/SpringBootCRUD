package com.theo.practica.service.impl;

import com.theo.practica.model.Cliente;
import com.theo.practica.repository.ClienteRepository;
import com.theo.practica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    public ClienteRepository clienteRepo;

    @Override
    public List<Cliente> listAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepo.findById(id).orElseThrow(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepo.deleteById(id);
    }
}
