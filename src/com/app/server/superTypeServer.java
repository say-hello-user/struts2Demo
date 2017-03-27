package com.app.server;

import java.util.List;

import com.app.entities.superMarket;
import com.app.entities.superType;

public interface superTypeServer {
    public void add(superType supertype);
    public List<superType> getAll();
    public superType getById(Integer id);
    public String deleteTypeById(Integer id);
    public String updateTypeById(Integer id,superType supertype);
}
