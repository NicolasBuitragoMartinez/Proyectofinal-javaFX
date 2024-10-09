package co.edu.uniquindio.marketplace.marketplaceapp.factory;

import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplace.marketplaceapp.mapping.mappers.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplace.marketplaceapp.model.MarketplaceObjeto;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IModelFactoryService;
import co.edu.uniquindio.marketplace.marketplaceapp.service.IMarketplaceMapping;
import co.edu.uniquindio.marketplace.marketplaceapp.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private MarketplaceObjeto marketplaceObjeto;
    private IMarketplaceMapping mapper;
    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }
    private ModelFactory(){
        mapper = new MarketplaceMappingImpl();
        marketplaceObjeto = DataUtil.inicializarDatos();
    }
    @Override
    public List<VendedorDto> obtenerVendedores() {
        return mapper.getVendedoresDto(marketplaceObjeto.getListaVendedores());
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


}
