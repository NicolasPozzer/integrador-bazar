package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Producto;

import java.util.List;

public interface IProductoService {


    /*Alta*/
    public void saveProducto(Producto product);


    /*Lista de Productos*/
    public List<Producto> getProductos();


    /*Lectura de un solo Producto*/
    public Producto findProducto(Long id);


    /*Eliminar un Producto*/
    public void deleteProducto(Long id);


    /*Edicion/Modificacion*/
    public void editProducto(Long id, String nuevoNombre,
                             String nuevaMarca, Double nuevoCosto,
                             Double nuevaCantidad_Disponible);



}
