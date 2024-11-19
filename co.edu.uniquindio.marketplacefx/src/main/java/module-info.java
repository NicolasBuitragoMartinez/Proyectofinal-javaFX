module co.edu.uniquindio.marketplace.marketplaceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.testng;

    opens co.edu.uniquindio.marketplace.marketplaceapp to javafx.fxml;
    exports co.edu.uniquindio.marketplace.marketplaceapp;

    opens co.edu.uniquindio.marketplace.marketplaceapp.controller;
    exports co.edu.uniquindio.marketplace.marketplaceapp.controller;

    opens co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;
    exports co.edu.uniquindio.marketplace.marketplaceapp.viewcontroller;

    opens co.edu.uniquindio.marketplace.marketplaceapp.patrones.builder;
    exports co.edu.uniquindio.marketplace.marketplaceapp.patrones.builder;
}