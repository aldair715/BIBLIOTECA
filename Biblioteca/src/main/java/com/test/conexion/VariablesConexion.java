/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class VariablesConexion {
    //atributos

    public static String URL_BBDD="jdbc:mysql://localhost:3306/sistema_alquiler?useSSL=false";
    public static String DRIVER_BBDD="com.mysql.jdbc.Driver";
    public static String USER_BBDD="root";
    public static String PASSWORD_BBDD="Nitro0Air";
    private Connection conexion;
    //metodo para iniciar conexion
    public void iniciarConexion() throws SQLException{
        try{
            Class.forName(DRIVER_BBDD);
            conexion=DriverManager.getConnection(URL_BBDD,USER_BBDD,PASSWORD_BBDD);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    //metodo para cerrar conexion
    public void cerrarConexion()
    {
        if(conexion!=null)
        {
            try{
                conexion.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //metodo para ver si hay conexion
    public int verConexion()
    {
        if(conexion!=null)
        {
            return 1;
        }
        else{
            return 0;
        }
    }
    //getter and setter

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
