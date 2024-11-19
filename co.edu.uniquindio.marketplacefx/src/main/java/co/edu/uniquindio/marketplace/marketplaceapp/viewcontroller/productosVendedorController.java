package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class productosVendedorController {

    @FXML
    private ComboBox<Vendedor> comboBoxVendedores;

    @FXML
    private Button btnMostrarProductos;
    @FXML
    private TextArea textAreaResultado;

    private MarketplaceObjeto marketplace; // Recibido desde la clase principal

    public void setMarketplace(MarketplaceObjeto marketplace) {
        this.marketplace = marketplace;
        initializeComboBox();
    }

    @FXML
    private void onActionProductosPorVendedor() {
        Vendedor vendedorSeleccionado = comboBoxVendedores.getSelectionModel().getSelectedItem();

        if (vendedorSeleccionado == null) {
            textAreaResultado.setText("Por favor, selecciona un vendedor.");
            return;
        }

        // Obtener la cantidad de productos publicados por el vendedor
        int cantidadProductos = vendedorSeleccionado.getProductosAgregados().size();

        // Mostrar el resultado en el TextArea
        textAreaResultado.setText(
                "Vendedor: " + vendedorSeleccionado.getNombre() + "\n" +
                        "Cantidad de productos publicados: " + cantidadProductos
        );
    }

    private void initializeComboBox() {
        if (marketplace != null) {
            comboBoxVendedores.getItems().addAll(marketplace.getListaVendedores());
            comboBoxVendedores.setCellFactory(lv -> new ListCell<>() {
                @Override
                protected void updateItem(Vendedor vendedor, boolean empty) {
                    super.updateItem(vendedor, empty);
                    setText(empty ? null : vendedor.getNombre());
                }
            });
            comboBoxVendedores.setButtonCell(new ListCell<>() {
                @Override
                protected void updateItem(Vendedor vendedor, boolean empty) {
                    super.updateItem(vendedor, empty);
                    setText(empty ? null : vendedor.getNombre());
                }
            });
        }
    }
}
