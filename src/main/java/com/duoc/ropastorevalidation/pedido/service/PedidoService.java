package com.duoc.ropastorevalidation.pedido.service;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import com.duoc.ropastorevalidation.pedido.model.Estado;
import com.duoc.ropastorevalidation.pedido.model.Pedido;
import com.duoc.ropastorevalidation.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    public List<Pedido> getAllByClient(Cliente cliente) {
        return pedidoRepository.getAllByCliente(cliente);
    }

    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Long id, Pedido pedido) {
        Optional<Pedido> oldPedido = Optional.ofNullable(getById(id));
        if (oldPedido.isPresent()) {
            oldPedido.get().setEstado(pedido.getEstado());
            oldPedido.get().setFechaPedido(pedido.getFechaPedido());
            oldPedido.get().setTotal(pedido.getTotal());
            return pedidoRepository.save(oldPedido.get());
        } else {
            return null;
        }
    }
    public Pedido updateStatusById(Long id, Estado estado) {
        Optional<Pedido> oldPedido = Optional.ofNullable(getById(id));
        if (oldPedido.isPresent()) {
            oldPedido.get().setEstado(estado);
            return pedidoRepository.save(oldPedido.get());
        } else  {
            return null;
        }
    }

    public Long deleteById(Long id) {
        Optional<Pedido> oldCliente = Optional.ofNullable(getById(id));
        if (oldCliente.isPresent()) {
            pedidoRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }
}
