package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Models.PH;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPHRepository extends JpaRepository<PH, Integer> {
    List<PH> findByOperacion(Operacion operacion);
}