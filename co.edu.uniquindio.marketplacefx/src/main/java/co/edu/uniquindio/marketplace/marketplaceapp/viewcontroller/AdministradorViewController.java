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
import javafx.scene.chart.*;
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
    private MarketplaceObjeto marketplace;

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
    private VBox panelGrafico;
    @FXML
    private Button btnGenerarGrafico;
    @FXML
    private ComboBox<String> cbEstadisticas;
    @FXML
    void generarGrafico(ActionEvent event) {
        panelGrafico.getChildren().clear();

        // Obtener la estadística seleccionada del ComboBox
        String estadisticaSeleccionada = (String) cbEstadisticas.getValue();

        if (estadisticaSeleccionada != null) {
            estadisticaSeleccionada = estadisticaSeleccionada.trim(); // Eliminar espacios adicionales
            System.out.println("Estadística seleccionada: " + estadisticaSeleccionada);

            // Dependiendo de la estadística seleccionada, creamos un gráfico diferente
            switch (estadisticaSeleccionada) {
                case "Mensajes por Vendedor":
                    generarGraficoMensajes();
                    break;
                case "Productos por Vendedor":
                    generarGraficoProductos();
                    break;
                case "Top Productos por Likes":
                    generarGraficoLikes();
                    break;
                default:
                    System.out.println("Estadística no soportada: " + estadisticaSeleccionada);
            }
        } else {
            System.out.println("Por favor, selecciona una estadística.");
        }


    }

    private void generarGraficoLikes() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Producto");
        yAxis.setLabel("Likes");

        // Crear el gráfico
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Top Productos por Likes");

        // Crear los datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Likes");

        // Agregar datos a la serie (estos datos deberían provenir de tu modelo de datos)
        // Aquí estamos usando datos de ejemplo: Producto y cantidad de likes
        series.getData().add(new XYChart.Data<>("Producto 1", 120));  // Producto 1 con 120 likes
        series.getData().add(new XYChart.Data<>("Producto 2", 200));  // Producto 2 con 200 likes
        series.getData().add(new XYChart.Data<>("Producto 3", 150));  // Producto 3 con 150 likes
        series.getData().add(new XYChart.Data<>("Producto 4", 80));   // Producto 4 con 80 likes

        // Agregar la serie al gráfico
        barChart.getData().add(series);

        // Agregar el gráfico al Pane
        panelGrafico.getChildren().add(barChart);
    }

    private void generarGraficoProductos() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Vendedor");
        yAxis.setLabel("Cantidad de Productos");

        // Crear el gráfico
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Productos por Vendedor");

        // Crear los datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Productos");

        // Agregar datos a la serie (estos datos deberían provenir de tu modelo)
        series.getData().add(new XYChart.Data<>("Vendedor 1", 15));
        series.getData().add(new XYChart.Data<>("Vendedor 2", 25));
        series.getData().add(new XYChart.Data<>("Vendedor 3", 30));

        // Agregar la serie al gráfico
        lineChart.getData().add(series);

        // Agregar el gráfico al Pane
        panelGrafico.getChildren().add(lineChart);
    }

    private void generarGraficoMensajes() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Vendedor");
        yAxis.setLabel("Cantidad de Mensajes");

        // Crear el gráfico
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Mensajes Enviados por Vendedor");

        // Crear los datos
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Mensajes");

        // Agregar datos a la serie (estos datos deberían provenir de tu modelo)
        // Ejemplo: agregar vendedores y la cantidad de mensajes enviados
        series.getData().add(new XYChart.Data<>("Vendedor 1", 30));
        series.getData().add(new XYChart.Data<>("Vendedor 2", 45));
        series.getData().add(new XYChart.Data<>("Vendedor 3", 50));

        // Agregar la serie al gráfico
        barChart.getData().add(series);

        // Agregar el gráfico al Pane
        panelGrafico.getChildren().add(barChart);
    }


    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        initView();
        cargarOpcionesEstadisticas();
    }

    private void cargarOpcionesEstadisticas() {
        cbEstadisticas.getItems().addAll(
                "Mensajes por Vendedor",
                "Productos por Vendedor",
                "Top Productos por Likes"
        );
    }

    @FXML
    void onExportarReporte(ActionEvent event) {

        MarketplaceObjeto marketplace = DataUtil.inicializarDatos(); // Inicializar los datos
        String rutaArchivo = "reporte_clientes.txt"; // Definir el nombre del archivo

        // Obtener la fecha actual
        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Suponiendo que el nombre del usuario que realiza el reporte es parte del sistema, puede ser un campo de usuario logueado
        String nombreUsuario = "Nombre del Usuario"; // Cambiarlo al nombre real si es necesario

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir el título y la fecha
            writer.write("Reporte de Listado de Clientes\n");
            writer.write("Fecha: " + fechaActual + "\n");
            writer.write("Reporte realizado por: " + nombreUsuario + "\n\n");

            // Información del reporte
            writer.write("Información del reporte:\n");
            writer.write("----------------------------------------------------\n");

            // Escribir información de los vendedores (clientes)
            writer.write("Listado de Vendedores:\n");
            for (Vendedor vendedor : marketplace.getListaVendedores()) {
                writer.write("- Nombre: " + vendedor.getNombre() + " " + vendedor.getApellido() + "\n");
                writer.write("  Cedula: " + vendedor.getCedula() + "\n");
                writer.write("  Dirección: " + vendedor.getDireccion() + "\n");
                writer.write("  Usuario: " + vendedor.getUsuario().getUserName() + "\n\n");
            }

            // Escribir productos asociados a cada vendedor
            writer.write("Productos Publicados:\n");
            for (Vendedor vendedor : marketplace.getListaVendedores()) {
                writer.write("Vendedor: " + vendedor.getNombre() + "\n");
                for (Producto producto : vendedor.getProductosAgregados()) {
                    writer.write("  - Producto: " + producto.getNombre() + " | Estado: " + producto.getEstado() + "\n");
                }
                writer.write("\n");
            }

            // Mensaje final
            writer.write("----------------------------------------------------\n");
            writer.write("Reporte generado con éxito.\n");

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
        try {
            // Cargar la nueva vista FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/MensajesEntreVendedor.fxml"));
            Parent root = loader.load();

            // Obtener el controlador y pasarle el marketplace
            mensajesEntreVendedorViewController controller = loader.getController();
            controller.setMarketplace(DataUtil.inicializarDatos());

            // Crear una nueva ventana para mostrar la vista
            Stage stage = new Stage();
            stage.setTitle("Mensajes Entre Vendedores");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        manejarContactosPorVendedor();
    }

    private void manejarContactosPorVendedor() {
        MarketplaceObjeto marketplaceObjeto = DataUtil.inicializarDatos();
        List<Vendedor> listaVendedores = marketplaceObjeto.getListaVendedores();

        // Recorre la lista de vendedores
        for (Vendedor vendedor : listaVendedores) {
            // Obtiene la cantidad de vendedores aliados (contactos)
            int cantidadContactos = vendedor.getVendedoresAliados().size();

            // Muestra el nombre del vendedor y la cantidad de contactos en la consola
            System.out.println("Vendedor: " + vendedor.getNombre() + " tiene " + cantidadContactos + " contactos.");
        }




        
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