package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Venta;
import com.ejer.integradorbazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
