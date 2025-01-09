package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.PHDTO;
import com.Inmobiliaria.Inmueble.Services.PHService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ph")
public class PHController {
    private final PHService phService;

    public PHController(PHService phService) {
        this.phService = phService;
    }

    @GetMapping
    public List<PHDTO> listarPHs() {
        return phService.listarTodas();
    }

    @PostMapping
    public PHDTO agregarPH(@RequestBody PHDTO phDTO) {
        return phService.agregarPH(phDTO);
    }
}
