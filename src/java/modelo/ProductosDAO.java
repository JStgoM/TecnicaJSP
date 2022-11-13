package modelo;

import conf.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonat
 */
public class ProductosDAO {
    Connection conexion;
    public ProductosDAO() throws ClassNotFoundException{
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    public List<Productos> listarProductos(){
        PreparedStatement ps;
        ResultSet rs;
        List<Productos> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT idproducto, codigo, nombre, existencia, precio FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {                
                int idproducto = rs.getInt("idproducto");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int existencia = rs.getInt("existencia");
                double precio = rs.getDouble("precio");
                
                Productos producto = new Productos(idproducto, codigo, nombre, existencia, precio);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Productos mostrarProductos(int idprod){
        PreparedStatement ps;
        ResultSet rs;
        Productos producto = null;
        try {
            ps = conexion.prepareStatement("Select idproducto, codigo, nombre, existencia, precio FROM productos where idproducto=?");
            ps.setInt(1, idprod);
            rs = ps.executeQuery();
            while (rs.next()) {                
                int idproducto = rs.getInt("idproducto");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int existencia = rs.getInt("existencia");
                double precio = rs.getDouble("precio");
                
                producto = new Productos(idproducto, codigo, nombre, existencia, precio);
            }
            return producto;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public boolean agregarProductos(Productos prod){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("INSERT INTO productos (codigo, nombre, existencia, precio) VALUES (?,?,?,?)");
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setInt(3, prod.getExistencia());
            ps.setDouble(4, prod.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean modificarProductos(Productos prod){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("UPDATE productos SET codigo=?, nombre=?, existencia=?, precio=? WHERE idproducto=?");
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setInt(3, prod.getExistencia());
            ps.setDouble(4, prod.getPrecio());
            ps.setInt(5, prod.getIdproducto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean eliminarProductos(int idprod){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("DELETE FROM productos WHERE idproducto=?");
            ps.setInt(1, idprod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
