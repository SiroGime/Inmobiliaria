package com.Inmobiliaria.Inmueble.DTOs;

import java.time.LocalDateTime;

public class LeadResponseDTO {
    private Integer id;
    private Integer inmuebleId;
    private String nombre;
    private String email;
    private String telefono;
    private String mensaje;
    private String estado;
    private LocalDateTime fechaCreacion;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getInmuebleId() { return inmuebleId; }
    public void setInmuebleId(Integer inmuebleId) { this.inmuebleId = inmuebleId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}