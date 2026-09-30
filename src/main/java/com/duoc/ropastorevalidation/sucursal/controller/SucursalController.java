package com.duoc.ropastorevalidation.sucursal.controller;

import com.duoc.ropastorevalidation.sucursal.model.Sucursal;
import com.duoc.ropastorevalidation.sucursal.service.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> findAll() {
        return ResponseEntity.ok(sucursalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> findById(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalService.findById(id);
        return sucursal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sucursal> save(@RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.save(sucursal));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Sucursal> update(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.update(id, sucursal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalService.findById(id);
        if (sucursal.isPresent()) {
            Long oldId = sucursal.get().getId();
            sucursalService.delete(id);
            return ResponseEntity.ok(oldId);
        } else return ResponseEntity.notFound().build();
    }
}
