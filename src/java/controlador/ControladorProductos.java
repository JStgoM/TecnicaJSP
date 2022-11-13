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
import modelo.Productos;
import modelo.ProductosDAO;

@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductosDAO product = new ProductosDAO();
            String accion;
            RequestDispatcher dispatcher = null;
            accion = request.getParameter("accion");
            if (accion==null || accion.isEmpty()) {
                dispatcher = request.getRequestDispatcher("Ventas.jsp");
                List<Productos> lista = product.listarProductos();
                request.setAttribute("lista", lista);
            }
            else if ("nuevo".equals(accion)) {
                dispatcher = request.getRequestDispatcher("Nuevo.jsp");
            }
            else if ("agregar".equals(accion)) {
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                int existencia = Integer.parseInt(request.getParameter("existencia"));
                Double precio = Double.parseDouble(request.getParameter("precio"));
                Productos prod = new Productos(0, codigo, nombre, existencia, precio);
                product.agregarProductos(prod);
                dispatcher = request.getRequestDispatcher("Ventas.jsp");
                List<Productos> lista = product.listarProductos();
                request.setAttribute("lista", lista);
            }
            else if ("editar".equals(accion)) {
                dispatcher = request.getRequestDispatcher("Modificar.jsp");
                int idproducto = Integer.parseInt(request.getParameter("idproducto"));
                Productos prod = product.mostrarProductos(idproducto);
                request.setAttribute("producto", prod);
            }
            else if ("actualizar".equals(accion)) {
                int idproducto = Integer.parseInt(request.getParameter("idproducto"));
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                int existencia = Integer.parseInt(request.getParameter("existencia"));
                Double precio = Double.parseDouble(request.getParameter("precio"));
                Productos prod = new Productos(idproducto, codigo, nombre, existencia, precio);
                product.modificarProductos(prod);
                dispatcher = request.getRequestDispatcher("Ventas.jsp");
                List<Productos> lista = product.listarProductos();
                request.setAttribute("lista", lista);
            }
            else if ("borrar".equals(accion)) {
                int idproducto = Integer.parseInt(request.getParameter("idproducto"));
                product.eliminarProductos(idproducto);
                dispatcher = request.getRequestDispatcher("Ventas.jsp");
                List<Productos> lista = product.listarProductos();
                request.setAttribute("lista", lista);
            }
            else{
                dispatcher = request.getRequestDispatcher("Ventas.jsp");
                List<Productos> lista = product.listarProductos();
                request.setAttribute("lista", lista);
            }
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
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
