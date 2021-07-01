/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hp
 */
public class AutorBean {
    private VariablesConexion variables;
    private Connection conexion;
    private PreparedStatement insertAutor;
    //constructores para iniciar conexion
    public AutorBean() throws SQLException
    {
        variables = new VariablesConexion();
        variables.iniciarConexion();
        conexion=variables.getConexion();
    }
    //metodo para destruir
    @PreDestroy
    public void cerrarConexion()
    {
        variables.cerrarConexion();
    }
    //metodo para mostrar los autores
    public String mostrarAutoresEnSelect()
    {
        StringBuilder salidaTabla=new StringBuilder();
        try{
            
            StringBuilder query=new StringBuilder();
            query.append("select cod_autor,concat(paterno,' ',materno,' ',nombre) as nombreCompleto from autor ");

            
                PreparedStatement pst=conexion.prepareStatement(query.toString());
                ResultSet resultado=pst.executeQuery();
                while(resultado.next())
                {
                    salidaTabla.append("<option value='"+resultado.getInt(1)+"'>");
                    salidaTabla.append(resultado.getString(2));
                    salidaTabla.append("</option>");

                }
            
        }catch(Exception e){
          e.printStackTrace();
        }
        return salidaTabla.toString();
    }
    
}
