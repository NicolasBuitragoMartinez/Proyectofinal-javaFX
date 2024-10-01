package co.edu.uniquindio.marketplace.marketplaceapp.model;

public class Usuario {
    private String userName;
    private String password;
    public Usuario(String userName,
                   String password){
        this.userName = userName;
        this.password = password;
    }
    public Usuario(){}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public void setUserName(String userName){this.userName = userName;}
    public void setPassword(String password){this.password = password;}
}
