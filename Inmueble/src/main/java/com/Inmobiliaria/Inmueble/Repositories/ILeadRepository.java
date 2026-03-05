package com.Inmobiliaria.Inmueble.Repositories;

import com.Inmobiliaria.Inmueble.Models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILeadRepository extends JpaRepository<Lead, Integer> {
    List<Lead> findByInmuebleIdOrderByFechaCreacionDesc(Integer inmuebleId);
    List<Lead> findAllByOrderByFechaCreacionDesc();
}