package co.edu.uniquindio.marketplace.marketplaceapp.utils;

import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;

public class DataUtil {
    public static MarketplaceObjeto inicializarDatos() {
        MarketplaceObjeto marketplaceObjeto = new MarketplaceObjeto();
        Usuario usuario1 = Usuario.builder()
                .userName("Juan_A")
                .password("1094JUAN")
                .build();

        Usuario usuario2 = Usuario.builder()
                .userName("Sofia_O")
                .password("ADMV")
                .build();

        Usuario usuario3 = Usuario.builder()
                .userName("Nico_B")
                .password("SI_SOY_YO")
                .build();

        Vendedor vendedor1 = Vendedor.builder()
                .nombre("juan")
                .apellido("arias")
                .cedula("1094")
                .direccion("armenia")
                .usuario(usuario1)
                .build();

        Vendedor vendedor2 = Vendedor.builder()
                .nombre("sofia")
                .apellido("osorio")
                .cedula("1090")
                .direccion("armenia")
                .usuario(usuario2)
                .build();

        Vendedor vendedor3 = Vendedor.builder()
                .nombre("nico")
                .apellido("buitrago")
                .cedula("1093")
                .direccion("armenia")
                .usuario(usuario3)
                .build();

        marketplaceObjeto.getListaVendedores().add(vendedor1);
        marketplaceObjeto.getListaVendedores().add(vendedor2);
        marketplaceObjeto.getListaVendedores().add(vendedor3);

        return marketplaceObjeto;
    }
}
