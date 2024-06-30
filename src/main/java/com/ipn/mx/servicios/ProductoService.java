package com.ipn.mx.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Producto;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(Long id);
    public void deleteById(Long id);
    public Producto save(Producto producto);
}
