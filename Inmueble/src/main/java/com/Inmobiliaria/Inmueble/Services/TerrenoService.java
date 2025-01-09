package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.TerrenoDTO;
import com.Inmobiliaria.Inmueble.Models.Terreno;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Repositories.ITerrenoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerrenoService {
    private final ITerrenoRepository terrenoRepository;

    public TerrenoService(ITerrenoRepository terrenoRepository) {
        this.terrenoRepository = terrenoRepository;
    }

    public List<TerrenoDTO> listarTodas() {
        return terrenoRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public TerrenoDTO agregarTerreno(TerrenoDTO terrenoDTO) {
        Terreno terreno = convertirAEntidad(terrenoDTO);
        terrenoRepository.save(terreno);
        return terrenoDTO;
    }

    private Terreno convertirAEntidad(TerrenoDTO dto) {
        return new Terreno(dto.getDireccion(),dto.getPrecio(),
                dto.isDisponible(),dto.getFechaPublicacion(),
                dto.getOperacion(),dto.getTamanioLote());
    }

    private TerrenoDTO convertirADTO(Terreno terreno) {
        return new TerrenoDTO(terreno.getDireccion(),terreno.getPrecio(),
                terreno.isDisponible(),terreno.getOperacion(),terreno.getFechaPublicacion(),
                terreno.getTamanioLote());
    }
}
