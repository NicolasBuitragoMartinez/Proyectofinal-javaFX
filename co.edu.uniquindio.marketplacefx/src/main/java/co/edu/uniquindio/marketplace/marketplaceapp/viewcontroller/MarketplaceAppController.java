package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static co.edu.uniquindio.marketplace.marketplaceapp.utils.MarketplaceConstantes.*;

public class MarketplaceAppController {

    private LoginViewController loginViewController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab adminTab;

    @FXML
    private TabPane tabPane;

    @FXML
    void initialize() {
        mostrarLogin();
    }

    private void mostrarLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/Login.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.setScene(new Scene(root));
            loginStage.showAndWait();
            LoginViewController loginController = loader.getController();
            if (!loginController.isAuthenticated()) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
