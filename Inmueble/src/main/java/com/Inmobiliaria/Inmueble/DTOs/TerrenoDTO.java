package com.Inmobiliaria.Inmueble.DTOs;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import lombok.*;

import java.time.LocalDate;



public class TerrenoDTO {
    private String direccion;
    private Double precio;
    private boolean disponible;
    private Operacion operacion;
    private LocalDate fechaPublicacion;

    private Long tamanioLote;

    public TerrenoDTO(){};

    public TerrenoDTO(String direccion, Double precio, boolean disponible, Operacion operacion, LocalDate fechaPublicacion, Long tamanioLote) {
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.operacion = operacion;
        this.fechaPublicacion = fechaPublicacion;
        this.tamanioLote = tamanioLote;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getTamanioLote() {
        return tamanioLote;
    }

    public void setTamanioLote(Long tamanioLote) {
        this.tamanioLote = tamanioLote;
    }
}
