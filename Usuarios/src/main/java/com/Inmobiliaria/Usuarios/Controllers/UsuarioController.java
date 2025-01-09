package com.Inmobiliaria.Usuarios.Controllers;

import com.Inmobiliaria.Usuarios.DTOs.UsuarioDTO;
import com.Inmobiliaria.Usuarios.Models.Usuario;
import com.Inmobiliaria.Usuarios.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Integer id) {
        return usuarioService.obtenerUsuario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@Validated @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(nuevoUsuario.getId(), nuevoUsuario.getNombre(), nuevoUsuario.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @Validated @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        if (usuarioService.eliminarUsuario(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
