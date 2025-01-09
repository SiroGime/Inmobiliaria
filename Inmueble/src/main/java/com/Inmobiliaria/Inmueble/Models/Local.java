package com.Inmobiliaria.Inmueble.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
public class Local{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String direccion;
    private Double precio;
    private boolean disponible;
    private LocalDate fechaPublicacion;

    @Enumerated(EnumType.STRING)
    private Operacion operacion;

    private Integer banios;
    private Integer garage;
    private Long area;
    private Long tamanioLote;
    private boolean tieneDeposito;

    public Local(){};
    public Local(String direccion, Double precio, boolean disponible, LocalDate fechaPublicacion, Operacion operacion, Integer banios, Integer garage, Long area, Long tamanioLote, boolean tieneDeposito) {
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaPublicacion = fechaPublicacion;
        this.operacion = operacion;
        this.banios = banios;
        this.garage = garage;
        this.area = area;
        this.tamanioLote = tamanioLote;
        this.tieneDeposito = tieneDeposito;
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
