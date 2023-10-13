package com.ejer.integradorbazar.controller;

import com.ejer.integradorbazar.dto.VentaDTO;
import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.model.Venta;
import com.ejer.integradorbazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    /*Dependencia*/
    @Autowired
    private IVentaService ventaServ;


    /*  |End Points|  */

    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){

        return ventaServ.getVentas();
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta vent){

        ventaServ.saveVenta(vent);
        return "Venta |Agregada| Corectamente!";
    }

    @DeleteMapping("/ventas/borrar/{id}")
    public String deleteVenta(@PathVariable Long id){

        ventaServ.deleteVenta(id);
        return "Venta |Eliminada| Correctamente!";
    }

    @GetMapping("/ventas/traeruno/{id}")
    public Venta findVenta(@PathVariable Long id){

        return ventaServ.findVenta(id);
    }

    @PutMapping("/ventas/edit")
    public String editVenta(@RequestBody Venta vent){

        ventaServ.editVenta(vent);
        return "Venta |Editada| correctamente";
    }

    @GetMapping ("/ventas/productos-x-venta/{id}")
    public List<Producto> productosPorVenta (@PathVariable Long id) {
        return ventaServ.productosPorVenta(id);

    }

    @GetMapping ("/ventas/fecha/{fecha_venta}")
    public double[] findVentaPorFecha(@PathVariable LocalDate fecha_venta){
        return ventaServ.findVentaPorFecha(fecha_venta);
    }

    @GetMapping ("/ventas/mayor")
    public VentaDTO ventaDTOMayor(){
        return ventaServ.ventaDTOMayor();
    }

}
