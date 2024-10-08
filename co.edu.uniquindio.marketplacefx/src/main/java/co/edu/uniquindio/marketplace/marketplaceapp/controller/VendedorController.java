package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;

import java.util.List;

public class VendedorController {
    ModelFactory modelFactory;
    public VendedorController(){
        modelFactory = ModelFactory.getInstancia();
    }
    public List<VendedorDto> obtenerVendedores(){
        return modelFactory.obtenerVendedores();
    }
    public boolean agregarVendedor(VendedorDto vendedorDto) {return modelFactory.agregarVendedor(vendedorDto);}
    public boolean eliminarVendedor(VendedorDto vendedorDto) {return modelFactory.eliminarVendedor(vendedorDto);}
    public boolean actualizarVendedor(VendedorDto vendedorDto) {return modelFactory.actualizarVendedor(vendedorDto);}
}
