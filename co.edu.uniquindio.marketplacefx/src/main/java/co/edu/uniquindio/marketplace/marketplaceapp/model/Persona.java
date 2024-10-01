package co.edu.uniquindio.marketplace.marketplaceapp.model;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected Usuario usuario;
    public Persona(String nombre,
                   String apellido,
                   String cedula,
                   String direccion,
                   Usuario usuario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
    }
    public Persona(){}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getCedula(){return cedula;}
    public String getDireccion(){return direccion;}
    public Usuario getUsuario(){return usuario;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setCedula(String cedula){this.cedula = cedula;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
