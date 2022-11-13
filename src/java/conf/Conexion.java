package conf;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection getConexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas?serverTimeZone=UTC","root","password");
            return conexion;
        }
        catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
