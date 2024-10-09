package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketplaceAppController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
