package co.edu.uniquindio.marketplace.marketplaceapp.factory;

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
}
