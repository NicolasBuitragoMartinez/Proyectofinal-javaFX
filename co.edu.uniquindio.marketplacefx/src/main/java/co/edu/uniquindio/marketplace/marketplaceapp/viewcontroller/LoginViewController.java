package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import co.edu.uniquindio.marketplace.marketplaceapp.MarketplaceApplication;
import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

public class LoginViewController {

    private ModelFactory modelFactory;
    private MarketplaceAppController marketplaceAppController;
    private boolean authenticated = false;

    public void setMarketplaceAppController(MarketplaceAppController marketplaceAppController){
        this.marketplaceAppController = marketplaceAppController;
    }

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
    void initialize() {
        sugerenciaPista();
    }

    private void sugerenciaPista() {
        txtUsuario.setPromptText("Ingrese el usuario...");
        txtContraseña.setPromptText("Ingrese la contraseña...");
    }

    @FXML
    void onIngresarUsuario() {
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
    }

    private ProxySelector getSelectionModel() {
        return null;
    }

    private void cerrarVentana() {
        if(isAuthenticated()){
            authenticated = true;
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            if (stage != null) {
                stage.close();
            }
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    private Tab obtenerTabVendedor(String cedula){
        return null;
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
