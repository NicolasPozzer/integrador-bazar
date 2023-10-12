package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes(); /* -> Mostrar lista Clientes */

    public void saveCliente(Cliente client); /* -> Alta */

    public void deleteCliente(Long id); /* -> Baja */

    public Cliente findCliente(Long id); /* -> Buscar Uno */

    public void editCliente(Cliente client); /* -> Editar Uno */


}
