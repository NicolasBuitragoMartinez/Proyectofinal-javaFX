package co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.ProductoDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.PublicacionDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Producto;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Publicacion;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Usuario;
import co.edu.uniquindio.marketplace.marketplaceapp.model.Vendedor;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {
    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores == null){
            return null;
        }
        List<VendedorDto> listaVendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
        for (Vendedor vendedor : listaVendedores) {
            listaVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return listaVendedoresDto;
    }
    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        UsuarioDto usuarioDto = usuarioToUsuarioDto(vendedor.getUsuario());
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                usuarioDto
        );
    }
    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        Usuario usuario = usuarioDtoToUsuario(vendedorDto.usuario());
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(usuario)
                .build();
    }
    @Override
    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if(listaUsuarios == null){
            return null;
        }
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            listaUsuariosDto.add(usuarioToUsuarioDto(usuario));
        }
        return listaUsuariosDto;
    }
    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(usuario.getUserName(), usuario.getPassword());
    }
    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        return Usuario.builder()
                .userName(usuarioDto.userName())
                .password(usuarioDto.password())
                .build();
    }
    @Override
    public List<ProductoDto> getProductosDto(List<Producto> listaProductos) {
        if(listaProductos == null){
            return null;
        }
        List<ProductoDto> listaProductosDto = new ArrayList<ProductoDto>(listaProductos.size());
        for(Producto producto : listaProductos){
            listaProductosDto.add(productoToProductoDto(producto));
        }
        return listaProductosDto;
    }
    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getIdentificador(),
                producto.getImagen(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getEstado()
        );
    }
    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .nombre(productoDto.nombre())
                .identificador(productoDto.identificador())
                .imagen(productoDto.imagen())
                .categoria(productoDto.categoria())
                .precio(productoDto.precio())
                .estado(productoDto.estado())
                .build();
    }
    @Override
    public List<PublicacionDto> getPublicacionesDto(List<Publicacion> listaPublicaciones) {
        if(listaPublicaciones == null){
            return null;
        }
        List<PublicacionDto> listaPublicacionesDto = new ArrayList<PublicacionDto>(listaPublicaciones.size());
        for(Publicacion publicacion : listaPublicaciones){
            listaPublicacionesDto.add(publicacionToPublicacionDto(publicacion));
        }
        return listaPublicacionesDto;
    }
    @Override
    public PublicacionDto publicacionToPublicacionDto(Publicacion publicacion) {
        ProductoDto productoDto = productoToProductoDto(publicacion.getProducto());
        return new PublicacionDto(
                publicacion.getLike(),
                productoDto
        );
    }
    @Override
    public Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto) {
        Producto producto = productoDtoToProducto(publicacionDto.producto());
        return Publicacion.builder()
                .like(publicacionDto.like())
                .producto(producto)
                .build();
    }
}
