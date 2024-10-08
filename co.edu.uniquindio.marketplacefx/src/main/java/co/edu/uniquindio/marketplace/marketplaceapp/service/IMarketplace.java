package co.edu.uniquindio.marketplace.marketplaceapp.service;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

import java.util.List;

public interface IMarketplace {
    boolean crearVendedor(String nombre, String apellido, String cedula, String direccion);
    void eliminarVendedor(String cedula);
    List<Vendedor> obtenerVendedor();
    Vendedor obtenerVendedor(String cedula);
    void mostrarInformacionVendedor();
    void buscarVendedor(String cedula);
    boolean actualizarVendedor(String cedulaActual, String nombre, String apellido, String cedula, String direccion);
}
