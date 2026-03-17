package com.Inmobiliaria.Inmueble.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inmueble_fotos")
public class InmuebleFoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoInmueble;

    @Column(nullable = false)
    private Integer inmuebleId;

    @Column(nullable = false, length = 500)
    private String imageUrl;

    @Column(nullable = false, length = 255, unique = true)
    private String publicId;

    @Column(nullable = false)
    private Integer orden = 0;

    @Column(nullable = false)
    private boolean portada = false;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoInmueble() { return tipoInmueble; }
    public void setTipoInmueble(String tipoInmueble) { this.tipoInmueble = tipoInmueble; }

    public Integer getInmuebleId() { return inmuebleId; }
    public void setInmuebleId(Integer inmuebleId) { this.inmuebleId = inmuebleId; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }

    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }

    public boolean isPortada() { return portada; }
    public void setPortada(boolean portada) { this.portada = portada; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}