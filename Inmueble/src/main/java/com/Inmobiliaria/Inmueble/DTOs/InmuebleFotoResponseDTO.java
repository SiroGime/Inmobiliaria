package com.Inmobiliaria.Inmueble.DTOs;

public class InmuebleFotoResponseDTO {
    private Long id;
    private String imageUrl;
    private Integer orden;
    private boolean portada;

    public InmuebleFotoResponseDTO() {}

    public InmuebleFotoResponseDTO(Long id, String imageUrl, Integer orden, boolean portada) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.orden = orden;
        this.portada = portada;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }

    public boolean isPortada() { return portada; }
    public void setPortada(boolean portada) { this.portada = portada; }
}