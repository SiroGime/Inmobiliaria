package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.DTOs.InmuebleFotoResponseDTO;
import com.Inmobiliaria.Inmueble.Models.InmuebleFoto;
import com.Inmobiliaria.Inmueble.Repositories.IInmuebleFotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class InmuebleFotoService {

    private final IInmuebleFotoRepository fotoRepository;
    private final CloudinaryStorageService storageService;

    public InmuebleFotoService(IInmuebleFotoRepository fotoRepository, CloudinaryStorageService storageService) {
        this.fotoRepository = fotoRepository;
        this.storageService = storageService;
    }

    public InmuebleFotoResponseDTO subirFoto(String tipoInmueble, Integer inmuebleId, MultipartFile file, Integer orden, boolean portada) throws IOException {
        String folder = "inmobiliaria/" + tipoInmueble.toLowerCase() + "/" + inmuebleId;
        Map result = storageService.upload(file, folder);

        InmuebleFoto foto = new InmuebleFoto();
        foto.setTipoInmueble(tipoInmueble.toUpperCase());
        foto.setInmuebleId(inmuebleId);
        foto.setImageUrl((String) result.get("secure_url"));
        foto.setPublicId((String) result.get("public_id"));
        foto.setOrden(orden == null ? 0 : orden);
        foto.setPortada(portada);

        InmuebleFoto saved = fotoRepository.save(foto);
        return toDto(saved);
    }

    public List<InmuebleFotoResponseDTO> listarFotos(String tipoInmueble, Integer inmuebleId) {
        return fotoRepository
                .findByTipoInmuebleAndInmuebleIdOrderByOrdenAscIdAsc(tipoInmueble.toUpperCase(), inmuebleId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    public void eliminarFoto(String tipoInmueble, Integer inmuebleId, Long fotoId) throws IOException {
        InmuebleFoto foto = fotoRepository
                .findByIdAndTipoInmuebleAndInmuebleId(fotoId, tipoInmueble.toUpperCase(), inmuebleId)
                .orElseThrow(() -> new RuntimeException("Foto no encontrada"));

        storageService.delete(foto.getPublicId());
        fotoRepository.delete(foto);
    }

    private InmuebleFotoResponseDTO toDto(InmuebleFoto f) {
        return new InmuebleFotoResponseDTO(f.getId(), f.getImageUrl(), f.getOrden(), f.isPortada());
    }
}