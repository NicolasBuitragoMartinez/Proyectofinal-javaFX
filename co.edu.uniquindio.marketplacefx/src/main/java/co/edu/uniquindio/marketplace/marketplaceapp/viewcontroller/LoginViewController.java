package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.ProxySelector;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.MarketplaceApplication;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy.SesionUsuario;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
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
            SesionUsuario.setRolActual("ADMINISTRADOR");
            authenticated = true;
            cerrarVentana();
            abrirVentana("Administrador.fxml");

        }
        marketplaceObjeto.getListaVendedores().stream()
                .filter(v -> v.getUsuario().getUserName().equals(username) &&
                        v.getUsuario().getPassword().equals(password))
                .findFirst()
                .ifPresentOrElse(vendedor -> {
                    SesionUsuario.setRolActual("VENDEDOR");
                    authenticated = true;
                    cerrarVentana();
                    abrirVentana("Vendedor.fxml");

                    mostrarMensaje(BODI_LOGIN_CORRECTO, Alert.AlertType.INFORMATION);
                }, () ->{

                });
    }

    public void abrirVentana(String ventana) {

        try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(MarketplaceApplication.class.getResource(
                            ventana));

            Stage stage = new Stage();

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Marketplace");
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



}



