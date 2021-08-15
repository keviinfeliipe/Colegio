package com.colegio.model;

import java.sql.*;

public class Conexion {
    private static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/Colegio?useSSL=false&serverTimezone=America/Bogota";
    private static final String usuario = "root";
    private static final String contrasena = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, contrasena);
    }

    public static void cerrar(PreparedStatement st) throws SQLException {
        st.close();
    }

    public static void cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void cerrar(Connection conn) throws SQLException {
        conn.close();
    }
}
