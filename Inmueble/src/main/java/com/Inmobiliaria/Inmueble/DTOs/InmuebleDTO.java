package com.Inmobiliaria.Inmueble.DTOs;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import lombok.*;

import java.time.LocalDate;



public class InmuebleDTO {
    private Integer id;
    private String tipoInmueble;
    private String direccion;
    private Double precio;
    private boolean disponible;
    private LocalDate fechaPublicacion;
    private Operacion operacion;

    public InmuebleDTO(){};

    public InmuebleDTO(Integer id, String tipoInmueble, String direccion, Double precio, boolean disponible, LocalDate fechaPublicacion, Operacion operacion) {
        this.id = id;
        this.tipoInmueble = tipoInmueble;
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaPublicacion = fechaPublicacion;
        this.operacion = operacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
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
}
