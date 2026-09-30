package com.duoc.ropastorevalidation.producto.controller;

import com.duoc.ropastorevalidation.producto.model.Producto;
import com.duoc.ropastorevalidation.producto.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id){
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.create(producto));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto){
        Producto updated = productoService.update(id, producto);
        if(updated == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        Long deletedId = productoService.deleteById(id);
        if(deletedId != null){
            return ResponseEntity.ok(deletedId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
