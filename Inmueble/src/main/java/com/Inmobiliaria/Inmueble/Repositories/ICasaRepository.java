package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Casa;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICasaRepository extends JpaRepository<Casa, Integer> {
    List<Casa> findByOperacion(Operacion operacion);
}