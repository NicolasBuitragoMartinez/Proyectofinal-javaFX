package co.edu.uniquindio.marketplace.marketplaceapp.patrones.factory;

import co.edu.uniquindio.marketplace.marketplaceapp.constants.EstadoProducto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.*;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Comentario;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Persona;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.GarantiaExtendidaDecorator;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.ProductoBase;
import co.edu.uniquindio.marketplace.marketplaceapp.patrones.decorator.PromocionDecorator;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IModelFactoryService;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceMapping;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketplaceObjeto marketplaceObjeto;
    private IMarketplaceMapping mapper;

    public static ModelFactory getInstancia() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory() {
        mapper = new MarketplaceMappingImpl();
        marketplaceObjeto = DataUtil.inicializarDatos();
    }
    @Override
    public List<VendedorDto> obtenerVendedores() {
        return mapper.getVendedoresDto(marketplaceObjeto.getListaVendedores());
    }
    @Override
    public List<VendedorDto> obtenerVendedoresAgregados(String cedulaVendedor){
        return mapper.getVendedoresDto(marketplaceObjeto.obtenerListaVendedorAgregado(cedulaVendedor));
    }
    @Override
    public VendedorDto obtenerVendedores(String cedula) {
        return mapper.vendedorToVendedorDto(marketplaceObjeto.obtenerVendedor(cedula));
    }
    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return marketplaceObjeto.crearVendedor(mapper.vendedorDtoToVendedor(vendedorDto));
    }
    @Override
    public boolean eliminarVendedor(VendedorDto vendedorDto) {
        return marketplaceObjeto.eliminarVendedor(mapper.vendedorDtoToVendedor(vendedorDto));
    }
    @Override
    public boolean actualizarVendedor(VendedorDto vendedorDto) {
        return marketplaceObjeto.actualizarVendedor(mapper.vendedorDtoToVendedor(vendedorDto));
    }
    @Override
    public List<UsuarioDto> obtenerUsuarios() {

        return mapper.getUsuariosDto(marketplaceObjeto.getListaUsuarios());
    }
    @Override
    public List<ProductoDto> obtenerProductos() {
        return mapper.getProductosDto(marketplaceObjeto.obtenerListaProducto());
    }
    @Override
    public List<ProductoDto> obtenerProductosPorVendedor(String cedulaVendedor) {
        return mapper.getProductosDto(marketplaceObjeto.obtenerProductosPorVendedor(cedulaVendedor));
    }
    @Override
    public List<ProductoDto> obtenerProductosPublicados(String cedulaVendedor) {
        return mapper.getProductosDto(marketplaceObjeto.obtenerProductosPorEstado(cedulaVendedor, EstadoProducto.PUBLICADO, EstadoProducto.VENDIDO));
    }
    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        return marketplaceObjeto.crearProducto(mapper.productoDtoToProducto(productoDto));
    }
    @Override
    public boolean eliminarProducto(ProductoDto productoDto) {
        return marketplaceObjeto.eliminarProducto(mapper.productoDtoToProducto(productoDto));
    }
    @Override
    public boolean actualizarProducto(ProductoDto productoDto) {
        return marketplaceObjeto.actualizarProducto(mapper.productoDtoToProducto(productoDto));
    }
    @Override
    public int obtenerLikesPublicacion(String identificadorProducto) {
        return marketplaceObjeto.obtenerLikesPublicacion(identificadorProducto);
    }
    @Override
    public List<ComentarioDto> obtenerComentariosPublicacion(String identificadorProducto){
        return mapper.getComentariosDto(marketplaceObjeto.obtenerComentariosPublicacion(identificadorProducto));
    }
    @Override
    public boolean incrementarLikesPublicacion(String identificadorProducto) {
        return marketplaceObjeto.incrementarLikesPublicacion(identificadorProducto);
    }
    @Override
    public boolean agregearComentariosPublicacion(String identificadorProducto, ComentarioDto comentarioDto){
        return marketplaceObjeto.agregarComentarioPublicacion(identificadorProducto, mapper.comentarioDtoToComentario(comentarioDto));
    }
    public Persona validarUsuario(String username, String contrasena) throws Exception{
        return marketplaceObjeto.validarUsuario(username, contrasena);
    }




    public void mostrarProductoConDecoradores() {
        Producto productoBase = new ProductoBase("Laptop Gaming", 1200.0);

        Producto productoConGarantia = new GarantiaExtendidaDecorator(productoBase);

        Producto productoConPromocion = new PromocionDecorator(productoConGarantia);

        System.out.println("Descripción: " + productoConPromocion.getDescripcion());
        System.out.println("Precio final: $" + productoConPromocion.getPrecio());
    }
}