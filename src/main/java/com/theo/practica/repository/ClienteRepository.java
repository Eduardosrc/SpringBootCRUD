package com.theo.practica.repository;

import com.theo.practica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "select c from Cliente c where c.pais.id = 1")
    List<Cliente> clientesDePeru();

    @Query(value = "select c from Cliente c where c.pais.id = 2")
    List<Cliente> clientesDeVenezuela();

}
