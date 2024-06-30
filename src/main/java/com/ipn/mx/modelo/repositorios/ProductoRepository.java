package com.ipn.mx.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.modelo.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
    
}
