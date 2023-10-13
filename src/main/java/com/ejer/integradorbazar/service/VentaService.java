package com.ejer.integradorbazar.service;

import com.ejer.integradorbazar.dto.VentaDTO;
import com.ejer.integradorbazar.model.Producto;
import com.ejer.integradorbazar.model.Venta;
import com.ejer.integradorbazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    /*Obtener la sumatoria del monto y tambien cantidad todal de ventas de un determinado dia*/
    @Override
    public double[] findVentaPorFecha(LocalDate fecha) {

        Double acum = 0.0;
        int cant = 0;

        List <Venta> listaVentas = getVentas();
        List<Producto> lista = new ArrayList<>();

        for(Venta vent : listaVentas){

            //Obtengo la lista con la fecha indicada
            if(fecha.equals(vent.getFecha_venta())){
                cant = cant + 1;
                // Obtener la lista de productos de la venta
                // y agregarla a la lista que vamos a devolver
                lista.addAll(vent.getListaProductos());

            }
        }

        for (Producto product : lista){
            acum = acum + product.getCosto();
        }

        double[] resultado = {cant, acum};

        return resultado;
    }

    @Override
    public VentaDTO ventaDTOMayor() {
        /*Primero debemos acumular la venta con sus productos para
        * obtener la venta con el monto mas alto*/

        Double mayor = 0.0;


        //Declaramos el obj. vacio
        VentaDTO ventaDTO = new VentaDTO();

        //lista de ventas
        List <Venta> listaVentas = getVentas();
        List <Producto> listaProductos = new ArrayList<>();

        //for de lista para obtener la venta mas alta
        for (Venta vent : listaVentas){
            int cont = 0;
            Double acum = 0.0;

            listaProductos.addAll(vent.getListaProductos());

            for (Producto product : listaProductos){
                cont = cont + 1;
                acum = acum + product.getCosto();
            }

            if (acum > mayor){

                ventaDTO.setCodigo_venta(vent.getCodigo_venta());
                ventaDTO.setTotal(acum);
                ventaDTO.setCantidad_productos(cont);
                ventaDTO.setNombre_cliente(vent.getUnCliente().getNombre());
                ventaDTO.setApellido_cliente(vent.getUnCliente().getApellido());

            }
        }

        return ventaDTO;
    }

}


