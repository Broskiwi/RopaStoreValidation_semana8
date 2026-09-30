package com.duoc.ropastorevalidation.pedido.controller;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import com.duoc.ropastorevalidation.cliente.service.ClienteService;
import com.duoc.ropastorevalidation.pedido.model.Estado;
import com.duoc.ropastorevalidation.pedido.model.Pedido;
import com.duoc.ropastorevalidation.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;

    public PedidoController(PedidoService pedidoService, ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.ok(pedidoService.getAll());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pedido>> findByClienteId(@PathVariable Long id){
        Optional<Cliente> realCliente = clienteService.getById(id);
        if(realCliente.isPresent()){
            Optional<List<Pedido>> pedidosCliente = pedidoService.getAllByClient(realCliente.get());
            return pedidosCliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        return ResponseEntity.ok(pedidoService.create(pedido));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido){
        Pedido updated =  pedidoService.update(id, pedido);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    @PostMapping("/status/{id}")
    public ResponseEntity<Pedido> updateStatus(@PathVariable Long id, @RequestBody Estado estado){
        Pedido updated = pedidoService.updateStatusById(id, estado);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updated);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        Long deletedId = pedidoService.deleteById(id);
        if(deletedId != null){
            return ResponseEntity.ok(deletedId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
