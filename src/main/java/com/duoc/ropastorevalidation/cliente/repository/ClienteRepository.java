package com.duoc.ropastorevalidation.cliente.repository;

import com.duoc.ropastorevalidation.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByRut(String rut);
}
