package co.edu.uniquindio.marketplace.marketplaceapp.patrones.proxy;

public class SesionUsuario {
    private static String rolActual;

    public static String getRolActual() {
        return rolActual;
    }

    public static void setRolActual(String rol) {
        rolActual = rol;
    }
}

