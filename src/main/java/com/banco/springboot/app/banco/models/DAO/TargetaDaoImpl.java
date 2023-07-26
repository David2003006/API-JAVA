package com.banco.springboot.app.banco.models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banco.springboot.app.banco.models.entity.Targetas;

@Repository()
public class TargetaDaoImpl implements ITaregetaDao {

    @PersistenceContext
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Targetas> findAll() {
        return em.createQuery("from Targetas").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public void save(Targetas targeta) {
        
        if(targeta.getId() != null && targeta.getId() > 0){
            em.merge(targeta);
        }else{
            em.persist(targeta);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Targetas findOne(long id) {
        return em.find(Targetas.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public void Delete(Long id) {
        em.remove(findOne(id));
    }
    
}
