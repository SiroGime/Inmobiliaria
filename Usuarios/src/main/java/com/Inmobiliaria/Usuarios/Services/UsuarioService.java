package com.Inmobiliaria.Usuarios.Services;

import com.Inmobiliaria.Usuarios.DTOs.UsuarioDTO;
import com.Inmobiliaria.Usuarios.Models.Usuario;
import com.Inmobiliaria.Usuarios.Repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail()))
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> obtenerUsuario(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail()));
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizarUsuario(Integer id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existingUsuario -> {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        });
    }

    public boolean eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}