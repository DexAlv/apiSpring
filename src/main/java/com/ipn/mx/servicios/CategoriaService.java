package com.ipn.mx.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Categoria;

public interface CategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(Long Id);
    public void deleteById(Long Id);
    public Categoria save(Categoria categoria);
}
