package com.banco.springboot.app.banco.services;

import com.banco.springboot.app.banco.models.entity.Cuenta;

import java.util.List;

public interface ICuentaServices {
    
    public Cuenta getById(Long id, List<Cuenta> lista );

}
