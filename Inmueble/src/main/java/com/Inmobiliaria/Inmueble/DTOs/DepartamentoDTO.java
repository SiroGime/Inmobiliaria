package com.Inmobiliaria.Inmueble.DTOs;

import com.Inmobiliaria.Inmueble.Models.Operacion;
import lombok.*;

import java.time.LocalDate;


public class DepartamentoDTO{
    private String direccion;
    private Double precio;
    private boolean disponible;
    private Operacion operacion;
    private LocalDate fechaPublicacion;

    private Integer dormitorios;
    private Integer banios;
    private Integer garage;
    private Integer piso;
    private Double expensas;
    private Long area;
    private Long tamanioLote;

    public DepartamentoDTO(){};

    public DepartamentoDTO(String direccion, Double precio, boolean disponible, Operacion operacion, LocalDate fechaPublicacion, Integer dormitorios, Integer banios, Integer garage, Integer piso, Double expensas, Long area, Long tamanioLote) {
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
        this.operacion = operacion;
        this.fechaPublicacion = fechaPublicacion;
        this.dormitorios = dormitorios;
        this.banios = banios;
        this.garage = garage;
        this.piso = piso;
        this.expensas = expensas;
        this.area = area;
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

    public Integer getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
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

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Double getExpensas() {
        return expensas;
    }

    public void setExpensas(Double expensas) {
        this.expensas = expensas;
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
}
