package com.banco.springboot.app.banco.models.DAO;

import java.util.List;

import com.banco.springboot.app.banco.models.entity.Cuenta;


public interface ICuentaDao {
    
    public List<Cuenta> findAll();

    public void save(Cuenta cuenta);

    public Cuenta findOne(long id);

    public void delete(Long id);
}
