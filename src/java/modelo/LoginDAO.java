/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conf.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection conexion;
    public LoginDAO() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    public int validarLogin(Usuario user) throws ClassNotFoundException {
        PreparedStatement ps;
        ResultSet rs;
        int r=0;
        try {
            //ps = conexion.prepareStatement("Select * from usuario where nombre=? and password=?");
            ps = conexion.prepareStatement("SELECT * FROM usuario WHERE nombre=? and password=?");
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                r=r+1;
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("password"));
            }
            if (r==1) {
                return 1;
            }
            else{
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        }
    }
}
