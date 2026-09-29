package com.duoc.ropastorevalidation.producto.service;

import com.duoc.ropastorevalidation.producto.model.Producto;
import com.duoc.ropastorevalidation.producto.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        return  productoRepository.findById(id).orElse(null);
    }

    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto producto) {
        Optional<Producto> oldProduct  = Optional.ofNullable(findById(id));
        if(oldProduct.isPresent()){
            oldProduct.get().setNombre(producto.getNombre());
            oldProduct.get().setPrecio(producto.getPrecio());
            oldProduct.get().setCategoria(producto.getCategoria());
            return  productoRepository.save(oldProduct.get());
        } else return  null;
    }
    public Long deleteById(Long id) {
        Optional<Producto> oldProduct = Optional.ofNullable(findById(id));
        if(oldProduct.isPresent()){
            Long deletedId = oldProduct.get().getId();
            productoRepository.deleteById(id);
            return deletedId;
        } else {
            return null;
        }
    }
}
