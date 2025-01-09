package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.CasaDTO;
import com.Inmobiliaria.Inmueble.Services.CasaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casa")
public class CasaController {
    private final CasaService casaService;

    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @GetMapping
    public List<CasaDTO> listarCasas() {
        return casaService.listarTodas();
    }

    @PostMapping
    public CasaDTO agregarCasa(@RequestBody CasaDTO casaDTO) {
        return casaService.agregarCasa(casaDTO);
    }
}
