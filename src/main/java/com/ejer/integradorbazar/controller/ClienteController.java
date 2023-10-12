package com.ejer.integradorbazar.controller;

import com.ejer.integradorbazar.model.Cliente;
import com.ejer.integradorbazar.repository.IClienteRepository;
import com.ejer.integradorbazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    /*1ero Dependencia
    * Para manipular los datos del service*/
    @Autowired
    private IClienteService clientServ;


/*
        | |  End Points  | |
        | |              | |
        v v              v v
*/
    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes(){
        return clientServ.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente client){

        clientServ.saveCliente(client);
        return "El Cliente fue |Agregado| Correctamente!!!";
    }

    @DeleteMapping("/clientes/borrar/{id}")
    public String deleteCliente(@PathVariable Long id){
        clientServ.deleteCliente(id);

        return "Cliente |Eliminado| Correctamente!";
    }

    @GetMapping("/clientes/uncliente/{id}")
    public Cliente findCliente(@PathVariable Long id){
        return clientServ.findCliente(id);
    }

    @PutMapping("/clientes/edit")
    public String editCliente(@RequestBody Cliente client){
        clientServ.editCliente(client);

        return "Cliente |Editado| con Exito!";
    }


}
