package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.URL;
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

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

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
        VendedorDto vendedorDto = crearVendedorDto();
        if(datosValidos(vendedorDto)){
            if (vendedorController.agregarVendedor(vendedorDto)){
                listaVendedores.addAll(vendedorDto);
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
        VendedorDto vendedorDto = eliminarVendedorDto();
        if (vendedorDto == null || !datosValidos(vendedorDto)) {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
            return;
        }
        if (vendedorController.eliminarVendedor(vendedorDto)) {
            listaVendedores.remove(vendedorSeleccionado);
            limpiarCampos();
            mostrarMensaje(TITULO_VENDEDOR_ELIMINADO, HEADER, BODI_VENDEDOR_ELIMINADO, Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje(TITULO_VENDEDOR_NO_ELIMINADO, HEADER, BODI_VENDEDOR_NO_ELIMINADO, Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
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