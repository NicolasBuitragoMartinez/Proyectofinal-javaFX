package co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;

public class ProductoBase extends Producto {
    private String descripcion;
    private double precio;

    public ProductoBase(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getDetalles() {
        return "";
    }

    @Override
    public int getPrecio() {
        return (int) precio;
    }
}

