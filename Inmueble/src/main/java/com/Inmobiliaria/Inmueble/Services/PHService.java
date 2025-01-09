package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.PHDTO;
import com.Inmobiliaria.Inmueble.Models.PH;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Repositories.IPHRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PHService {
    private final IPHRepository phRepository;

    public PHService(IPHRepository phRepository) {
        this.phRepository = phRepository;
    }

    public List<PHDTO> listarTodas() {
        return phRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public PHDTO agregarPH(PHDTO phDTO) {
        PH ph = convertirAEntidad(phDTO);
        phRepository.save(ph);
        return phDTO;
    }

    private PH convertirAEntidad(PHDTO dto) {
        return new PH(dto.getDireccion(),dto.getPrecio(),dto.isDisponible(),
                dto.getFechaPublicacion(),dto.getOperacion(),dto.getDormitorios(),
                dto.getBanios(),dto.getGarage(),dto.getArea(),dto.getTamanioLote());
    }

    private PHDTO convertirADTO(PH ph) {
        return new PHDTO(ph.getDireccion(),ph.getPrecio(),
                ph.isDisponible(),ph.getOperacion(),ph.getFechaPublicacion(),
                ph.getDormitorios(),ph.getBanios(),ph.getGarage(),
                ph.getArea(),ph.getTamanioLote());
    }
}
