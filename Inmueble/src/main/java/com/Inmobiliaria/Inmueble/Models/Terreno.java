package com.Inmobiliaria.Inmueble.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
public class Terreno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String direccion;
    private Double precio;
    private boolean disponible;
    private LocalDate fechaPublicacion;

    @Enumerated(EnumType.STRING)
    private Operacion operacion;

    private Long tamanioLote;

    public Terreno(){};
    public Terreno(String direccion, Double precio, boolean disponible, LocalDate fechaPublicacion, Operacion operacion, Long tamanioLote) {
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaPublicacion = fechaPublicacion;
        this.operacion = operacion;
        this.tamanioLote = tamanioLote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Long getTamanioLote() {
        return tamanioLote;
    }

    public void setTamanioLote(Long tamanioLote) {
        this.tamanioLote = tamanioLote;
    }
}
