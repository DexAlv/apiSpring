package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Permite crear una clase accediendo a sus atributos directos
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 5, max = 250, message = "Debe de estar entre 5 y 250")
    @Column(name = "descripcionCategoria", length = 250, nullable = false)
    private String descripcionCategoria;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 50, message = "Debe de estar entre 5 y 250")
    @Column(name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria;

    @JsonManagedReference
    @JsonIgnoreProperties(value = { "idCategoria", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCategoria", cascade = CascadeType.ALL)
    private List<Producto> productos;
}