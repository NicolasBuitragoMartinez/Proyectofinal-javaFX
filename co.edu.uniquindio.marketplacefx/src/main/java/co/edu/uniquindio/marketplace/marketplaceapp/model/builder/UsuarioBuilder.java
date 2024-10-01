package co.edu.uniquindio.marketplace.marketplaceapp.model.builder;

import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;

public class UsuarioBuilder {
    protected String userName;
    protected String password;
    public UsuarioBuilder userName(String userName){
        this.userName = userName;
        return this;
    }
    public UsuarioBuilder password(String password){
        this.password = password;
        return this;
    }
    public Usuario build(){
        return new Usuario(userName, password);
    }
}