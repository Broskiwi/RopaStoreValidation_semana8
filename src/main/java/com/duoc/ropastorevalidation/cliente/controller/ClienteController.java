package com.duoc.ropastorevalidation.cliente.controller;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import com.duoc.ropastorevalidation.cliente.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/?rut={rut}")
    public ResponseEntity<Cliente> findByRut(@PathVariable String rut){
        Optional<Cliente> cliente = clienteService.getByRut(rut);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.create(cliente));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente updated =  clienteService.update(id, cliente);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        Long deletedId = clienteService.deleteById(id);
        if(deletedId != null){
            return ResponseEntity.ok(deletedId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
