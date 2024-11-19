package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.marketplace.marketplaceapp.controller.AdministradorController;
import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.*;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;


public class AdministradorViewController {

    VendedorController vendedorController;
    ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    VendedorDto vendedorSeleccionado;
    private MarketplaceAppController marketplaceAppController;
    private AdministradorController administradorController;

    public void setMarketplaceAppController(MarketplaceAppController marketplaceAppController){
        this.marketplaceAppController = marketplaceAppController;
        inicializarVista();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarVendedor;

    @FXML
    private Button btnAgregarVendedor;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private Button btnNuevoVendedor;

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private Button btnExportarEstadisticas;

    @FXML
    private RadioButton rbCantidadProductosVendedor;

    @FXML
    private RadioButton rbContactosXVendedor;

    @FXML
    private RadioButton rbMensajes2Vendedores;

    @FXML
    private RadioButton rbProductosXFecha;

    @FXML
    private RadioButton rbTopProductosLike;

    private ToggleGroup toggleGroup;

    @FXML
    private TableView<VendedorDto> tableVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcApellido;

    @FXML
    private TableColumn<VendedorDto, String> tcCedula;

    @FXML
    private TableColumn<VendedorDto, String> tcDireccion;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

    @FXML
    private ToggleGroup tgSolicitud;

    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        initView();
    }

    @FXML
    void onExportarReporte(ActionEvent event) {

        MarketplaceObjeto marketplace = DataUtil.inicializarDatos();
        String rutaArchivo = "estadisticas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write("Estadísticas del Marketplace\n");
            writer.write("Número de Vendedores: " + marketplace.getListaVendedores().size() + "\n");
            writer.write("Productos Publicados:\n");

            for (Vendedor vendedor : marketplace.getListaVendedores()) {
                for (Producto producto : vendedor.getProductosAgregados()) {
                    writer.write("- " + producto.getNombre() + " (" + producto.getEstado() + ")\n");
                }
            }

            System.out.println("Archivo exportado en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML
    void onActionMensajesEntreVendedores(ActionEvent event) {
        manejarMensajesEntreVendedores();
    }

    private void manejarMensajesEntreVendedores() {

    }

    @FXML
    void onActionProductosEntreFechas(ActionEvent event) {
        manejarProductosEntreFechas();
    }


    private void manejarProductosEntreFechas() {
        MarketplaceObjeto marketplace = DataUtil.inicializarDatos();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/ProductosPublicadosFechas.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el marketplace
            ProductosPublicadosFechasViewController controller = loader.getController();
            controller.setMarketplace(marketplace);

            // Crear una nueva escena
            Stage stage = new Stage();
            stage.setTitle("Productos Entre Fechas");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionProductosPorVendedor(ActionEvent event) {
        MarketplaceObjeto marketplace= DataUtil.inicializarDatos();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/ProductosPorVendedor.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el marketplace
            productosVendedorController controller = loader.getController();
            controller.setMarketplace(marketplace);

            // Crear una nueva escena
            Stage stage = new Stage();
            stage.setTitle("Productos por Vendedor");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    void onActionContactosPorVendedor(ActionEvent event) {
        manejarContactosPorVendedor(); // Implementar si es necesario
    }

    private void manejarContactosPorVendedor() {
        
    }

    @FXML
    void onActionTopProductosLikes(ActionEvent event) {
        manejarTopProductosLike();
    }

    private void manejarTopProductosLike() {
        MarketplaceObjeto marketplace = DataUtil.inicializarDatos();

        List<Publicacion> publicacionesTop = marketplace.getListaVendedores().stream()
                .flatMap(vendedor -> vendedor.getMuro().getPublicacionesActivas().stream())
                .sorted((p1, p2) -> Integer.compare(p2.getLike(), p1.getLike())) // Descendente
                .limit(10) // Mostrar los 10 mejores
                .collect(Collectors.toList());

        publicacionesTop.forEach(pub -> System.out.println(
                "Producto: " + pub.getProducto().getNombre() + ", Likes: " + pub.getLike()
        ));
    }













    @FXML
    void onActualizarVendedor(ActionEvent event) {
        actualizarVendedor();
    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {
        eliminarVendedor();
    }

    @FXML
    void onNuevoVendedor(ActionEvent event) {
        limpiarCampos();
    }

    private void initView() {
        initDataBinding();
        obtenerVendedor();
        configurarMarketplace();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
        listenerSelection();
        toggleGroup = new ToggleGroup();
        rbCantidadProductosVendedor.setToggleGroup(toggleGroup);
        rbContactosXVendedor.setToggleGroup(toggleGroup);
        rbMensajes2Vendedores.setToggleGroup(toggleGroup);
        rbProductosXFecha.setToggleGroup(toggleGroup);
        rbTopProductosLike.setToggleGroup(toggleGroup);
        limpiarCampos();
    }

    public void obtenerVendedor() {
        listaVendedores.addAll(vendedorController.obtenerVendedores());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
    }

    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });
    }

    private void actualizarVendedor(){
        VendedorDto vendedorDto = actualizarVendedorDto();
        if(datosValidos(vendedorDto)){
            if(vendedorController.actualizarVendedor(vendedorDto)){
                int index = listaVendedores.indexOf(vendedorSeleccionado);
                listaVendedores.set(index, vendedorDto);
                limpiarCampos();
                mostrarMensaje(TITULO_VENDEDOR_ACTUALIZADO, HEADER, BODI_VENDEDOR_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_NO_ACTUALIZADO, HEADER, BODI_VENDEDOR_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void agregarVendedor() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String correo = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        UsuarioDto usuarioDto = new UsuarioDto(correo, contraseña);

        if (nombre != null && !nombre.isEmpty() && cedula != null && !cedula.isEmpty() &&
                direccion != null && !direccion.isEmpty()) {

            VendedorDto vendedorDto = new VendedorDto(nombre, apellido, cedula, direccion, usuarioDto);

            if (vendedorController.agregarVendedor(vendedorDto)) {
                marketplaceAppController.agregarTabVendedor(cedula);
                listaVendedores.add(vendedorDto);
                limpiarCampos();
                mostrarMensaje(TITULO_VENDEDOR_AGREGADO, HEADER, BODI_VENDEDOR_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_NO_AGREGADO, HEADER, BODI_VENDEDOR_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void eliminarVendedor() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String correo = txtUsuario.getText();
        String contraseña = txtContraseña.getText();

        UsuarioDto usuarioDto = new UsuarioDto(correo, contraseña);


        if (cedula != null && !cedula.isEmpty()) {
            VendedorDto vendedorDto = new VendedorDto(nombre, apellido, cedula, direccion, usuarioDto);

            if (vendedorController.eliminarVendedor(cedula, vendedorDto)) {
                marketplaceAppController.eliminarTabVendedor(cedula);
                listaVendedores.remove(vendedorSeleccionado);
                limpiarCampos();
                mostrarMensaje(TITULO_VENDEDOR_ELIMINADO, HEADER, BODI_VENDEDOR_ELIMINADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_NO_ELIMINADO, HEADER, BODI_VENDEDOR_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void configurarMarketplace() {
        Platform.runLater(() -> {
            if (marketplaceAppController != null) {
                inicializarVista();
            }
        });
    }

    private void inicializarVista() {
        if (vendedorController == null) {
            vendedorController = new VendedorController();
        }
        marketplaceAppController.crearTabsParaVendedoresExistentes(vendedorController);

    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtNombre.setPromptText("Ingrese el nombre...");
        txtApellido.setText("");
        txtApellido.setPromptText("Ingrese el apellido...");
        txtCedula.setText("");
        txtCedula.setPromptText("Ingrese la cédula...");
        txtDireccion.setText("");
        txtDireccion.setPromptText("Ingrese la dirección...");
        txtUsuario.setText("");
        txtUsuario.setPromptText("Ingrese el usuario...");
        txtContraseña.setText("");
        txtContraseña.setPromptText("Ingrese la contraseña...");
    }

    private VendedorDto actualizarVendedorDto(){
        return new VendedorDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtDireccion.getText(),
                new UsuarioDto(
                        txtUsuario.getText(),
                        txtContraseña.getText()
                )
        );
    }

    private VendedorDto crearVendedorDto() {
        UsuarioDto usuarioDto = new UsuarioDto(
                txtUsuario.getText(),
                txtContraseña.getText()
        );
        return new VendedorDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtDireccion.getText(),
                usuarioDto
                );
    }

    private VendedorDto eliminarVendedorDto() {
        if (vendedorSeleccionado == null) {
            return null;
        }
        return new VendedorDto(
                vendedorSeleccionado.nombre(),
                vendedorSeleccionado.apellido(),
                vendedorSeleccionado.cedula(),
                vendedorSeleccionado.direccion(),
                vendedorSeleccionado.usuario()
        );
    }

    private boolean datosValidos(VendedorDto vendedorDto) {
        if(vendedorDto.nombre().isEmpty() ||
           vendedorDto.apellido().isEmpty() ||
           vendedorDto.cedula().isEmpty() ||
           vendedorDto.direccion().isEmpty() ||
           vendedorDto.usuario().userName().isEmpty() ||
           vendedorDto.usuario().password().isEmpty()
        ){
            return false;
        } else {
            return true;
        }
    }

    private void mostrarInformacionVendedor(VendedorDto vendedorSeleccionado) {

        if(vendedorSeleccionado != null){

            txtNombre.setText(vendedorSeleccionado.nombre());
            txtApellido.setText(vendedorSeleccionado.apellido());
            txtCedula.setText(vendedorSeleccionado.cedula());
            txtDireccion.setText(vendedorSeleccionado.direccion());
            txtUsuario.setText(vendedorSeleccionado.usuario().userName());
            txtContraseña.setText(vendedorSeleccionado.usuario().password());

            marketplaceAppController.obtenerTabVendedor(vendedorController.toString());
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK){
            return true;
        } else {
            return false;
        }
    }
}