package com.banco.springboot.app.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

import javax.validation.Valid;

import com.banco.springboot.app.banco.models.DAO.ICuentaDao;
import com.banco.springboot.app.banco.models.entity.Cuenta;


@Controller
public class CuentaController {
    
    @Autowired
    private ICuentaDao cuentaDao;

    

    @RequestMapping(value = "/cuentas", method = RequestMethod.GET)
    public String cuentaLista(Model model){ 
     model.addAttribute("titulo", "Lista Cuenta");
     model.addAttribute("cuentas", cuentaDao.findAll());
    return "cuentas";
    }

    @RequestMapping(value = "/form-cuenta")
    public String crear(Map<String, Object> model){
        Cuenta cuenta= new Cuenta(); 
        model.put("cuenta", cuenta);
        model.put("titulo", "Crear nueva targeta, llene los datos");
        return "form-Cuenta";
    }

    @RequestMapping(value = "form-cuenta/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
        Cuenta cuenta= null;

        if(id > 0){
           cuenta= cuentaDao.findOne(id);
        }else{
            return "redirect:/cuentas";
        }

        model.put("cuenta", cuenta);
        model.put("titulo", "Edite la Cuenta");
        return "form-Cuenta";
    }

    @RequestMapping(value = "/form-cuenta", method = RequestMethod.POST)
    public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status){

        if(result.hasErrors()){
            model.addAttribute("titulo", "Formulario Cuentas");
            return "form-cuenta";
        }else{
            cuentaDao.save(cuenta);
            status.setComplete();
            return "redirect:/cuentas";
        }
    }

    @RequestMapping(value = "eliminar-cuenta/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){

        if(id > 0){
            cuentaDao.delete(id);
        }

        return "redirect:/cuentas";
    }

}
