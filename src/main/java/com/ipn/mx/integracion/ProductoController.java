package com.ipn.mx.integracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.servicios.ProductoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/apiProducto")
public class ProductoController {
    @Autowired
    ProductoService service;

    @GetMapping("/productos")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Producto> mostrarProductos(){
        return service.findAll();
    }

    @GetMapping("/productos/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Producto mostrarProducto(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/productos")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminarProducto(@PathVariable Long id){
        service.deleteById(id);
    }
    
    @PutMapping("productos/{id}")
    public Producto actuazlizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = service.findById(id);
        p.setDescripcionProducto(producto.getDescripcionProducto());
        p.setExistencia(producto.getExistencia());
        p.setIdCategoria(producto.getIdCategoria());
        p.setNombreProducto(producto.getNombreProducto());
        p.setPrecio(producto.getPrecio());
        return service.save(producto);
    }
}
