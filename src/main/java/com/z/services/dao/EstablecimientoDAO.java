package com.z.services.dao;


import com.z.models.Establecimiento;
import java.util.List;


public interface EstablecimientoDAO {
    public void add(Establecimiento establecimiento);
    public List<Establecimiento> list();
    public Establecimiento get(String id);
}