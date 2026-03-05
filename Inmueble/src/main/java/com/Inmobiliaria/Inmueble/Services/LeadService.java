package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.LeadRequestDTO;
import com.Inmobiliaria.Inmueble.DTOs.LeadResponseDTO;
import com.Inmobiliaria.Inmueble.Models.Lead;
import com.Inmobiliaria.Inmueble.Repositories.ILeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final ILeadRepository leadRepository;
    private final EmailNotificationService emailNotificationService;

    public LeadService(ILeadRepository leadRepository,
                       EmailNotificationService emailNotificationService) {
        this.leadRepository = leadRepository;
        this.emailNotificationService = emailNotificationService;
    }

    public LeadResponseDTO crearLead(LeadRequestDTO req) {
        Lead lead = new Lead();
        lead.setInmuebleId(req.getInmuebleId());
        lead.setNombre(req.getNombre());
        lead.setEmail(req.getEmail());
        lead.setTelefono(req.getTelefono());
        lead.setMensaje(req.getMensaje());
        lead.setEstado("NUEVO");

        Lead guardado = leadRepository.save(lead);
        emailNotificationService.notifyNewLead(guardado);

        return toDTO(guardado);
    }

    public List<LeadResponseDTO> listarLeads() {
        return leadRepository.findAllByOrderByFechaCreacionDesc()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private LeadResponseDTO toDTO(Lead l) {
        LeadResponseDTO dto = new LeadResponseDTO();
        dto.setId(l.getId());
        dto.setInmuebleId(l.getInmuebleId());
        dto.setNombre(l.getNombre());
        dto.setEmail(l.getEmail());
        dto.setTelefono(l.getTelefono());
        dto.setMensaje(l.getMensaje());
        dto.setEstado(l.getEstado());
        dto.setFechaCreacion(l.getFechaCreacion());
        return dto;
    }
}