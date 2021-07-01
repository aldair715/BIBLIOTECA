/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

/**
 *
 * @author hp
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class libroBean {
    //atributos
    private VariablesConexion variables;
    private Connection conexion;
    private PreparedStatement insertLibro;
    //constructores para iniciar conexion
    public libroBean() throws SQLException
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
    //metodo para verificar si existe el autor
    public String registrarLibro(HttpServletRequest request,int indice)
    {
        String salida="";System.out.println("hola");
        if(request!=null && conexion!=null)
        {
            System.out.println("SDD");
            try{

                if(indice==1)
                {
                    salida=registrarLibroPorFormulario(request);

                }
                else
                { 
                    salida=registrarLibroPorSelect(request);

                }
            }catch(Exception e)
            {
                salida+=e;
            }
        }
        
        return salida;
    }
    //metodo para registrar un libro
    public String registrarLibroPorFormulario(HttpServletRequest request)
    {
        StringBuilder salidaTabla=new StringBuilder();
        if(request==null)
        {
            return "";
        }
        if(conexion!=null)
        {
            try{
                //atributos
            String nombre,paterno,materno,nacionalidad,titulo;
            StringBuilder query=new StringBuilder();
            int registro,registro1,codigo_autor,edicion,nroEjemplar;
            //sacamos del request a los atributos para autor
            materno=request.getParameter("materno");
            paterno=request.getParameter("paterno");
            nombre=request.getParameter("nombre");
            nacionalidad=request.getParameter("nacionalidad");
            //sacamos del request los atributos para libro
            titulo=request.getParameter("titulo");
            edicion=Integer.parseInt(request.getParameter("edicion"));
            nroEjemplar=Integer.parseInt(request.getParameter("nroEjemplar"));
            //consulta sql
            query.append(" insert into autor(paterno,materno,nombre,nacionalidad) values( ");
            query.append("'"+materno+"',"+"'"+paterno+"',"+"'"+nombre+"',"+"'"+nacionalidad+"')");
            insertLibro=conexion.prepareStatement(query.toString());
            registro=insertLibro.executeUpdate();
            if(registro==1)
            {
                codigo_autor=listarUltimoIdAutor();
                if(codigo_autor!=0)
                {
                    registro1=registrarLibro1(codigo_autor,titulo,edicion,nroEjemplar);
                }
            }
            }catch(Exception e){
                salidaTabla.append(e);
                e.printStackTrace();
                System.out.println("ERROR");
            }
        }
        return salidaTabla.toString();
    }
    public String registrarLibroPorSelect(HttpServletRequest request)
    {
       
        StringBuilder salidaTabla=new StringBuilder();
     
        if(request==null)
        {
            return "NO EXISTE";
        }
        if(conexion!=null)
        {
            try{
            StringBuilder query=new StringBuilder();
            String titulo;
            int codigo,edicion,nroEjemplar,registro;
            codigo=Integer.parseInt(request.getParameter("codigo"));
            titulo=request.getParameter("titulo");
            edicion=Integer.parseInt(request.getParameter("edicion"));
            nroEjemplar=Integer.parseInt(request.getParameter("nroEjemplar"));
            registro=registrarLibro1(codigo,titulo,edicion,nroEjemplar);
            if(registro!=0)
            {
                salidaTabla.append("exito");
            }
            else
            {
                salidaTabla.append("PROBLEMA");
                System.out.println("UNO");
            }   
             
            }catch(Exception e){

                e.printStackTrace();
            }
        }
        return salidaTabla.toString();
    }
    public int listarUltimoIdAutor()
    {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder queryBusqueda=new StringBuilder();
        int codigo_persona=0;
        queryBusqueda.append(" SELECT cod_autor " +
            " FROM autor" +
            " ORDER by cod_autor DESC " +
            " LIMIT 1 ");
        try{
                PreparedStatement pst=conexion.prepareStatement(queryBusqueda.toString());
                ResultSet resultado=pst.executeQuery();
                
                int i=1;
                while(resultado.next()){
                   codigo_persona=resultado.getInt(1);
                }
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
        return codigo_persona;
    }
    public int registrarLibro1(int cod,String titulo,int edicion,int nroEjemplar)
    {
        int retorno=0;
        if(conexion!=null)
        {
            try{
                StringBuilder query=new StringBuilder();
                int registro;
                System.out.println("aqui");
                query.append(" INSERT INTO libro (cod_autor,titulo,edicion,nroejemplar) " );
                query.append(" VALUES ("+cod+",'"+titulo+"',"+edicion+","+nroEjemplar+")" );

                insertLibro=conexion.prepareStatement(query.toString());
                registro=insertLibro.executeUpdate();
                if(registro==1)
                {
                    retorno=1;
                }
            }catch(Exception e){
                retorno=0;
            }
        }
        return retorno;
    }
    public String buscarProductosPorCategoria(int cod_autor)
    {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select titulo,edicion,nroejemplar from libro where cod_autor="+cod_autor);

        try{
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet resultado=pst.executeQuery();
            int i=1;
            while(resultado.next())
            {
                salidaTabla.append("<tr>");
                    salidaTabla.append("<td>"+i+"</td>");
                    salidaTabla.append("<td>"+resultado.getString(1)+"</td>");
                    salidaTabla.append("<td>"+resultado.getInt(2)+"</td>");
                    salidaTabla.append("<td>"+resultado.getInt(3)+"</td>");
                    i++;

                salidaTabla.append("</tr>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return salidaTabla.toString();
    }
}


