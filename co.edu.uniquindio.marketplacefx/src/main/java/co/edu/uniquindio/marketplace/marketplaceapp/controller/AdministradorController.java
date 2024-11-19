package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.patrones.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;

public class AdministradorController {
    ModelFactory modelFactory;
    public AdministradorController(){modelFactory = ModelFactory.getInstancia();}
    public boolean agregarVendedor(VendedorDto vendedorDto) {return modelFactory.agregarVendedor(vendedorDto);}
    public boolean eliminarVendedor(VendedorDto vendedorDto) {return modelFactory.eliminarVendedor(vendedorDto);}
}
