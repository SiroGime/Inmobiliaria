package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.LocalDTO;
import com.Inmobiliaria.Inmueble.Models.Local;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Repositories.ILocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalService {
    private final ILocalRepository localRepository;

    public LocalService(ILocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public List<LocalDTO> listarTodas() {
        return localRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public LocalDTO agregarLocal(LocalDTO localDTO) {
        Local local = convertirAEntidad(localDTO);
        localRepository.save(local);
        return localDTO;
    }

    private Local convertirAEntidad(LocalDTO dto) {
        return new Local(dto.getDireccion(),dto.getPrecio(),
                dto.isDisponible(),dto.getFechaPublicacion(),dto.getOperacion(),
                dto.getBanios(),dto.getGarage(),dto.getArea(),dto.getTamanioLote(),
                dto.isTieneDeposito());
    }

    private LocalDTO convertirADTO(Local local) {
        return new LocalDTO(local.getDireccion(),local.getPrecio(),
                local.isDisponible(),local.getOperacion(),local.getFechaPublicacion(),
                local.getBanios(),local.getGarage(),local.getArea(),local.getTamanioLote(),
                local.isTieneDeposito());
    }
}
