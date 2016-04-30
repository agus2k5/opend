/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.controllers;

import com.z.models.Establecimiento;
import com.z.services.dao.EstablecimientoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mariano
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    private EstablecimientoDAO establecimientoDAO;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("main");
        return mav;
    }
    
    @RequestMapping(value = "establecimiento/get",method = RequestMethod.GET)
    public @ResponseBody List<Establecimiento> getEstablecimientos(){
        return establecimientoDAO.list();
    }
}
