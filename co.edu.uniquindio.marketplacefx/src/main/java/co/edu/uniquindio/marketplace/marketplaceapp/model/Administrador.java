package co.edu.uniquindio.marketplace.marketplaceapp.model;

import co.edu.uniquindio.marketplace.marketplaceapp.patrones.builder.AdministradorBuilder;

public class Administrador extends Persona{
    public Administrador(String nombre,
                         String apellido,
                         String cedula,
                         String direccion,
                         Usuario usuario){
        super(nombre, apellido, cedula, direccion, usuario);
    }
    public Administrador(){}
    public static AdministradorBuilder builder(){return new AdministradorBuilder();}
}
