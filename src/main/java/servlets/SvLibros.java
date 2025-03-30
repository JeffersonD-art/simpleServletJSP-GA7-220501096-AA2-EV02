package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Libro;

//@author Jefferson David Cano
@WebServlet(name = "SvLibros", urlPatterns = {"/SvLibros"})
public class SvLibros extends HttpServlet {

    String usuario = "root";
    String password = "root";
    String db = "biblioteca";
    String ip = "localhost";
    String puerto = "3306";

    String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;

    Connection conexion;
    Statement statement;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    //---GET---
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misesion = request.getSession();
        List<Libro> listaLibros = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvLibros.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();

            rs = statement.executeQuery("SELECT * FROM libros");
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                Integer year = rs.getInt("year");

                listaLibros.add(new Libro(title, author, year));
            }

            misesion.setAttribute("listaLibros", listaLibros);
            response.sendRedirect("mostrarLibros.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(SvLibros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //---POST---
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Integer year = Integer.parseInt(request.getParameter("year"));

        try {
            String sql = "INSERT INTO libros (title, author, year) VALUES ('" + title + "', '" + author + "', " + year + ")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvLibros.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Guardar la lista actualizada en la sesión
        HttpSession misesion = request.getSession();
        misesion.setAttribute("mensaje", "Libro registrado exitosamente");

        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
