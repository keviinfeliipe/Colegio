package com.colegio.model.dao;

import com.colegio.model.Conexion;
import com.colegio.model.entity.Alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnosImpl implements IAlumnos{
    @Override
    public void crear(Alumnos alumnos) throws Exception {
        int valores=1;
        Connection conn=null;
        PreparedStatement st= null;
        String sql = "INSERT INTO Alumnos VALUES (?,?,?)";
        try{
            conn= Conexion.getConnection();
            st=conn.prepareStatement(sql);
            st.setInt(valores++,alumnos.getId());
            st.setString(valores++,alumnos.getNombre());
            st.setInt(valores++,alumnos.getEdad());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public void actualizar(Alumnos alumnos) throws Exception {
        int valores=1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql ="UPDATE Alumnos SET nombre=?,edad=? WHERE id=" + alumnos.getId() + "";
        try {
            conn=Conexion.getConnection();
            st=conn.prepareStatement(sql);
            st.setString(valores++,alumnos.getNombre());
            st.setInt(valores++,alumnos.getEdad());
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(st);
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        int valores = 1;
        Connection conn = null;
        PreparedStatement st = null;
        String sql = "DELETE FROM Alumnos WHERE id="+id+";";
        try {
            conn = Conexion.getConnection();
            st=conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
    }

    @Override
    public List<Alumnos> listar() throws Exception {
        List<Alumnos> alumnosLista = new ArrayList<>();
        Alumnos alumno=null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT id,nombre,edad FROM Alumnos;";
        try{
            conn = Conexion.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                alumno = new Alumnos(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad")
                );
                alumnosLista.add(alumno);
            }
        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }
        return alumnosLista;
    }

    @Override
    public Alumnos buscar(int id) throws Exception {

        Alumnos alumno = null;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Alumnos WHERE id="+id+";";

        try {
            conn = Conexion.getConnection();
            st=conn.prepareStatement(sql);
            rs=st.executeQuery();

            alumno = new Alumnos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad")
            );

        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            Conexion.cerrar(rs);
            Conexion.cerrar(st);
            Conexion.cerrar(conn);
        }

        return alumno;
    }
}
