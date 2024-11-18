package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.ProxySelector;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.MarketplaceApplication;
import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

public class LoginViewController {

    private ModelFactory modelFactory;
    private boolean authenticated = false;


    public LoginViewController() {
        modelFactory = ModelFactory.getInstancia();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtUsuario;
    @FXML
    private TabPane tabPane;


    @FXML
    void onIngresarUsuario() {

        MarketplaceObjeto marketplaceObjeto = DataUtil.inicializarDatos();


        String username = txtUsuario.getText();
        String password = txtContraseña.getText();


        if (marketplaceObjeto.getAdministrador().getUsuario().getUserName().equals(username) &&
                marketplaceObjeto.getAdministrador().getUsuario().getPassword().equals(password)) {
            authenticated = true;
            cerrarVentana();
            abrirVentana("Administrador.fxml");
            return;
        }
        marketplaceObjeto.getListaVendedores().stream()
                .filter(v -> v.getUsuario().getUserName().equals(username) &&
                        v.getUsuario().getPassword().equals(password))
                .findFirst()
                .ifPresentOrElse(vendedor -> {
                    // Acciones cuando el vendedor existe
                    authenticated = true;

                    cerrarVentana();
                    abrirVentana("Vendedor.fxml");

                    Platform.runLater(() -> {
                        if (tabPane != null) {
                            // Obtener o agregar el tab correspondiente al vendedor
                            Tab adminTab = obtenerTabVendedor(vendedor.getCedula());
                            if (adminTab != null) {
                                tabPane.getSelectionModel().select(adminTab);
                            } else {
                                agregarTabVendedor(vendedor.getCedula());
                            }
                        }
                    });

                    // Mostrar mensaje después de configurar el tab
                    mostrarMensaje(BODI_LOGIN_CORRECTO, Alert.AlertType.INFORMATION);
                }, () -> {
                    // Acciones cuando el vendedor no existe
                    mostrarMensaje("Usuario o contraseña incorrectos.", Alert.AlertType.ERROR);
                });



    }


    private void agregarTabVendedor(String cedula) {
    }

    private ProxySelector getSelectionModel() {
        return null;
    }

    public void abrirVentana(String ventana) {

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(MarketplaceApplication.class.getResource(
                            ventana));

            Stage stage = new Stage();

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Marketplace App");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    private void cerrarVentana() {
        Stage stage = (Stage) btnIngresar.getScene().getWindow();
        stage.close();
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    private Tab obtenerTabVendedor(String cedula){

        return null;
    }
    


}


/**
    @FXML
    void initialize() {
        sugerenciaPista();
    }

    private void sugerenciaPista() {
        txtUsuario.setPromptText("Ingrese el usuario...");
        txtContraseña.setPromptText("Ingrese la contraseña...");
    }




}


/**
 String username = txtUsuario.getText();
 String password = txtContraseña.getText();

 MarketplaceObjeto marketplaceObjeto = DataUtil.inicializarDatos();


 if (marketplaceObjeto.getAdministrador().getUsuario().getUserName().equals(username) &&
 marketplaceObjeto.getAdministrador().getUsuario().getPassword().equals(password)) {
 authenticated = true;
 cerrarVentana();
 return;
 }

 for (Vendedor vendedor : marketplaceObjeto.getListaVendedores()) {
 if (vendedor.getUsuario().getUserName().equals(username) &&
 vendedor.getUsuario().getPassword().equals(password)) {
 authenticated = true;
 cerrarVentana();
 return;
 }
 }
 */
