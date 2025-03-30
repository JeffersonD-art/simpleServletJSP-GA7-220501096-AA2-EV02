<%-- 
    Document   : mostrarLibros
    Created on : 29/03/2025, 11:18:38 a. m.
    Author     : Jefferson David Cano
--%>

<%@page import="logica.Libro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
        <title>Libros</title>
    </head>
    <body>
        <main class="container">
            <h1>Lista de libros Registrados</h1>

            <%
                List<Libro> listaLibros = (List) request.getSession().getAttribute("listaLibros");

                for (Libro libro : listaLibros) {
            %>  
            <p>Titulo: <%= libro.getTitle()%></p>  
            <p>Autor: <%= libro.getAuthor()%></p>
            <p>Año: <%= libro.getYear()%></p>
            <p>-------------------------------</p>
            <% }%>
        </main>

    </body>
</html>
