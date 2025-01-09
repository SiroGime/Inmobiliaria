package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.TerrenoDTO;
import com.Inmobiliaria.Inmueble.Services.TerrenoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terreno")
public class TerrenoController {
    private final TerrenoService terrenoService;

    public TerrenoController(TerrenoService terrenoService) {
        this.terrenoService = terrenoService;
    }

    @GetMapping
    public List<TerrenoDTO> listarTerrenos() {
        return terrenoService.listarTodas();
    }

    @PostMapping
    public TerrenoDTO agregarTerreno(@RequestBody TerrenoDTO terrenoDTO) {
        return terrenoService.agregarTerreno(terrenoDTO);
    }
}
