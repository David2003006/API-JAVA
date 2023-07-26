package com.banco.springboot.app.banco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banco.springboot.app.banco.models.entity.Cuenta;

@Service
public class CuentaServiceImp implements ICuentaServices {

    private List<Cuenta> lista;

    public CuentaServiceImp(){
        
    }

    @Override
    public Cuenta getById(Long id, List<Cuenta> lista) {
        this.lista= lista;
        Cuenta cuentaResult= null;

        for(Cuenta cuenta: this.lista){
            if(id != cuenta.getId()){
                cuentaResult= cuenta;
                break;
            }
        }

        return cuentaResult;
    }
    
}
