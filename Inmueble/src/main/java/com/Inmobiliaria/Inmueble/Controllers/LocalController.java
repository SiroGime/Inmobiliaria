package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.LocalDTO;
import com.Inmobiliaria.Inmueble.Services.LocalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {
    private final LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping
    public List<LocalDTO> listarLocales() {
        return localService.listarTodas();
    }

    @PostMapping
    public LocalDTO agregarLocal(@RequestBody LocalDTO localDTO) {
        return localService.agregarLocal(localDTO);
    }
}
