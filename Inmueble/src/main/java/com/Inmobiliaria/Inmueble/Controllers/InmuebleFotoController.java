package com.Inmobiliaria.Inmueble.Controllers;

import com.Inmobiliaria.Inmueble.DTOs.InmuebleFotoResponseDTO;
import com.Inmobiliaria.Inmueble.Services.InmuebleFotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InmuebleFotoController {

    private final InmuebleFotoService fotoService;

    public InmuebleFotoController(InmuebleFotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping("/inmuebles/{tipoInmueble}/{inmuebleId}/fotos")
    public ResponseEntity<List<InmuebleFotoResponseDTO>> listarFotos(
            @PathVariable String tipoInmueble,
            @PathVariable Integer inmuebleId
    ) {
        return ResponseEntity.ok(fotoService.listarFotos(tipoInmueble, inmuebleId));
    }

    @PostMapping("/admin/inmuebles/{tipoInmueble}/{inmuebleId}/fotos")
    public ResponseEntity<InmuebleFotoResponseDTO> subirFoto(
            @PathVariable String tipoInmueble,
            @PathVariable Integer inmuebleId,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "orden", required = false) Integer orden,
            @RequestParam(value = "portada", defaultValue = "false") boolean portada
    ) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(fotoService.subirFoto(tipoInmueble, inmuebleId, file, orden, portada));
    }

    @DeleteMapping("/admin/inmuebles/{tipoInmueble}/{inmuebleId}/fotos/{fotoId}")
    public ResponseEntity<Void> eliminarFoto(
            @PathVariable String tipoInmueble,
            @PathVariable Integer inmuebleId,
            @PathVariable Long fotoId
    ) throws IOException {
        fotoService.eliminarFoto(tipoInmueble, inmuebleId, fotoId);
        return ResponseEntity.noContent().build();
    }
}