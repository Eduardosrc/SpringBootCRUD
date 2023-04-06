package com.theo.practica;

import com.theo.practica.model.Cliente;
import com.theo.practica.repository.ClienteRepository;
import com.theo.practica.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PracticaApplicationTests {

	@Autowired
	public ClienteServiceImpl clienteServ;

	@Autowired
	public ClienteRepository repo;

	@Test
	void list() {
		List<Cliente> lista = repo.clientesDeVenezuela();

		for(Cliente cli : lista){
			System.out.println(cli.getName() + "-" + cli.getBirth() + "-" + cli.getPais().getName());
		}
	}

}
