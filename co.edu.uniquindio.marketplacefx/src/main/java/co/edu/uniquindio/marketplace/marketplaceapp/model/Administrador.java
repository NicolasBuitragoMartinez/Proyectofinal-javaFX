package co.edu.uniquindio.marketplace.marketplaceapp.model;

public class Administrador extends Persona{
    public Administrador(String nombre,
                         String apellido,
                         String cedula,
                         String direccion,
                         Usuario usuario){
        super(nombre, apellido, cedula, direccion, usuario);
    }
    public Administrador(){}
}
