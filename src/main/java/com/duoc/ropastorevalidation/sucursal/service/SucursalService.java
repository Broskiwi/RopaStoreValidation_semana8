package com.duoc.ropastorevalidation.sucursal.service;

import com.duoc.ropastorevalidation.sucursal.model.Sucursal;
import com.duoc.ropastorevalidation.sucursal.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {
    private final SucursalRepository sucursalRepository;
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Optional<Sucursal> findById(Long id) {
        return Optional.of(sucursalRepository.findById(id)).orElse(null);
    }

    public Sucursal update(Long id, Sucursal sucursal) {
        Optional<Sucursal> optionalSucursal = findById(id);
        if (optionalSucursal.isPresent()) {
            return sucursalRepository.save(sucursal);
        } else {
            return null;
        }
    }

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void delete(Long id) {
        sucursalRepository.deleteById(id);
    }

}
