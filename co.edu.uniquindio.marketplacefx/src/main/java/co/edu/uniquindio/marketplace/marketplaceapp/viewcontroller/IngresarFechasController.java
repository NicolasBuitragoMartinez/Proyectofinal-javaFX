package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.util.List;

public class IngresarFechasController {

    @FXML
    private DatePicker fechaInicioPicker;

    @FXML
    private DatePicker fechaFinPicker;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, LocalDate> colFecha;

    @FXML
    private TableColumn<Producto, Integer> colPrecio;

    private MarketplaceObjeto marketplace;

    public void initialize() {
        // Configurar columnas de la tabla
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }

    public void setMarketplace(MarketplaceObjeto marketplace) {
        this.marketplace = marketplace;
    }

    @FXML
    private void filtrarProductos() {
        LocalDate fechaInicio = fechaInicioPicker.getValue();
        LocalDate fechaFin = fechaFinPicker.getValue();

        if (fechaInicio == null || fechaFin == null) {
            System.out.println("Por favor seleccione ambas fechas.");
            return;
        }

        List<Producto> productosFiltrados = marketplace.getListaVendedores().stream()
                .flatMap(vendedor -> vendedor.getProductosAgregados().stream())
                .filter(producto -> producto.getFechaPublicacion() != null &&
                        !producto.getFechaPublicacion().isBefore(fechaInicio) &&
                        !producto.getFechaPublicacion().isAfter(fechaFin))
                .toList();

        // Mostrar los productos filtrados en la tabla
        tablaProductos.getItems().setAll(productosFiltrados);
    }
}
