package com.colegio.model.dao;

import com.colegio.model.entity.Alumnos;

import java.util.List;

public interface IAlumnos {

    void crear(Alumnos alumnos) throws Exception;
    void actualizar(Alumnos alumnos) throws Exception;
    void eliminar(int id) throws Exception;
    List<Alumnos> listar() throws Exception;
    Alumnos buscar(int id) throws Exception;

}
