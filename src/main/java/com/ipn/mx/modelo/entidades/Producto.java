package com.ipn.mx.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombreProducto", length = 50, nullable = false)
    @Size(min = 5, max = 50, message = "El nombre debe tener entre 5 y 50 caracteres")
    private String nombreProducto;

    @NotBlank(message = "La descripcion es obligatoria")
    @Column(name = "descripcionProducto", length = 250, nullable = false)
    @Size(min = 5, max = 250, message = "La descripciond ebe tener entre 5 y 250 caracteres")
    private String descripcionProducto;

    @NotNull(message = "La existencia es obligatora")
    @Column(name = "existencia", nullable = false)
    private int existencia;

    @NotNull(message = "El precio es obligatorio")
    @Column(name = "precio", nullable = false)
    private double precio;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria")
    private Categoria idCategoria;
}
