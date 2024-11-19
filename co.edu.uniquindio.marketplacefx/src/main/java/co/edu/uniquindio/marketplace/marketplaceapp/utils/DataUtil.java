package co.edu.uniquindio.marketplace.marketplaceapp.utils;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.*;
import javafx.scene.image.Image;

public class DataUtil {
    public static MarketplaceObjeto inicializarDatos() {
        MarketplaceObjeto marketplaceObjeto = new MarketplaceObjeto();
        Usuario usuario1 = Usuario.builder()
                .userName("Juan_B")
                .password("1094JUAN")
                .build();
        Usuario usuario2 = Usuario.builder()
                .userName("Sofia")
                .password("ADMV")
                .build();
        Usuario usuario3 = Usuario.builder()
                .userName("Nico_B")
                .password("SI_SOY_YO")
                .build();
        Usuario usuario4 = Usuario.builder()
                .userName("Alex_B")
                .password("ALEXANDER")
                .build();
        Usuario usuario5 = Usuario.builder()
                .userName("Vero_M")
                .password("VeroMM")
                .build();
        Usuario usuario6 = Usuario.builder()
                .userName("ZeusZeus")
                .password("1234Zeus")
                .build();
        Usuario usuario7 = Usuario.builder()
                .userName("El_Mejor_Videojuego")
                .password("Dios de la guerra")
                .build();
        Usuario usuario8 = Usuario.builder()
                .userName("MEJOR_CONSOLA_DE_VIDEOJUEGOS")
                .password("1994")
                .build();
        Usuario usuario9 = Usuario.builder()
                .userName("Juan_M_G")
                .password("JMG")
                .build();

        Administrador administrador = Administrador.builder()
                .nombre("Juan")
                .apellido("Buitrago")
                .cedula("1094")
                .direccion("armenia")
                .usuario(usuario1)
                .build();
        Vendedor vendedor1 = Vendedor.builder()
                .nombre("Sofia")
                .apellido("Osorio")
                .cedula("1090")
                .direccion("Medellín")
                .usuario(usuario2)
                .build();
        Vendedor vendedor2 = Vendedor.builder()
                .nombre("Nico")
                .apellido("Buitrago")
                .cedula("1093")
                .direccion("Armenia")
                .usuario(usuario3)
                .build();
        Vendedor vendedor3 = Vendedor.builder()
                .nombre("Alex")
                .apellido("Buitrago")
                .cedula("972")
                .direccion("Armenia")
                .usuario(usuario4)
                .build();
        Vendedor vendedor4 = Vendedor.builder()
                .nombre("Veronica")
                .apellido("Martinez")
                .cedula("419")
                .direccion("Cali")
                .usuario(usuario5)
                .build();
        Vendedor vendedor5 = Vendedor.builder()
                .nombre("Zeus")
                .apellido("Zeus")
                .cedula("1234")
                .direccion("MiCasa")
                .usuario(usuario6)
                .build();
        Vendedor vendedor6 = Vendedor.builder()
                .nombre("Kratos")
                .apellido("GOD-OF-WAR")
                .cedula("7887656")
                .direccion("Esparta")
                .usuario(usuario7)
                .build();
        Vendedor vendedor7 = Vendedor.builder()
                .nombre("Play")
                .apellido("Station")
                .cedula("5678")
                .direccion("Japon")
                .usuario(usuario8)
                .build();
        Vendedor vendedor8 = Vendedor.builder()
                .nombre("Manuel")
                .apellido("Gallego")
                .cedula("08766")
                .direccion("Armenia")
                .usuario(usuario9)
                .build();

        Comentario comentario1 = Comentario.builder()
                .comentario("Me interesa")
                .build();
        Comentario comentario2 = Comentario.builder()
                .comentario("¿Cuanto es lo minimo?")
                .build();
        Comentario comentario3 = Comentario.builder()
                .comentario("Esta muy costoso")
                .build();
        Comentario comentario4 = Comentario.builder()
                .comentario("Donde se encuentra?")
                .build();
        Comentario comentario5 = Comentario.builder()
                .comentario("¿Sigue disponible?")
                .build();
        Comentario comentario6 = Comentario.builder()
                .comentario("tengo 2 mil")
                .build();
        Comentario comentario7 = Comentario.builder()
                .comentario("Donde nos podemos encontrar?")
                .build();
        Comentario comentario8 = Comentario.builder()
                .comentario("Referencias?")
                .build();
        Comentario comentario9 = Comentario.builder()
                .comentario("¿Ofreces envío?")
                .build();
        Comentario comentario10 = Comentario.builder()
                .comentario("¿Está en buen estado?")
                .build();
        Comentario comentario11 = Comentario.builder()
                .comentario("¿Incluye accesorios?")
                .build();
        Comentario comentario12 = Comentario.builder()
                .comentario("¿Podemos negociar el precio?")
                .build();
        Comentario comentario13 = Comentario.builder()
                .comentario("¿Es el último modelo?")
                .build();
        Comentario comentario14 = Comentario.builder()
                .comentario("¿Cómo coordinamos la entrega?")
                .build();
        Comentario comentario15 = Comentario.builder()
                .comentario("¿Cuánto tiempo en uso?")
                .build();
        Comentario comentario16 = Comentario.builder()
                .comentario("Me interesa mucho")
                .build();
        Comentario comentario17 = Comentario.builder()
                .comentario("¿Aceptas transferencias?")
                .build();
        Comentario comentario18 = Comentario.builder()
                .comentario("¿Puedes hacer rebaja?")
                .build();
        Comentario comentario19 = Comentario.builder()
                .comentario("Necesito verlo primero")
                .build();
        Comentario comentario20 = Comentario.builder()
                .comentario("¿Disponibilidad inmediata?")
                .build();
        Comentario comentario21 = Comentario.builder()
                .comentario("Muy buen producto")
                .build();
        Comentario comentario22 = Comentario.builder()
                .comentario("¿Dónde se encuentra?")
                .build();
        Comentario comentario23 = Comentario.builder()
                .comentario("¿Garantía?")
                .build();
        Comentario comentario24 = Comentario.builder()
                .comentario("Quiero comprarlo")
                .build();
        Comentario comentario25 = Comentario.builder()
                .comentario("Dime tu ubicación")
                .build();
        Comentario comentario26 = Comentario.builder()
                .comentario("Podemos negociar precio")
                .build();
        Comentario comentario27 = Comentario.builder()
                .comentario("¿Es original?")
                .build();
        Comentario comentario28 = Comentario.builder()
                .comentario("¿Tienes más fotos?")
                .build();
        Comentario comentario29 = Comentario.builder()
                .comentario("Interesado en comprar")
                .build();
        Comentario comentario30 = Comentario.builder()
                .comentario("Lo compraría ya")
                .build();
        Comentario comentario31 = Comentario.builder()
                .comentario("Dime precio final")
                .build();
        Comentario comentario32 = Comentario.builder()
                .comentario("¿Aún disponible?")
                .build();
        Comentario comentario33 = Comentario.builder()
                .comentario("Me gusta, ¿negociable?")
                .build();
        Comentario comentario34 = Comentario.builder()
                .comentario("¿Cómo lo recojo?")
                .build();
        Comentario comentario35 = Comentario.builder()
                .comentario("Quisiera verlo en persona")
                .build();

        Image imagenProducto1 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170008.png");
        Image imagenProducto2 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170041.png");
        Image imagenProducto3 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170119.png");
        Image imagenProducto4 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170155.png");
        Image imagenProducto5 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170433.png");
        Image imagenProducto6 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170523.png");
        Image imagenProducto7 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170545.png");
        Image imagenProducto8 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170617.png");
        Image imagenProducto9 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170708.png");
        Image imagenProducto10 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170726.png");
        Image imagenProducto11 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-04 170757.png");
        Image imagenProducto12 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-05 162922.png");
        Image imagenProducto13 = new Image("file:D:\\OneDrive\\java\\Programacion_2\\Proyectofinal-javaFX\\co.edu.uniquindio.marketplacefx\\src\\main\\resources\\images\\Captura de pantalla 2024-11-05 163012.png");

        Producto producto1 = Producto.builder()
                .nombre("PlayStation5")
                .identificador("1A")
                .imagen(imagenProducto1)
                .categoria("Consola de videojuegos")
                .precio((int) 2000000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto2 = Producto.builder()
                .nombre("iPhone 15 Pro Max")
                .identificador("2A")
                .imagen(imagenProducto2)
                .categoria("Telefonos")
                .precio((int) 3800000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto3 = Producto.builder()
                .nombre("Televisor Samsung")
                .identificador("3A")
                .imagen(imagenProducto3)
                .categoria("Televisores")
                .precio((int) 2250000)
                .estado(EstadoProducto.VENDIDO)
                .build();
        Producto producto4 = Producto.builder()
                .nombre("EA FC24")
                .identificador("4A")
                .imagen(imagenProducto4)
                .categoria("Videojuegos")
                .precio((int) 250000)
                .estado(EstadoProducto.VENDIDO)
                .build();
        Producto producto5 = Producto.builder()
                .nombre("Tarjeta grafica AMD Radeon")
                .identificador("5A")
                .imagen(imagenProducto5)
                .categoria("Computación")
                .precio((int) 1980000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto6 = Producto.builder()
                .nombre("Kia Rio")
                .identificador("6A")
                .imagen(imagenProducto6)
                .categoria("Vehículos")
                .precio((int) 35000000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto7 = Producto.builder()
                .nombre("NMax")
                .identificador("7A")
                .imagen(imagenProducto7)
                .categoria("Vehículos")
                .precio((int) 17500000)
                .estado(EstadoProducto.VENDIDO)
                .build();
        Producto producto8 = Producto.builder()
                .nombre("PC gamer")
                .identificador("8A")
                .imagen(imagenProducto8)
                .categoria("Computación")
                .precio((int) 5200000)
                .estado(EstadoProducto.VENDIDO)
                .build();
        Producto producto9 = Producto.builder()
                .nombre("Casa")
                .identificador("9A")
                .imagen(imagenProducto9)
                .categoria("Vivienda")
                .precio((int) 450000000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto10 = Producto.builder()
                .nombre("Comedor")
                .identificador("1B")
                .imagen(imagenProducto10)
                .categoria("Muebles")
                .precio((int) 1249990)
                .estado(EstadoProducto.VENDIDO)
                .build();
        Producto producto11 = Producto.builder()
                .nombre("Hot Wheels")
                .identificador("2B")
                .imagen(imagenProducto11)
                .categoria("Jugueteria")
                .precio((int) 20000)
                .estado(EstadoProducto.PUBLICADO)
                .build();
        Producto producto12 = Producto.builder()
                .nombre("Camiseta Real Madrid")
                .identificador("3B")
                .imagen(imagenProducto12)
                .categoria("Ropa")
                .precio((int)650000)
                .estado(EstadoProducto.NO_AGREGADO)
                .build();
        Producto producto13 = Producto.builder()
                .nombre("Camiseta Manchester United 2008 CR7")
                .identificador("4B")
                .imagen(imagenProducto13)
                .categoria("Ropa")
                .precio((int)530000)
                .estado(EstadoProducto.NO_AGREGADO)
                .build();

        Publicacion publicacion1 = Publicacion.builder()
                .like((int) 3)
                .producto(producto1)
                .build();
        Publicacion publicacion2 = Publicacion.builder()
                .like((int) 0)
                .producto(producto2)
                .build();
        Publicacion publicacion3 = Publicacion.builder()
                .like((int) 20)
                .producto(producto3)
                .build();
        Publicacion publicacion4 = Publicacion.builder()
                .like((int) 5)
                .producto(producto4)
                .build();
        Publicacion publicacion5 = Publicacion.builder()
                .like(8)
                .producto(producto5)
                .build();
        Publicacion publicacion6 = Publicacion.builder()
                .like(15)
                .producto(producto6)
                .build();
        Publicacion publicacion7 = Publicacion.builder()
                .like(25)
                .producto(producto7)
                .build();
        Publicacion publicacion8 = Publicacion.builder()
                .like(10)
                .producto(producto8)
                .build();
        Publicacion publicacion9 = Publicacion.builder()
                .like(5)
                .producto(producto9)
                .build();
        Publicacion publicacion10 = Publicacion.builder()
                .like(2)
                .producto(producto10)
                .build();
        Publicacion publicacion11 = Publicacion.builder()
                .like(30)
                .producto(producto11)
                .build();

        Muro muro1 = new Muro();
        Muro muro2 = new Muro();
        Muro muro3 = new Muro();
        Muro muro4 = new Muro();
        Muro muro5 = new Muro();
        Muro muro6 = new Muro();
        Muro muro7 = new Muro();
        Muro muro8 = new Muro();

        marketplaceObjeto.setAdministrador(administrador);
        marketplaceObjeto.getListaVendedores().add(vendedor1);
        marketplaceObjeto.getListaVendedores().add(vendedor2);
        marketplaceObjeto.getListaVendedores().add(vendedor3);
        marketplaceObjeto.getListaVendedores().add(vendedor4);
        marketplaceObjeto.getListaVendedores().add(vendedor5);
        marketplaceObjeto.getListaVendedores().add(vendedor6);
        marketplaceObjeto.getListaVendedores().add(vendedor7);
        marketplaceObjeto.getListaVendedores().add(vendedor8);
        vendedor1.getVendedoresAliados().add(vendedor2);
        vendedor1.getVendedoresAliados().add(vendedor5);
        vendedor2.getVendedoresAliados().add(vendedor1);
        vendedor2.getVendedoresAliados().add(vendedor3);
        vendedor2.getVendedoresAliados().add(vendedor4);
        vendedor2.getVendedoresAliados().add(vendedor5);
        vendedor2.getVendedoresAliados().add(vendedor6);
        vendedor2.getVendedoresAliados().add(vendedor7);
        vendedor2.getVendedoresAliados().add(vendedor8);
        vendedor3.getVendedoresAliados().add(vendedor4);
        vendedor3.getVendedoresAliados().add(vendedor8);
        vendedor4.getVendedoresAliados().add(vendedor3);
        vendedor5.getVendedoresAliados().add(vendedor2);
        vendedor6.getVendedoresAliados().add(vendedor2);
        vendedor6.getVendedoresAliados().add(vendedor8);
        vendedor7.getVendedoresAliados().add(vendedor2);
        vendedor7.getVendedoresAliados().add(vendedor8);
        vendedor8.getVendedoresAliados().add(vendedor2);
        vendedor8.getVendedoresAliados().add(vendedor6);
        vendedor8.getVendedoresAliados().add(vendedor7);
        vendedor1.getProductosAgregados().add(producto1);
        vendedor1.getProductosAgregados().add(producto2);
        vendedor2.getProductosAgregados().add(producto3);
        vendedor3.getProductosAgregados().add(producto4);
        vendedor4.getProductosAgregados().add(producto5);
        vendedor4.getProductosAgregados().add(producto6);
        vendedor5.getProductosAgregados().add(producto7);
        vendedor6.getProductosAgregados().add(producto8);
        vendedor6.getProductosAgregados().add(producto9);
        vendedor7.getProductosAgregados().add(producto10);
        vendedor7.getProductosAgregados().add(producto11);
        vendedor7.getProductosAgregados().add(producto12);
        vendedor8.getProductosAgregados().add(producto13);
        publicacion1.getComentarios().add(comentario1);
        publicacion1.getComentarios().add(comentario2);
        publicacion1.getComentarios().add(comentario3);
        publicacion1.getComentarios().add(comentario4);
        publicacion2.getComentarios().add(comentario5);
        publicacion2.getComentarios().add(comentario6);
        publicacion2.getComentarios().add(comentario7);
        publicacion2.getComentarios().add(comentario8);
        publicacion3.getComentarios().add(comentario9);
        publicacion3.getComentarios().add(comentario10);
        publicacion3.getComentarios().add(comentario11);
        publicacion3.getComentarios().add(comentario12);
        publicacion4.getComentarios().add(comentario13);
        publicacion4.getComentarios().add(comentario14);
        publicacion5.getComentarios().add(comentario15);
        publicacion5.getComentarios().add(comentario16);
        publicacion5.getComentarios().add(comentario17);
        publicacion6.getComentarios().add(comentario18);
        publicacion6.getComentarios().add(comentario19);
        publicacion6.getComentarios().add(comentario20);
        publicacion7.getComentarios().add(comentario21);
        publicacion7.getComentarios().add(comentario22);
        publicacion7.getComentarios().add(comentario23);
        publicacion8.getComentarios().add(comentario24);
        publicacion8.getComentarios().add(comentario25);
        publicacion8.getComentarios().add(comentario26);
        publicacion9.getComentarios().add(comentario27);
        publicacion9.getComentarios().add(comentario28);
        publicacion9.getComentarios().add(comentario29);
        publicacion10.getComentarios().add(comentario30);
        publicacion10.getComentarios().add(comentario31);
        publicacion10.getComentarios().add(comentario32);
        publicacion11.getComentarios().add(comentario33);
        publicacion11.getComentarios().add(comentario34);
        publicacion11.getComentarios().add(comentario35);
        vendedor1.setMuro(muro1);
        vendedor2.setMuro(muro2);
        vendedor3.setMuro(muro3);
        vendedor4.setMuro(muro4);
        vendedor5.setMuro(muro5);
        vendedor6.setMuro(muro6);
        vendedor7.setMuro(muro7);
        vendedor8.setMuro(muro8);
        muro1.getPublicacionesActivas().add(publicacion1);
        muro1.getPublicacionesActivas().add(publicacion2);
        muro2.getPublicacionesActivas().add(publicacion3);
        muro3.getPublicacionesActivas().add(publicacion4);
        muro4.getPublicacionesActivas().add(publicacion5);
        muro4.getPublicacionesActivas().add(publicacion6);
        muro5.getPublicacionesActivas().add(publicacion7);
        muro6.getPublicacionesActivas().add(publicacion8);
        muro6.getPublicacionesActivas().add(publicacion9);
        muro7.getPublicacionesActivas().add(publicacion10);
        muro7.getPublicacionesActivas().add(publicacion11);
        producto1.setPublicacion(publicacion1);
        producto2.setPublicacion(publicacion2);
        producto3.setPublicacion(publicacion3);
        producto4.setPublicacion(publicacion4);
        producto5.setPublicacion(publicacion5);
        producto6.setPublicacion(publicacion6);
        producto7.setPublicacion(publicacion7);
        producto8.setPublicacion(publicacion8);
        producto9.setPublicacion(publicacion9);
        producto10.setPublicacion(publicacion10);
        producto11.setPublicacion(publicacion11);

        return marketplaceObjeto;
    }
}
