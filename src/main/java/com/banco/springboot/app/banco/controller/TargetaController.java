package com.banco.springboot.app.banco.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.banco.springboot.app.banco.editors.CuentaPropertyEditor;
//import com.banco.springboot.app.banco.models.DAO.ICuentaDao;
import com.banco.springboot.app.banco.models.DAO.ITaregetaDao;
import com.banco.springboot.app.banco.models.entity.Cuenta;
import com.banco.springboot.app.banco.models.entity.Targetas;

@Controller
public class TargetaController {
    
        @Autowired
        private ITaregetaDao taregetaDao;

       /* @Autowired
        private ICuentaDao cuentaDao;*/ 

        @Autowired(required = true)
        private CuentaPropertyEditor cuentaEditor;

        @InitBinder
        public void InitBinder(WebDataBinder binder){
            binder.registerCustomEditor(Cuenta.class, "Cuenta", cuentaEditor);
        }

        @RequestMapping(value="/targeta-lista" , method = RequestMethod.GET)
        public String listar(Model model){

            model.addAttribute("titulo", "Listado de Targetas");
            model.addAttribute("targetas", taregetaDao.findAll());
            return "lista-targetas";

        }

       @RequestMapping(value = "/formtargeta")
        public String crear(Map<String, Object>  model, Model modellist){

            Targetas targeta= new Targetas();
            model.put("targeta", targeta);
            model.put("titulo", "llenar los datos de la targeta"); 
            return "formtargeta";

        }

        @RequestMapping(value = "/formtarjeta/{id}")
        public String editar(@PathVariable(value = "id") long id, Map<String, Object> model ){

            Targetas targeta= null;

            if(id > 0){
                targeta= taregetaDao.findOne(id);
            }else{
                return "redirect:/index";
            }

            model.put("targeta", targeta);
            model.put("titulo", "Editar targeta");
            return "formtargeta";

        }

        @RequestMapping(value = "/formtargeta", method = RequestMethod.POST)
        public String guardar(@Valid Targetas targeta, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash){

            if(result.hasErrors()){
               model.addAttribute("titulo", "Llename correctamente los campos");
               model.addAttribute("error", result.hasErrors());
               model.addAttribute("model", "Error al emviar los datos");
               return "/formtargeta";
            }else{
                model.addAttribute("result", false);
            }

            model.addAttribute("titulo", "Llenar formulario targeta");
            model.addAttribute("model", "Se envio correctamente el formulario");

            try {
                taregetaDao.save(targeta);

            } catch (Exception e) {
                e.printStackTrace();
                flash.addFlashAttribute("mensaje", e.getMessage());
            }
            status.setComplete();

            return "redirect:formtargeta";
        }

        @RequestMapping(value= "/eliminar/{id}")
        public String eliminar(@PathVariable(value = "id") long id){

            if(id > 0){
                taregetaDao.Delete(id);
            }

            return "redirect:index";

        }

}
