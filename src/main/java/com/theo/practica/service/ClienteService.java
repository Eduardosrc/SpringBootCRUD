package com.theo.practica.service;

import com.theo.practica.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listAll();

    Cliente findById(Long id);

    void save(Cliente cliente);

    void update(Cliente cliente);

    void deleteById(Long id);

}
