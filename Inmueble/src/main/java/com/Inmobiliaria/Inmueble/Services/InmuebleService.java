package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.InmuebleDTO;
import com.Inmobiliaria.Inmueble.Models.*;
import com.Inmobiliaria.Inmueble.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InmuebleService {
    private final ICasaRepository casaRepository;
    private final IDepartamentoRepository departamentoRepository;
    private final ILocalRepository localRepository;
    private final IPHRepository phRepository;
    private final ITerrenoRepository terrenoRepository;

    public InmuebleService(
            ICasaRepository casaRepository,
            IDepartamentoRepository departamentoRepository,
            ILocalRepository localRepository,
            IPHRepository phRepository,
            ITerrenoRepository terrenoRepository) {
        this.casaRepository = casaRepository;
        this.departamentoRepository = departamentoRepository;
        this.localRepository = localRepository;
        this.phRepository = phRepository;
        this.terrenoRepository = terrenoRepository;
    }

    public List<InmuebleDTO> buscarPorOperacion(Operacion operacion) {
        List<InmuebleDTO> resultados = new ArrayList<>();

        // Buscar casas
        casaRepository.findByOperacion(operacion).forEach(casa -> resultados.add(convertirAInmuebleDTO(casa)));

        // Buscar departamentos
        departamentoRepository.findByOperacion(operacion).forEach(depto -> resultados.add(convertirAInmuebleDTO(depto)));

        // Buscar locales
        localRepository.findByOperacion(operacion).forEach(local -> resultados.add(convertirAInmuebleDTO(local)));

        // Buscar PHs
        phRepository.findByOperacion(operacion).forEach(ph -> resultados.add(convertirAInmuebleDTO(ph)));

        // Buscar terrenos
        terrenoRepository.findByOperacion(operacion).forEach(terreno -> resultados.add(convertirAInmuebleDTO(terreno)));

        return resultados;
    }

    private InmuebleDTO convertirAInmuebleDTO(Object entidad) {
        InmuebleDTO dto = new InmuebleDTO();
        if (entidad instanceof Casa casa) {
            dto.setId(casa.getId());
            dto.setDireccion(casa.getDireccion());
            dto.setPrecio(casa.getPrecio());
            dto.setDisponible(casa.isDisponible());
            dto.setFechaPublicacion(casa.getFechaPublicacion());
            dto.setOperacion(casa.getOperacion());
        } else if (entidad instanceof Departamento depto) {
            dto.setId(depto.getId());
            dto.setDireccion(depto.getDireccion());
            dto.setPrecio(depto.getPrecio());
            dto.setDisponible(depto.isDisponible());
            dto.setFechaPublicacion(depto.getFechaPublicacion());
            dto.setOperacion(depto.getOperacion());
        } else if (entidad instanceof Local local) {
            dto.setId(local.getId());
            dto.setDireccion(local.getDireccion());
            dto.setPrecio(local.getPrecio());
            dto.setDisponible(local.isDisponible());
            dto.setFechaPublicacion(local.getFechaPublicacion());
            dto.setOperacion(local.getOperacion());
        } else if (entidad instanceof PH ph) {
            dto.setId(ph.getId());
            dto.setDireccion(ph.getDireccion());
            dto.setPrecio(ph.getPrecio());
            dto.setDisponible(ph.isDisponible());
            dto.setFechaPublicacion(ph.getFechaPublicacion());
            dto.setOperacion(ph.getOperacion());
        } else if (entidad instanceof Terreno terreno) {
            dto.setId(terreno.getId());
            dto.setDireccion(terreno.getDireccion());
            dto.setPrecio(terreno.getPrecio());
            dto.setDisponible(terreno.isDisponible());
            dto.setFechaPublicacion(terreno.getFechaPublicacion());
            dto.setOperacion(terreno.getOperacion());
        }
        dto.setTipoInmueble(entidad.getClass().getSimpleName());
        return dto;
    }
}
