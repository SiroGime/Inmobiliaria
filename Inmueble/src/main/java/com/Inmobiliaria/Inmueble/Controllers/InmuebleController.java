package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.InmuebleDTO;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Services.InmuebleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {
    private final InmuebleService inmuebleService;

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @GetMapping("/operacion/{tipoOperacion}")
    public List<InmuebleDTO> buscarPorOperacion(@PathVariable Operacion tipoOperacion) {
        return inmuebleService.buscarPorOperacion(tipoOperacion);
    }
}
