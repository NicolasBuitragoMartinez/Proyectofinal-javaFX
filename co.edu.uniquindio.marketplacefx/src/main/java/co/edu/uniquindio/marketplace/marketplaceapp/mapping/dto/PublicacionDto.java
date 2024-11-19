package co.edu.uniquindio.marketplace.marketplaceapp.mapping.dto;

import java.util.List;

public record PublicacionDto(int like,
                             ProductoDto producto,
                             List<ComentarioDto> comentario) {
}
