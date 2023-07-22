package com.banco.springboot.app.banco.models.DAO;

import java.util.List;
import com.banco.springboot.app.banco.models.entity.Targetas;

public interface ITaregetaDao {
    
    public List<Targetas> findAll();

    public void save(Targetas targeta);

    public Targetas findOne(long id);

    public void Delete(Long id);
}
