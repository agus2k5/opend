package com.z.services.dao;


import com.z.models.Categoria;
import java.util.List;


public interface CategoriaDAO {
    public boolean add(Categoria categoria);
    public List<Categoria> list();
    public Categoria get(String id);
}