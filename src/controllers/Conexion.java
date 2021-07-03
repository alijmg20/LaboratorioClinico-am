
package Controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conectado = null;
    private final String jdbc = "jdbc:mysql://labs-dbservices01.ucab.edu.ve/";

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectado = DriverManager.getConnection(jdbc + "bd2_202125_grupo4", "bd2_202125_28031628", "28031628");
            System.out.println("conexion realizada exitosamente");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "error de conexion a la base de datos" + e.getMessage());
        }
        return conectado;
    }
    
}
