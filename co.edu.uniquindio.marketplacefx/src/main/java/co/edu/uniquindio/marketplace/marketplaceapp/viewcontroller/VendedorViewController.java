package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.controller.ProductoController;
import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.GarantiaExtendidaDecorator;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.ProductoBase;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.PromocionDecorator;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

public class VendedorViewController {

    ProductoController productoController;
    VendedorController vendedorController;
    ObservableList<ProductoDto> listaProductos = FXCollections.observableArrayList();
    ObservableList<VendedorDto> listaVendedores = FXCollections.observableArrayList();
    ProductoDto productoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnAgregarComentario;

    @FXML
    private Button btnAgregarContactos;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnMeGusta;

    @FXML
    private Button btnNuevoProducto;

    @FXML
    private RadioButton rdbAgregarFoto;

    @FXML
    private ImageView ivProducto;

    @FXML
    private ImageView ivProPublicado;

    @FXML
    private Label lbVendedor;

    @FXML
    private Label lbCategoriaProPublicado;

    @FXML
    private Label lbNombreProPublicado;

    @FXML
    private Label lbPrecioProPublicado;

    @FXML
    private Label lbReaccionesProPublicado;

    @FXML
    private TabPane tpVendedor;

    @FXML
    private TableView<ProductoDto> tableProducto;

    @FXML
    private TableView<?> tableComentario;

    @FXML
    private TableView<?> tableContactos;

    @FXML
    private TableView<?> tableProductoPublicado;

    @FXML
    private TableColumn<ProductoDto, String> tcCategoriaProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcIdentificadorProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcEstadoProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcNombreProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcPrecioProducto;

    @FXML
    private TableColumn<?, ?> tcCategoriaPublicacion;

    @FXML
    private TableColumn<?, ?> tcNombrePublicacion;

    @FXML
    private TableColumn<?, ?> tcPrecioPublicacion;

    @FXML
    private TableColumn<?, ?> tcNombreComentarista;

    @FXML
    private TableColumn<?, ?> tcTextoComentario;

    @FXML
    private TableColumn<?, ?> tcContactos;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtIdentificador;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtComentario;
    private Vendedor vendedor;

    @FXML
    void initialize() {
        productoController = new ProductoController();
        vendedorController = new VendedorController();
        initView();
    }

    @FXML
    void onActionAgregarComentario(ActionEvent event) {

    }

    @FXML
    void onActionAgregarContactos(ActionEvent event) {

    }

    @FXML
    void onActionMeGusta(ActionEvent event) {

    }

    @FXML
    void onActualizarProducto(ActionEvent event) {
        actualizarProducto();
    }

    @FXML
    void onAgregarProducto(ActionEvent event) {
        agregarProducto();
    }

    @FXML
    void onEliminarProducto(ActionEvent event) {
        eliminarProducto();
    }

    @FXML
    void onNuevoProducto(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    void onAgregarFoto(ActionEvent event) {
        agregarFoto();
    }

    private void initView() {
        initDataBinding();
        obtenerProducto();
        tableProducto.getItems().clear();
        tableProducto.setItems(listaProductos);
        listenerSelection();
        limpiarCampos();
    }

    private void obtenerProducto() {
        listaProductos.addAll(productoController.obtenerProductos());
    }

    private void initDataBinding() {
        tcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcIdentificadorProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().identificador()));
        tcCategoriaProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
        tcPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().precio())));
        tcEstadoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().estado().toString()));
    }

    private void listenerSelection() {
        tableProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
            mostrarImagenProducto(productoSeleccionado);
            mostrarProductoConDecoradores(productoSeleccionado);
        });
    }

    private void actualizarProducto() {
        ProductoDto productoDto = actualizarProductoDto();
        if (datosValidos(productoDto)) {
            if (productoController.actualizarProducto(productoDto)) {
                int index = listaProductos.indexOf(productoSeleccionado);
                listaProductos.set(index, productoDto);
                limpiarCampos();
                mostrarMensaje(TITULO_PRODUCTO_ACTUALIZADO, HEADER, BODI_PRODUCTO_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_PRODUCTO_NO_ACTUALIZADO, HEADER, BODI_PRODUCTO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void agregarProducto() {
        ProductoDto productoDto = crearProductoDto();
        if (datosValidos(productoDto)) {
            if (productoController.agregarProducto(productoDto)) {
                listaProductos.addAll(productoDto);
                limpiarCampos();
                mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER, BODI_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_PRODUCTO_NO_AGREGADO, HEADER, BODI_PRODUCTO_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void eliminarProducto() {
        ProductoDto productoDto = eliminarProductoDto();
        if (productoDto == null || !datosValidos(productoDto)) {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
            return;
        }
        if (productoController.eliminarProducto(productoDto)) {
            listaProductos.remove(productoSeleccionado);
            limpiarCampos();
            mostrarMensaje(TITULO_PRODUCTO_ELIMINADO, HEADER, BODI_PRODUCTO_ELIMINADO, Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje(TITULO_PRODUCTO_NO_ELIMINADO, HEADER, BODI_PRODUCTO_NO_ELIMIANDO, Alert.AlertType.ERROR);
        }
    }

    private void agregarFoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen del Producto");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            Image imagen = new Image(file.toURI().toString());
            ivProducto.setImage(imagen);
        }
        rdbAgregarFoto.setSelected(false);
    }

    public void updateView(String cedula) {
        VendedorDto vendedorDto = vendedorController.obtenerVendedorPorCedula(cedula);
        if (vendedorDto != null) {
            lbVendedor.setText("Vendedor: " + vendedorDto.nombre() + " " + vendedorDto.apellido());

            listaProductos.clear();
            listaProductos.addAll(productoController.obtenerProductosPorVendedor(cedula));
            tableProducto.setItems(listaProductos);
        } else {
            mostrarMensaje(TITULO_VENDEDOR_NO_ENCONTRADO, HEADER, BODI_VENDEDOR_NO_ENCOTRADO, Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txtNombreProducto.setText("");
        txtNombreProducto.setPromptText("Ingrese el nombre...");
        txtIdentificador.setText("");
        txtIdentificador.setPromptText("Ingrese el identificador...");
        txtCategoria.setText("");
        txtCategoria.setPromptText("Ingrese la categoría...");
        txtPrecio.setText("");
        txtPrecio.setPromptText("Ingrese el precio...");
        Image imagen = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-10 215634.png");
        ivProducto.setImage(imagen);
    }

    private boolean datosValidos(ProductoDto productoDto) {
        if (productoDto.nombre().isEmpty() ||
                productoDto.identificador().isEmpty() ||
                productoDto.categoria().isEmpty() ||
                productoDto.precio() <= 0
        ) {
            return false;
        } else {
            return true;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private ProductoDto actualizarProductoDto() {
        return new ProductoDto(
                txtNombreProducto.getText(),
                txtIdentificador.getText(),
                ivProducto.getImage(),
                txtCategoria.getText(),
                Integer.parseInt(txtPrecio.getText()),
                EstadoProducto.NO_AGREGADO
        );
    }

    private ProductoDto crearProductoDto() {
        return new ProductoDto(
                txtNombreProducto.getText(),
                txtIdentificador.getText(),
                ivProducto.getImage(),
                txtCategoria.getText(),
                Integer.parseInt(txtPrecio.getText()),
                EstadoProducto.NO_AGREGADO
        );
    }

    private ProductoDto eliminarProductoDto() {
        if (productoSeleccionado == null) {
            return null;
        }
        return new ProductoDto(
                productoSeleccionado.nombre(),
                productoSeleccionado.identificador(),
                productoSeleccionado.imagen(),
                productoSeleccionado.categoria(),
                productoSeleccionado.precio(),
                productoSeleccionado.estado()
        );
    }

    private void mostrarInformacionProducto(ProductoDto productoSeleccionado) {
        if (productoSeleccionado != null) {
            txtNombreProducto.setText(productoSeleccionado.nombre());
            txtIdentificador.setText(productoSeleccionado.identificador());
            txtCategoria.setText(productoSeleccionado.categoria());
            txtPrecio.setText(String.valueOf(productoSeleccionado.precio()));
        }
    }

    public void mostrarProductoConDecoradores(ProductoDto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
        Producto productoBase = new ProductoBase("Laptop Gaming", 1200.0);

        Producto productoConGarantia = new GarantiaExtendidaDecorator(productoBase);

        Producto productoConPromocion = new PromocionDecorator(productoConGarantia);

        System.out.println("Descripción: " + productoConPromocion.getDescripcion());
        System.out.println("Precio final: $" + productoConPromocion.getPrecio());
    }

    private void mostrarImagenProducto(ProductoDto producto) {
        if (producto != null && producto.imagen() != null) {
            ivProducto.setImage(producto.imagen());
        } else {
            ivProducto.setImage(null);
        }
    }

    public void setVendedor(Vendedor vendedor) {


        this.vendedor = vendedor;
    }

    public void seleccionarPestanaVendedor(Vendedor vendedor) {


        for (Tab tab : tpVendedor.getTabs()) {


            if (tab.getText().equals(vendedor.getNombre())) {
                tpVendedor.getSelectionModel().select(tab);

                break;
            }
        }
    }




}


/**
    comboBox.setOnAction(event -> {
        String seleccion = comboBox.getValue();
        try {
            cambiarEstrategia(seleccion);
            System.out.println("Estrategia cambiada a: " + seleccion);
        } catch (IllegalArgumentException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    });
}
 */

