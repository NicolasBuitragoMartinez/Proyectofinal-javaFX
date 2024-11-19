package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.ComentarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.PublicacionDto;

import java.util.List;

public class PublicacionController {
    ModelFactory modelFactory;
    public PublicacionController(){modelFactory = ModelFactory.getInstancia();}
    public int obtenerLikesPublicaciones(String identificadorProducto){return modelFactory.obtenerLikesPublicacion(identificadorProducto);}
    public List<ComentarioDto> obtenerComentariosPublicaciones(String identificadorProducto){return modelFactory.obtenerComentariosPublicacion(identificadorProducto);}
    public boolean incrementarLikesPublicaciones(String identificadorProducto){return modelFactory.incrementarLikesPublicacion(identificadorProducto);}
}
