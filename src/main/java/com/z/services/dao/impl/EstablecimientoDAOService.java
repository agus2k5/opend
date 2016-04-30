/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.services.dao.impl;

import com.z.models.Establecimiento;
import com.z.services.dao.EstablecimientoDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mariano
 */
@Service
public class EstablecimientoDAOService implements EstablecimientoDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional(readOnly = false)
    public void add(Establecimiento establecimiento) {
        sessionFactory.getCurrentSession().save(establecimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Establecimiento> list() {
        return sessionFactory.getCurrentSession().createQuery("from Establecimiento").list();
    }

    @Override
    public Establecimiento get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
