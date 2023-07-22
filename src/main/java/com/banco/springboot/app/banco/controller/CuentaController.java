package com.banco.springboot.app.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banco.springboot.app.banco.models.DAO.ICuentaDao;

@Controller
public class CuentaController {
    
    @Autowired
    private ICuentaDao cuentaDao;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public String cuentaLista(Model model){ 
     model.addAttribute("titulo", "Lista Cuenta");
     model.addAttribute("cuentas", cuentaDao.findAll());
    return "lista";
    }
}
