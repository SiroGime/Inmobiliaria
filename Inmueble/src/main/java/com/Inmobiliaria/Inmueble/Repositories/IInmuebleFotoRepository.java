package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.InmuebleFoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IInmuebleFotoRepository extends JpaRepository<InmuebleFoto, Long> {
    List<InmuebleFoto> findByTipoInmuebleAndInmuebleIdOrderByOrdenAscIdAsc(String tipoInmueble, Integer inmuebleId);
    Optional<InmuebleFoto> findByIdAndTipoInmuebleAndInmuebleId(Long id, String tipoInmueble, Integer inmuebleId);
}