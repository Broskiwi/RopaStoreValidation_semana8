package com.duoc.ropastorevalidation.sucursal.service;

import com.duoc.ropastorevalidation.sucursal.repository.SucursalRepository;
import org.springframework.stereotype.Service;

@Service
public class SucursalServicio {
    private final SucursalRepository sucursalRepository;
    public SucursalServicio(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }


}
