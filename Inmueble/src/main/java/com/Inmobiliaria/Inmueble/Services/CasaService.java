package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.CasaDTO;
import com.Inmobiliaria.Inmueble.Models.Casa;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Repositories.ICasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CasaService {
    private final ICasaRepository casaRepository;

    public CasaService(ICasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public List<CasaDTO> listarTodas() {
        return casaRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public CasaDTO agregarCasa(CasaDTO casaDTO) {
        Casa casa = convertirAEntidad(casaDTO);
        casaRepository.save(casa);
        return casaDTO;
    }

    private Casa convertirAEntidad(CasaDTO dto) {
        return new Casa(dto.getDireccion(), dto.getPrecio(), dto.isDisponible(),
                dto.getFechaPublicacion(),Operacion.valueOf(String.valueOf(dto.getOperacion())),
                dto.getDormitorios(), dto.getBanios(), dto.getGarage(), dto.getArea(),
                dto.getTamanioLote());
    }

    private CasaDTO convertirADTO(Casa casa) {
        return new CasaDTO(casa.getDireccion(), casa.getPrecio(), casa.isDisponible(),
                casa.getOperacion(), casa.getFechaPublicacion(),casa.getDormitorios(),
                casa.getBanios(),casa.getGarage(),casa.getArea(),casa.getTamanioLote());
    }
}
