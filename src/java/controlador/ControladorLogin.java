package controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.LoginDAO;
import modelo.Productos;
import modelo.ProductosDAO;
import modelo.Usuario;

@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductosDAO product = new ProductosDAO();
            LoginDAO LDAO = new LoginDAO();
            RequestDispatcher dispatcher = null;
            String accion = request.getParameter("accion");
            if (accion.equals("Ingresar")) {
                String nombre = request.getParameter("nombre");
                String password = request.getParameter("password");
                Usuario user = new Usuario(0, nombre, password);
                int r;
                r = LDAO.validarLogin(user);
                if (r == 1) {
                    request.getSession().setAttribute("nombre", nombre);
                    request.getRequestDispatcher("/ControladorProductos").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }else if(accion.equals("salir")){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
