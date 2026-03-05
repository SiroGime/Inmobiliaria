package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.LeadRequestDTO;
import com.Inmobiliaria.Inmueble.DTOs.LeadResponseDTO;
import com.Inmobiliaria.Inmueble.Services.LeadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    // Público (formulario web)
    @PostMapping("/leads")
    public ResponseEntity<LeadResponseDTO> crearLead(@Valid @RequestBody LeadRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(leadService.crearLead(request));
    }

    // Privado (panel inmobiliario)
    @GetMapping("/admin/leads")
    public ResponseEntity<List<LeadResponseDTO>> listarLeads() {
        return ResponseEntity.ok(leadService.listarLeads());
    }
}