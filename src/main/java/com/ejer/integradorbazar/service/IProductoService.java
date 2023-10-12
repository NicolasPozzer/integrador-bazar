package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.model.Producto;

import java.util.List;

public interface IProductoService {

    /*==============================================================
    *           Declaramos todos los metodos CRUD Abstactos
    *           ya que es una interfaz y Siempre van
    *           metodos abstractos!
    ================================================================*/

    /*Lista de Productos*/
    public List<Producto> getProductos();

    /*Alta*/
    public void saveProducto(Producto product);


    /*Lectura de un solo Producto*/
    public Producto findProducto(Long codigo_producto);


    /*Eliminar un Producto*/
    public void deleteProducto(Long codigo_producto);


    /*Edicion/Modificacion*/
    /*public void editProducto(Long codigo_producto, String nuevoNombre,
                             String nuevaMarca, Double nuevoCosto,
                             Double nuevaCantidad_Disponible);*/



    public void editProducto(Producto produ);
}
