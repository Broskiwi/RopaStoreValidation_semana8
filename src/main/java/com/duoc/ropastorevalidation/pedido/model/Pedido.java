package com.duoc.ropastorevalidation.pedido.model;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    private LocalDate fechaPedido;
    private int total;
    private Estado estado = Estado.CREADO;

    public Pedido() {
    }

    public Pedido(Cliente cliente, LocalDate fechaPedido, int total, Estado estado) {
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
