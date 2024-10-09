package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplace.marketplaceapp.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

        // Inicializa los datos y obtén la lista de vendedores
        MarketplaceObjeto marketplaceObjeto = DataUtil.inicializarDatos();

        // Verifica las credenciales
        for (Vendedor vendedor : marketplaceObjeto.getListaVendedores()) {
            if (vendedor.getUsuario().getUserName().equals(username) &&
                    vendedor.getUsuario().getPassword().equals(password)) {
                authenticated = true;
                cerrarVentana();
                return;
            }
        }
        // Si no coincide, muestra mensaje de error
        System.out.println("Usuario o contraseña incorrecta");
    }

    private void cerrarVentana() {
        Stage stage = (Stage) btnIngresar.getScene().getWindow();
        stage.close();
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    @FXML
    void initialize() {}
}
