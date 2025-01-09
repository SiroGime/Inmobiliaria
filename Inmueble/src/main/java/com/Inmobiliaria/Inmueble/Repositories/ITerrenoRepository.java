package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import com.Inmobiliaria.Inmueble.Models.PH;
import com.Inmobiliaria.Inmueble.Models.Terreno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITerrenoRepository extends JpaRepository<Terreno, Integer> {
    List<Terreno> findByOperacion(Operacion operacion);
}