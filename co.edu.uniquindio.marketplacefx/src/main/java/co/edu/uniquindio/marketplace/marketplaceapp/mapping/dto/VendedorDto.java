package co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;

public record VendedorDto (String nombre,
                          String apellido,
                          String cedula,
                          String direccion,
                          UsuarioDto usuario){
}
