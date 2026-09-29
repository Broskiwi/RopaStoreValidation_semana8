package com.duoc.ropastorevalidation.sucursal.repository;

import com.duoc.ropastorevalidation.sucursal.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
