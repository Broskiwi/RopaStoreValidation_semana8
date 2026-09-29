package com.duoc.ropastorevalidation.pedido.repository;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import com.duoc.ropastorevalidation.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> getAllByCliente(Cliente cliente);
}
