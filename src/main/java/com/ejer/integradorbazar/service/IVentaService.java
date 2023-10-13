package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas(); // Mostrar Todos

    public void saveVenta(Venta vent); // Alta

    public void deleteVenta(Long id); // Baja

    public Venta findVenta(Long id); // Buscar uno

    public void editVenta(Venta vent); // Editar/Modificar

    public List<Producto> productosPorVenta(Long id);

    public double[] findVentaPorFecha(LocalDate fecha);


}
