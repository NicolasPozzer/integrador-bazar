package com.ejer.integradorbazar.controller;

import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {


    @Autowired
    private IProductoService productServ;




    /*----ENDPOINTS----*/



    @GetMapping("/productos/traer")
    public List<Producto> getProductos(){
        //Solo devolvemos con Return
        return productServ.getProductos();
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto product){

        productServ.saveProducto(product);
        return "El auto fue creado correctamente";
    }

}


/*

            codigo_producto;
            String nombre;
            String marca;
            Double costo;
            Double cantidad_disponible;



*/