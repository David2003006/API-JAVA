package com.banco.springboot.app.banco.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banco.springboot.app.banco.models.DAO.ICuentaDao;
import com.banco.springboot.app.banco.services.ICuentaServices;

@Component
public class CuentaPropertyEditor extends PropertyEditorSupport{
    
@Autowired
private ICuentaServices cuentaServices;

@Autowired
private ICuentaDao cuentaDao;

public void setAsText(String idStr) throws IllegalArgumentException{

    try{
        Long id= Long.parseLong(idStr);
        this.setValue(cuentaServices.getById(id, cuentaDao.findAll()));
    }catch (Exception e){
        System.out.println("hubo un erro:"+e);
    }

}


}
