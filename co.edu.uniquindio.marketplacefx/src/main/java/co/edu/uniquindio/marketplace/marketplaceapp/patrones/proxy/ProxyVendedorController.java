package co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy;

import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;

public class ProxyVendedorController {
    private final VendedorController vendedorController;
    private final String rolUsuario;

    public ProxyVendedorController(String rolUsuario) {
        this.vendedorController = new VendedorController();
        this.rolUsuario = rolUsuario;
    }

    public void eliminarVendedor(String cedula, VendedorDto vendedorDto) {
        if (!"ADMIN".equalsIgnoreCase(rolUsuario)) {
            throw new SecurityException("No tiene permisos para eliminar vendedores.");
        }
        vendedorController.eliminarVendedor(cedula, vendedorDto);
    }

    public void agregarVendedor(VendedorDto vendedor) {
        if (!"ADMIN".equalsIgnoreCase(rolUsuario)) {
            throw new SecurityException("No tiene permisos para agregar vendedores.");
        }
        vendedorController.agregarVendedor(vendedor);
    }
}


