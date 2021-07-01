<%-- 
    Document   : registrarLibro
    Created on : 30-jun-2021, 13:28:09
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </head>
    <body>
        <jsp:useBean id="autor" scope="session" class="com.test.bean.AutorBean"/>
        <jsp:useBean id="libro" scope="session" class="com.test.bean.libroBean"/>
        <a href="../index.html" class="btn btn-dark">VOLVER</a>
        <%
            
            if(request.getParameter("guardar")!=null){
                String mensaje=libro.registrarLibroPorSelect(request);
                out.print(mensaje);
            }
            if(request.getParameter("seleccion")!=null)
            {
                String mensaje=libro.registrarLibroPorFormulario(request);
                out.print(mensaje);
            }
            
        %>
        <div class="container"> 
            <br>
            <h1>REGISTRO DE LIBROS</h1>
            <form>

                <div id="seleccionado">
                    <select name="codigo" >
                        <%=autor.mostrarAutoresEnSelect() %>
                    </select>
                </div>
                    <br>
                <button class="enFormulario btn btn-primary" type="button">COLOCAR OTRO AUTOR</button>
            
            <div class="form-group">
                   <label for="usr">TITULO DEL LIBRO:</label>
                   <input type="text" class="form-control form-control-sm" required name="titulo" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA EL TITULO DEL LIBRO" autocomplete="off">
            </div>
            <div class="form-group">
                   <label for="usr">EDICION DEL LIBRO</label>
                   <input type="number" class="form-control form-control-sm" required name="edicion" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA EL NUMERO DE EDICION" autocomplete="off">
                </div>
            <div class="form-group">
                   <label for="usr">EJEMPLARES DEL LIBRO</label>
                   <input type="number" class="form-control form-control-sm" required name="nroEjemplar" pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title="COLOQUE UN NOMBRE CORRECTO, SOLO SE PERMITE VALORES ALFABETICOS" placeholder="ESCRIBA LOS EJEMPLARES" autocomplete="off">
                </div>
            <input type="submit" value="ENVIAR" class="btn btn-success" name="guardar"/>
        </form>
        </div>
                    <script src="../JS/index.js" type="module"></script>
    </body>
</html>
