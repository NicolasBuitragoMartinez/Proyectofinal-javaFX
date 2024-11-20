package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class ProductosPublicadosFechasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker datePickerFin;

    @FXML
    private DatePicker datePickerInicio;

    @FXML
    private TextArea textAreaProductos;
    private MarketplaceObjeto marketplace;
    public void setMarketplace(MarketplaceObjeto marketplace) {
        this.marketplace=marketplace;
    }



        @FXML
        void onBuscarProductosEntreFechas(ActionEvent event) {

        MarketplaceObjeto marketplace = DataUtil.inicializarDatos();

        // Obtener las fechas seleccionadas en los DatePicker
        LocalDate fechaInicio = datePickerInicio.getValue();
        LocalDate fechaFin = datePickerFin.getValue();

        // Validar que ambas fechas hayan sido seleccionadas
        if (fechaInicio == null || fechaFin == null) {
            textAreaProductos.setText("Por favor, selecciona ambas fechas.");
            return;
        }

        System.out.println("Fecha inicio seleccionada: " + fechaInicio);
        System.out.println("Fecha fin seleccionada: " + fechaFin);

            List<Producto> productosFiltrados = marketplace.getListaVendedores().stream()
                    .flatMap(vendedor -> vendedor.getProductosAgregados().stream())
                    .filter(producto -> producto.getFechaPublicacion() != null &&
                            !producto.getFechaPublicacion().isBefore(fechaInicio) &&
                            !producto.getFechaPublicacion().isAfter(fechaFin))
                    .collect(Collectors.toList());

            // Mostrar resultados o mensaje si no hay productos en el rango
            if (productosFiltrados.isEmpty()) {
                textAreaProductos.setText("No se encontraron productos publicados entre las fechas seleccionadas.");
            } else {
                StringBuilder resultados = new StringBuilder();
                productosFiltrados.forEach(producto -> resultados.append("Producto: ")
                        .append(producto.getNombre())
                        .append(", Fecha: ")
                        .append(producto.getFechaPublicacion())
                        .append("\n"));
                textAreaProductos.setText(resultados.toString());
            }

    }}