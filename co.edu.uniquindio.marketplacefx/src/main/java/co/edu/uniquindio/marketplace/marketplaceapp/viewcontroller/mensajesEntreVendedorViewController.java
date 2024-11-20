package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Marketplace;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;

public class mensajesEntreVendedorViewController {
    @FXML
    private ComboBox<Vendedor> cbVendedor1;

    @FXML
    private ComboBox<Vendedor> cbVendedor2;
    @FXML
    private TextArea txtAreaMensajes;

    private MarketplaceObjeto marketplace;

    @FXML
    void VerMensajes(ActionEvent event) {
        Vendedor vendedor1 = cbVendedor1.getValue();
        Vendedor vendedor2 = cbVendedor2.getValue();

        if (vendedor1 == null || vendedor2 == null) {
            txtAreaMensajes.setText("Por favor, seleccione ambos vendedores.");
            return;
        }

        int mensajesVendedor1 = contarMensajes(vendedor1);
        int mensajesVendedor2 = contarMensajes(vendedor2);

        // Calcular el total de mensajes
        int totalMensajes = mensajesVendedor1 + mensajesVendedor2;

        // Crear el mensaje a mostrar
        String mensaje = "Mensajes entre vendedores:\n\n" +
                vendedor1.getNombre() + " ha enviado " + mensajesVendedor1 + " mensajes.\n" +
                vendedor2.getNombre() + " ha enviado " + mensajesVendedor2 + " mensajes.\n\n" +
                "Total de mensajes enviados: " + totalMensajes;

        // Mostrar el mensaje en el TextArea
        txtAreaMensajes.setText(mensaje);
    }

    private int contarMensajes(Vendedor vendedor) {
        int contador = 0;
        for (Publicacion publicacion : vendedor.getMuro().getPublicacionesActivas()) {
            contador += publicacion.getComentarios().size();  // Contamos los comentarios como mensajes
        }
        return contador;
    }


    


    // Método llamado cuando se carga la vista
    @FXML
    void initialize() {
        // Inicializar o cargar los vendedores
        marketplace = DataUtil.inicializarDatos();  // Suponiendo que aquí obtienes los datos de vendedores
        cargarVendedores();  // Llamamos a cargar los vendedores
    }

    private void cargarVendedores() {
        if (marketplace != null && marketplace.getListaVendedores() != null) {
            // Limpiar los ComboBox antes de agregar nuevos elementos
            cbVendedor1.getItems().clear();
            cbVendedor2.getItems().clear();

            // Agregar los elementos a los ComboBox
            cbVendedor1.getItems().addAll(marketplace.getListaVendedores());
            cbVendedor2.getItems().addAll(marketplace.getListaVendedores());

            // Configurar el CellFactory para mostrar el nombre del vendedor
            cbVendedor1.setCellFactory(param -> new ListCell<Vendedor>() {
                @Override
                protected void updateItem(Vendedor item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());  // Mostrar solo el nombre del vendedor
                    }
                }
            });

            cbVendedor2.setCellFactory(param -> new ListCell<Vendedor>() {
                @Override
                protected void updateItem(Vendedor item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());  // Mostrar solo el nombre del vendedor
                    }
                }
            });

            // Si deseas que también se muestre el nombre al seleccionar un elemento
            cbVendedor1.setButtonCell(new ListCell<Vendedor>() {
                @Override
                protected void updateItem(Vendedor item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            });

            cbVendedor2.setButtonCell(new ListCell<Vendedor>() {
                @Override
                protected void updateItem(Vendedor item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            });
        }
    }

    public void setMarketplace(MarketplaceObjeto marketplaceObjeto) {
    }
}
