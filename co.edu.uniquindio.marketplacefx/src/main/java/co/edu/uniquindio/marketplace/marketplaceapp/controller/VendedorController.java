package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.patrones.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy.IGestionVendedores;

import java.util.List;

public class VendedorController implements IGestionVendedores {
    ModelFactory modelFactory;
    public VendedorController(){
        modelFactory = ModelFactory.getInstancia();
    }
    public List<VendedorDto> obtenerVendedores(){
        return modelFactory.obtenerVendedores();
    }
    public VendedorDto obtenerVendedorPorCedula(String cedula) {return modelFactory.obtenerVendedores(cedula);}
    public boolean agregarVendedor(VendedorDto vendedorDto) {return modelFactory.agregarVendedor(vendedorDto);}
    public boolean eliminarVendedor(String cedula, VendedorDto vendedorDto) {return modelFactory.eliminarVendedor(vendedorDto);}
    public boolean actualizarVendedor(VendedorDto vendedorDto) {return modelFactory.actualizarVendedor(vendedorDto);}


}
