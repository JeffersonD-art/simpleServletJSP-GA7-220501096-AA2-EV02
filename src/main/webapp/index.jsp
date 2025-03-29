<%-- 
    Document   : index
    Created on : 29/03/2025, 8:52:28 a. m.
    Author     : Jefferson David Cano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Libro</title>
    </head>
    <body>

        <%
            // Obtener el mensaje de la sesión
            String mensaje = (String) session.getAttribute("mensaje");
            if (mensaje != null) {
        %>
        <script>
                alert("<%= mensaje%>");
        </script>
        <%
                // Eliminar el mensaje de la sesión después de mostrarlo
                session.removeAttribute("mensaje");
            }
        %>
        <h1>Formulario</h1>
        <h2>Agregar Nuevo Libro</h2>
        <form action="SvLibros" method="POST">
            <label for="title">Título:</label>
            <input type="text" id="title" name="title" required><br><br>

            <label for="author">Autor:</label>
            <input type="text" id="author" name="author" required><br><br>

            <label for="year">Año:</label>
            <input type="number" id="year" name="year" required><br><br>

            <button type="submit">Agregar Libro</button>
        </form>

        <h2>Ver lista de libros</h2>

        <p>Para ver los libros registrador haga click en el siguiente boton</p>
        <form action="SvLibros" method="GET">
            <button type="submit">Mostrar Libros</button>
        </form>

    </body>
</html>
