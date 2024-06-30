package com.ipn.mx.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.modelo.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    ProductoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        Optional<Producto> productoOptional = repository.findById(id);
        return productoOptional.orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return repository.save(producto);
    }
}
