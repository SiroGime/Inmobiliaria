package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.DepartamentoDTO;
import com.Inmobiliaria.Inmueble.Models.Departamento;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Repositories.IDepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {
    private final IDepartamentoRepository departamentoRepository;

    public DepartamentoService(IDepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<DepartamentoDTO> listarTodas() {
        return departamentoRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DepartamentoDTO agregarDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento departamento = convertirAEntidad(departamentoDTO);
        departamentoRepository.save(departamento);
        return departamentoDTO;
    }

    private Departamento convertirAEntidad(DepartamentoDTO dto) {
        return new Departamento(dto.getDireccion(),dto.getPrecio(),
                dto.isDisponible(),dto.getFechaPublicacion(),dto.getOperacion(),dto.getDormitorios(),
                dto.getBanios(),dto.getGarage(),dto.getPiso(),dto.getExpensas(),dto.getArea(),
                dto.getTamanioLote());
    }

    private DepartamentoDTO convertirADTO(Departamento departamento) {
        return new DepartamentoDTO(departamento.getDireccion(),
                departamento.getPrecio(),departamento.isDisponible(),departamento.getOperacion(),
                departamento.getFechaPublicacion(),departamento.getDormitorios(),departamento.getBanios(),
                departamento.getGarage(), departamento.getPiso(), departamento.getExpensas(),
                departamento.getArea(),departamento.getTamanioLote());
    }
}
