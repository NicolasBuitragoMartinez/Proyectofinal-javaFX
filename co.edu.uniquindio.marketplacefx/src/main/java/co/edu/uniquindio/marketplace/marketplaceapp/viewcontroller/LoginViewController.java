package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

        mostrarMensaje(TITULO_LOGIN_INCORRECTO, HEADER, BODI_LOGIN_INCORRECTO, Alert.AlertType.ERROR);
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
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

    @FXML
    void initialize() {
        sugerenciaPista();
    }

    private void sugerenciaPista() {
        txtUsuario.setPromptText("Ingrese el usuario...");
        txtContraseña.setPromptText("Ingrese la contraseña...");
    }
}
