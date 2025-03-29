package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import logica.Libro;

//@author Jefferson David Cano
@WebServlet(name = "SvLibros", urlPatterns = {"/SvLibros"})
public class SvLibros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misesion = request.getSession();
        
         List<Libro> listaLibros = (List<Libro>) misesion.getAttribute("listaLibros");
        if (listaLibros == null) {
            listaLibros = new ArrayList<>();
        }
       
        misesion.setAttribute("listaLibros", listaLibros);
        response.sendRedirect("mostrarLibros.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Integer year = Integer.parseInt(request.getParameter("year"));

        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("year: " + year);

        HttpSession misesion = request.getSession();

        // Recuperar la lista existente (o crear una nueva si no existe)
        List<Libro> listaLibros = (List<Libro>) misesion.getAttribute("listaLibros");
        if (listaLibros == null) {
            listaLibros = new ArrayList<>();
        }

        // Agregar el nuevo libro a la lista existente
        listaLibros.add(new Libro(title, author, year));

        // Guardar la lista actualizada en la sesión
        misesion.setAttribute("listaLibros", listaLibros);
        misesion.setAttribute("mensaje", "Libro registrado exitosamente");

        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



