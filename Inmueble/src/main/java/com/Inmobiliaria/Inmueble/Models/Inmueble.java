//package com.Inmobiliaria.Inmueble.Models;
//
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "tipo_inmueble", discriminatorType = DiscriminatorType.STRING)
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Casa.class, name = "CASA"),
//        @JsonSubTypes.Type(value = Departamento.class, name = "DEPARTAMENTO"),
//        @JsonSubTypes.Type(value = Local.class, name = "LOCAL"),
//        @JsonSubTypes.Type(value = PH.class, name = "PH"),
//        @JsonSubTypes.Type(value = Terreno.class, name = "TERRENO")
//})
//@Data
//public abstract class Inmueble {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String tipo;
//
//    @Column(name = "direccion")
//    private String direccion;
//
//    @Column(name = "precio")
//    private Double precio;
//
//    @Column(name = "disponible")
//    private boolean disponible;
//
//    @Column(name = "fecha_publicacion")
//    private LocalDate fechaPublicacion;
//
//    @Column(name = "operacion")
//    @Enumerated(EnumType.STRING)
//    private Operacion operacion;
//}
//