package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.model.Venta;
import com.ejer.integradorbazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VentaService implements IVentaService{

    /*Dependencia*/
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas;
    }

    @Override
    public void saveVenta(Venta vent) {
        ventaRepo.save(vent);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta vent = ventaRepo.findById(id).orElse(null);
        return vent;
    }

    @Override
    public void editVenta(Venta vent) {
        this.saveVenta(vent);
    }

    @Override
    public List<Producto> productosPorVenta(Long id) {
        List<Producto> lista = new ArrayList<>();

        Venta vent = this.findVenta(id); // Obtener la venta por el ID proporcionado

        if (vent != null) {
            // Obtener la lista de productos de la venta y agregarla a la lista que vamos a devolver
            lista.addAll(vent.getListaProductos());
        } else {
            // Manejar el caso cuando la venta no se encuentra (puedes lanzar una excepción o devolver una lista vacía, dependiendo de tus requisitos)
            System.out.println(("Venta no encontrada con el ID: " + id));
        }

        return lista;
    }


}
