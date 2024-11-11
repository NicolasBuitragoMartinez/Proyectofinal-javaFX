package co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;

import javafx.scene.image.Image;

public record ProductoDto(String nombre,
                          String identificador,
                          Image imagen,
                          String categoria,
                          int precio,
                          EstadoProducto estado) {
}
