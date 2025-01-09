package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.DepartamentoDTO;
import com.Inmobiliaria.Inmueble.Services.DepartamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<DepartamentoDTO> listarDepartamentos() {
        return departamentoService.listarTodas();
    }

    @PostMapping
    public DepartamentoDTO agregarDepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        return departamentoService.agregarDepartamento(departamentoDTO);
    }
}
