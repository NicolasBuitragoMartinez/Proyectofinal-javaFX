package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdministradorViewController {

    VendedorController vendedorController;
    ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    VendedorDto vendedorSeleccionado;

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
    void initialize() {
        vendedorController = new VendedorController();
        initView();
    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {

    }

    @FXML
    void onAgregarVendedor(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onEliminarVendedor(ActionEvent event) {

    }

    @FXML
    void onNuevoVendedor(ActionEvent event) {

    }

    private void initView() {
        initDataBinding();
        obtenerVendedor();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
        listenerSelection();
    }
    private void obtenerVendedor() {
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
    private void agregarVendedor() {
        VendedorDto vendedorDto = crearVendedorDto();
        if(datosValidos(vendedorDto)){

        } else {
            mostrarMensaje("Campos incompletos", "Notificación", "Los datos del formulario estan incompletos", Alert.AlertType.ERROR);
        }
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
