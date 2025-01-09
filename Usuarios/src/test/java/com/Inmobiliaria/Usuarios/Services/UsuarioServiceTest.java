package com.Inmobiliaria.Usuarios.Services;

import com.Inmobiliaria.Usuarios.DTOs.UsuarioDTO;
import com.Inmobiliaria.Usuarios.Models.Usuario;
import com.Inmobiliaria.Usuarios.Repositories.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @Mock
    private IUsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    public UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearUsuario() {
        Usuario usuario = new Usuario("Juan", "juan@example.com", "password");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.crearUsuario(usuario);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testObtenerUsuario() {
        Usuario usuario = new Usuario("Juan", "juan@example.com", "password");
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        Optional<UsuarioDTO> result = usuarioService.obtenerUsuario(1);

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
    }
}