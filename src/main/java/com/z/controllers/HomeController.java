/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.controllers;

import com.z.criteria.Criteria;
import com.z.criteria.CriteriaDistance;
import com.z.models.Establecimiento;
import com.z.services.dao.EstablecimientoDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(method = RequestMethod.GET,params={"distancia"})
    public ModelAndView main(@RequestParam double distancia){
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("distanciaKM",distancia);
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("main");
        return mav;
    }
    
    @RequestMapping(value = "establecimiento/get",method = RequestMethod.GET)
    public @ResponseBody List<Establecimiento> getEstablecimientos(@RequestParam(required = false) final String lat,@RequestParam(required = false) final String lng,@RequestParam  String distanciaKM){
        double dist=1.0;
        try{
            dist=Double.parseDouble(distanciaKM);
            if(dist<=0){dist=1.0;}
        }catch(NumberFormatException e){System.out.println(e.toString());}
        System.out.println("lat: "+lat+", lng: "+lng);
        Criteria criteria = new CriteriaDistance(Float.parseFloat(lat), Float.parseFloat(lng), dist);
        return criteria.meetCriteria(establecimientoDAO.list());
    }
}
