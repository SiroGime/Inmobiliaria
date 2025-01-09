package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Departamento;
import com.Inmobiliaria.Inmueble.Models.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {
    List<Departamento> findByOperacion(Operacion operacion);
}
