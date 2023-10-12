package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    /*Primordial la Inyeccion de Dependencia*/
    @Autowired
    private IProductoRepository productRepo;
    /*--------------------------------------*/



    @Override
    public List<Producto> getProductos() {

        List<Producto> listaProductos = productRepo.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto product) {
        productRepo.save(product);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {

        Producto product = productRepo.findById(codigo_producto).orElse(null);
        return product;
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productRepo.deleteById(codigo_producto);
    }

    /*@Override
    public void editProducto(Long codigo_producto, String nuevoNombre,
                             String nuevaMarca, Double nuevoCosto,
                             Double nuevaCantidad_Disponible) {

        //codigo

        *//*Primero obtenemos los datos actuales del obj.*//*
        Producto product = this.findProducto(codigo_producto);
        *//*Producto viene -> con los valores originales desde la db*//*

        //Entonces ahora seteamos los nuevos parametros a modificar
        product.setNombre(nuevoNombre);
        product.setMarca(nuevaMarca);
        product.setCosto(nuevoCosto);
        product.setCantidad_disponible(nuevaCantidad_Disponible);

        *//*Ahora pasamos los nuevos datos a la db guardandolos de
        * la siguiente manera: *//*
        this.saveProducto(product); //Recibe "ESTE" obj. y lo manda a la db.


    }*/

    @Override
    public void editProducto(Producto product) {


        this.saveProducto(product);
    }



}
