package com.Inmobiliaria.Usuarios.Repositories;

import com.Inmobiliaria.Usuarios.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
