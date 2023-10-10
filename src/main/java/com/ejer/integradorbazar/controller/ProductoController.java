package com.ejer.integradorbazar.controller;

import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    /*Inyectamos dependencia*/
    /* -Osea inyectamos el service para poder utilizar los metodos
    * de la logica del service y colocar en nuestros endpoints*/
    @Autowired
    private IProductoService productServ;




            /*----ENDPOINTS----*/

    @PostMapping     ("/productos/crear")
    public String saveProducto(@RequestBody Producto product){

        productServ.saveProducto(product);
        return "El auto fue creado correctamente";
    }

    @GetMapping     ("/productos/traer")
    public List<Producto> getProductos(){
        //Solo devolvemos con Return
        return productServ.getProductos();
    }

    @GetMapping     ("/productos/traer/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){

        return productServ.findProducto(codigo_producto);
    }

}


/*

            codigo_producto;
            String nombre;
            String marca;
            Double costo;
            Double cantidad_disponible;



*/