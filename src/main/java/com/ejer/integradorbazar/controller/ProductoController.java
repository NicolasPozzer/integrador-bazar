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

    @GetMapping("/productos/traeruno/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){

        return productServ.findProducto(codigo_producto);
    }


    @DeleteMapping("/productos/borrar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productServ.deleteProducto(codigo_producto);
        return "El producto fue eliminado correctamente";
    }

    /*@PutMapping ("/productos/editar/{codigo_producto}")*//*requiered es si necesita!
    osea si hay un cambio de id va a mostrar por la url*//*
    public Producto editProducto(@PathVariable Long codigo_producto,
                               @RequestParam(required = false,
                                       name = "nombre")String nuevoNombre,
                               @RequestParam(required = false,
                                       name = "marca")String nuevaMarca,
                               @RequestParam(required = false,
                                       name = "costo")Double nuevoCosto,
                               @RequestParam(required = false,
                                       name = "cantidad_disponible")Double nuevaCantidad_Disponible){

        productServ.editProducto(codigo_producto,nuevoNombre,
                nuevaMarca, nuevoCosto, nuevaCantidad_Disponible);

        Producto product = productServ.findProducto(codigo_producto);
        return product;
    }*/


    @PutMapping("/productos/edit")
    public String editProducto(@RequestBody Producto product) {
        productServ.editProducto(product);
        return "Curso editado correctamente";
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> menor_a_5(){
        return productServ.menor_a_5();
    }

}
