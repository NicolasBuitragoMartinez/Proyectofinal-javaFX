package co.edu.uniquindio.marketplace.marketplaceapp;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MarketplaceApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MarketplaceApplication.class.getResource("MarketplaceApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Marketplace");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
