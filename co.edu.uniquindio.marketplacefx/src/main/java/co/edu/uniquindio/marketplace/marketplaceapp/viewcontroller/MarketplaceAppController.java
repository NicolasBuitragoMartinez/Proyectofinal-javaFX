package co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

import co.edu.uniquindio.marketplace.marketplaceapp.controller.VendedorController;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Administrador;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import javafx.event.ActionEvent;
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
    VendedorController vendedorController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab adminTab;

    @FXML
    public TabPane tabPane;

    @FXML
    void initialize() {
        mostrarLogin();
        asignarPestaña();
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
    private void asignarPestaña() {
        try {
            URL administradorUrl = getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/Administrador.fxml");

            if (administradorUrl == null) {
                throw new IOException("No se puede encontrar Administrador.fxml en la ruta especificada.");
            }

            FXMLLoader loader = new FXMLLoader(administradorUrl);
            AnchorPane adminContent = loader.load();
            AdministradorViewController administradorViewController = loader.getController();
            administradorViewController.setMarketplaceAppController(this);
            adminTab.setContent(adminContent);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int contadorVendedores = 1;
    public void agregarTabVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            mostrarMensaje(TITULO_CEDULA_VACIA, HEADER, BODI_CEDULA_VACIA, Alert.AlertType.WARNING);
            return;
        }

        for (Tab tab : tabPane.getTabs()) {
            if (tab.getId() != null && tab.getId().equals(cedula)) {
                return;
            }
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplace/marketplaceapp/Vendedor.fxml"));
            AnchorPane vendedorContent = loader.load();

            VendedorViewController vendedorViewController = loader.getController();
            vendedorViewController.updateView(cedula);

            Tab nuevoTab = new Tab();
            nuevoTab.setId(cedula);
            nuevoTab.setText("Vendedor " + contadorVendedores);
            nuevoTab.setContent(vendedorContent);
            tabPane.getTabs().add(nuevoTab);
            contadorVendedores++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void eliminarTabVendedor(String cedula){
        if (cedula == null || cedula.isEmpty()) {
            mostrarMensaje(TITULO_CEDULA_VACIA, HEADER, BODI_CEDULA_VACIA, Alert.AlertType.WARNING);
            return;
        }

        Tab tabToRemove = null;
        for (Tab tab : tabPane.getTabs()) {
            if (cedula.equals(tab.getText())) {
                tabToRemove = tab;
                break;
            }
        }

        if (tabToRemove != null) {
            tabPane.getTabs().remove(tabToRemove);
        }
    }
    public void crearTabsParaVendedoresExistentes(VendedorController vendedorController) {
        List<VendedorDto> listaVendedores = vendedorController.obtenerVendedores();
        if (listaVendedores == null || listaVendedores.isEmpty()) {
            mostrarMensaje(TITULO_VENDEDOR_NO_REGISTRADO, HEADER, BODI_VENDEDOR_NO_REGISTRADO, Alert.AlertType.WARNING);
            return;
        }

        for (VendedorDto vendedor : listaVendedores) {
            if (!existeTabVendedor(vendedor.cedula())) {
                agregarTabVendedor(vendedor.cedula());
            }
        }
    }
    public Tab obtenerTabVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            mostrarMensaje(TITULO_CEDULA_VACIA, HEADER, BODI_CEDULA_VACIA, Alert.AlertType.WARNING);
            return null;
        }

        for (Tab tab : tabPane.getTabs()) {
            if (cedula.equals(tab.getId())) {
                return tab;
            }
        }

        return null;
    }
    public void seleccionarAdminTab() {
        if (tabPane != null && adminTab != null) {
            tabPane.getSelectionModel().select(adminTab);
        }
    }
    private boolean existeTabVendedor(String cedula) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getText().equals(cedula)) {
                return true;
            }
        }
        return false;
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public void onActionExportarDatosAdministrador(ActionEvent event) {
    }

    public void onAgregarVendedor(ActionEvent event) {
    }

    public void onNuevoVendedor(ActionEvent event) {
    }

    public void onActualizarVendedor(ActionEvent event) {
    }

    public void onEliminarVendedor(ActionEvent event) {

    }
}