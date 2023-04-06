package com.theo.practica.controller;

import com.theo.practica.model.Cliente;
import com.theo.practica.model.Pais;
import com.theo.practica.service.impl.ClienteServiceImpl;
import com.theo.practica.service.impl.PaisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public ClienteServiceImpl clienteServ;

    @Autowired
    public PaisServiceImpl paisServ;

    @RequestMapping("/")
    public String inicio(Model model){
        List<Cliente> listaCli = clienteServ.listAll();
        List<Pais> listaPais = paisServ.listAll();

        model.addAttribute("clientes", listaCli);
        model.addAttribute("paises", listaPais);

        return "cliente";
    }

    @RequestMapping("/guardar")
    public String guardar(@Param("nombre") String nombre, @Param("fecha")Date fecha, @Param("pais") Long pais){

        Pais pa = new Pais();
        pa.setId(pais);

        Cliente cliente = new Cliente();
        cliente.setName(nombre);
        cliente.setBirth(fecha);
        cliente.setPais(pa);

        clienteServ.save(cliente);

        return "redirect:/cliente/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){

        clienteServ.deleteById(id);

        return "redirect:/cliente/";
    }

    @ResponseBody
    @RequestMapping("/buscar/{id}")
    public Cliente buscar(@PathVariable("id") Long id){
        return clienteServ.findById(id);
    }

    @RequestMapping("/editar")
    public String editar(@Param("codigoEdit") Long codigoEdit, @Param("nombreEdit") String nombreEdit, @Param("fechaEdit") Date fechaEdit, @Param("paisEdit") Long paisEdit){
        Pais pais = new Pais();
        pais.setId(paisEdit);

        Cliente cliente = new Cliente();
        cliente.setId(codigoEdit);
        cliente.setName(nombreEdit);
        cliente.setBirth(fechaEdit);
        cliente.setPais(pais);

        clienteServ.update(cliente);

        return "redirect:/cliente/";
    }

}
