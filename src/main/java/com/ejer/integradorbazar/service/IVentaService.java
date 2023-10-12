package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas(); // Mostrar Todos

    public void saveVenta(Venta vent); // Alta

    public void deleteVenta(Long id); // Baja

    public Venta findVenta(Long id); // Buscar uno

    public void editVenta(Venta vent); // Editar/Modificar

}
