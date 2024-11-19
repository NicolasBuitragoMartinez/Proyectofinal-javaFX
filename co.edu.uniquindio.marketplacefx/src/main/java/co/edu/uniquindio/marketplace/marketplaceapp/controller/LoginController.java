package co.edu.uniquindio.marketplace.marketplaceapp.controller;

import co.edu.uniquindio.marketplace.marketplaceapp.patrones.factory.ModelFactory;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Persona;

public class LoginController {

    private static ModelFactory modelFactory = null;

    public LoginController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public static Persona validarUsuario(String username, String contrasena) throws Exception{
        return modelFactory.validarUsuario(username, contrasena);
    }
}