package com.banco.springboot.app.banco.models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banco.springboot.app.banco.models.entity.Cuenta;

@Repository("cuentaDao")
public class CuentaDaoImpl implements ICuentaDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cuenta> findAll() {
        
        return em.createQuery("from Cuenta").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public void save(Cuenta cuenta) {
        
        if(cuenta.getId() != null && cuenta.getId() > 0){
            em.merge(cuenta);
        }else{
            em.persist(cuenta);
        }
    }

    
    
}
