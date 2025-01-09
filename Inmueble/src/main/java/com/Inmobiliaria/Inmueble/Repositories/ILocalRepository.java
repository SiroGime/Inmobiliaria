package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Local;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILocalRepository extends JpaRepository<Local, Integer> {
    List<Local> findByOperacion(Operacion operacion);
}