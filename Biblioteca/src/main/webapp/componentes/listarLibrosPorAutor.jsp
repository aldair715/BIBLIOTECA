<%-- 
    Document   : listarLibrosPorAutor
    Created on : 30-jun-2021, 17:16:56
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%! String salidaTabla=""; %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            .centrado{
                display:block;
                margin-left:auto;
                margin-right: auto;
                text-align: center;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:useBean id="rol" scope="session" class="com.test.bean.AutorBean"/>
        <jsp:useBean id="usuario" scope="session" class="com.test.bean.libroBean"/>
        
        <%
        if(request.getParameter("buscar")!=null)
        {
            int cod=Integer.parseInt(request.getParameter("codRol"));
            //llamando al metodo torticolis.
            salidaTabla=usuario.buscarProductosPorCategoria(cod);
            
        }
        %>
        <h1 class="centrado">BUSQUEDA DE LIBROS POR AUTOR</h1>
        <a type="button" href="../index.html" class="btn btn-success centrado">VOLVER</a>
        <br>
        <form>
                
             <label class="centrado">AUTOR</label>
                            <div class="form-group">
                               
                                <select name="codRol" class="form-control">
                                <%=rol.mostrarAutoresEnSelect() %>
                                </select>
                            </div>

                            <button class="btn btn-dark centrado" type="submit" id="mostrarUsuariosPorRol" name="buscar">BUSCAR</button>
                            <br>
                            
                
        </form>
        
        <table border="1" class="table table-dark table-hover">
                                <thead>
                                    <th>Nº</th>
                                    <th>TITULO</th>
                                    <th>EDICION</th>
                                    <th>EJEMPLARES</th>
                                </thead>
                                <tbody>
                                    
                                    <%=salidaTabla%>
                                </tbody>
                </table>
    </body>
   
</html>