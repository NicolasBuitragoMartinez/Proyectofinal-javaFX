package co.edu.uniquindio.marketplace.marketplaceapp.model;

import java.util.List;
import java.util.ArrayList;

public class Muro {
    private List<Publicacion> publicacionesActivas;
    private List<Mensaje> mensajesEnviados;
    public Muro(){
        this.publicacionesActivas = new ArrayList<>();
        this.mensajesEnviados = new ArrayList<>();
    }
    public List<Publicacion> getPublicacionesActivas(){return publicacionesActivas;}
    public List<Mensaje> getMensajesEnviados(){return mensajesEnviados;}
    public void setPublicacionesActivas(List<Publicacion> publicacionesActivas){
        this.publicacionesActivas = publicacionesActivas;
    }
    public void setMensajesEnviados(List<Mensaje> mensajesEnviados){
        this.mensajesEnviados = mensajesEnviados;
    }
}
