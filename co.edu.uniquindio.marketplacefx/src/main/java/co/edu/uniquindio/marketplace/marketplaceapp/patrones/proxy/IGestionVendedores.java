package co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;

public interface IGestionVendedores {

    boolean agregarVendedor(VendedorDto vendedorDto);

    boolean actualizarVendedor(VendedorDto vendedorDto);

    boolean eliminarVendedor(String cedula, VendedorDto vendedorDto);
}

