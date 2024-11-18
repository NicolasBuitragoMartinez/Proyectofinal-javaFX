package co.edu.uniquindio.marketplace.marketplaceapp.patrones.facade;


import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.strategy.TransaccionAliadosDirectos;

public class MarketplaceFacade {


    private Vendedor vendedor;
    private Usuario autenticacion;
    private TransaccionAliadosDirectos IStrategyTransaccion;

    public MarketplaceFacade() {

        this.vendedor = new Vendedor();
        this.autenticacion = new Usuario();
    }

    public void setEstrategiaTransaccion(TransaccionAliadosDirectos IStrategyTransaccion) {
        this.IStrategyTransaccion = IStrategyTransaccion;
    }

    public void registrarVendedor(String nombre, String apellido, String cedula,
                                  String direccion, String usuario, String contrasena) {
    }



    public void agregarProducto(String usuario, Producto producto) {

        Vendedor vendedor = buscarVendedor(usuario);

        if (vendedor != null) {
            vendedor.getProductos().add(producto);
        }
    }

    private Vendedor buscarVendedor(String usuario) {
        return null;
    }

    public Vendedor agregarAliado(String usuario1, String usuario2) {

        Vendedor vendedor1 = buscarVendedor(usuario1);
        Vendedor vendedor2 = buscarVendedor(usuario2);

        if (vendedor1 != null && vendedor2 != null) {
            vendedor1.agregarAliado(vendedor2);
        }

        return vendedor1;
    }

    public boolean realizarTransaccion(String usuarioVendedor, String usuarioComprador, Producto producto) {

        Vendedor vendedor = buscarVendedor(usuarioVendedor);
        Vendedor comprador = buscarVendedor(usuarioComprador);

        if (vendedor != null && comprador != null && IStrategyTransaccion != null) {

        }
        return IStrategyTransaccion.transaccionar(comprador, vendedor, producto);

    }

    public boolean autenticar(String usuario, String contrasena) {
        return false;
    }
}