package co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
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
    private UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDto(usuario.getUserName(), usuario.getPassword());
    }
    private Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        return Usuario.builder()
                .userName(usuarioDto.userName())
                .password(usuarioDto.password())
                .build();
    }
}
