package com.Inmobiliaria.Inmueble.DTOs;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import lombok.*;

import java.time.LocalDate;


public class LocalDTO {
    private String direccion;
    private Double precio;
    private boolean disponible;
    private Operacion operacion;
    private LocalDate fechaPublicacion;

    private Integer banios;
    private Integer garage;
    private Long area;
    private Long tamanioLote;
    private boolean tieneDeposito;

    public LocalDTO(){};

    public LocalDTO(String direccion, Double precio, boolean disponible, Operacion operacion, LocalDate fechaPublicacion, Integer banios, Integer garage, Long area, Long tamanioLote, boolean tieneDeposito) {
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.operacion = operacion;
        this.fechaPublicacion = fechaPublicacion;
        this.banios = banios;
        this.garage = garage;
        this.area = area;
        this.tamanioLote = tamanioLote;
        this.tieneDeposito = tieneDeposito;
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

    public Integer getBanios() {
        return banios;
    }

    public void setBanios(Integer banios) {
        this.banios = banios;
    }

    public Integer getGarage() {
        return garage;
    }

    public void setGarage(Integer garage) {
        this.garage = garage;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getTamanioLote() {
        return tamanioLote;
    }

    public void setTamanioLote(Long tamanioLote) {
        this.tamanioLote = tamanioLote;
    }

    public boolean isTieneDeposito() {
        return tieneDeposito;
    }

    public void setTieneDeposito(boolean tieneDeposito) {
        this.tieneDeposito = tieneDeposito;
    }
}
