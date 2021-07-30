
package Models.Empleados;

import Models.Models.ModelCore;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelEmpleados extends ModelCore {
    
        public void create(String nombre,String username,String correo,
            String clave,int cedula, char sexo, Date fecha_nacimiento,
            String telefono, String direccion, String NombreTipoEmpleado) {

        try {
            
            
            
            String SQL = "CALL registrarEmpleado(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setString(2, username);
            consulta.setString(3, correo);
            consulta.setString(4, clave);
            consulta.setInt(5, cedula);
            consulta.setString(6, String.valueOf(sexo));
            consulta.setDate(7, fecha_nacimiento);
            consulta.setString(8, telefono);
            consulta.setString(9, direccion);
            consulta.setString(10, NombreTipoEmpleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

/*
    @Override
    public DefaultTableModel read() {
        String[] titulos = {" ID ", " Nombre "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL mostrarListaTipoEmpleado()";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idtipoe");
                registros[1] = resultados.getString("Nombre");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void update(int idempleado,String nombre,String username,String correo,
            String clave,int cedula, char sexo, Date fecha_nacimiento,
            String telefono, String direccion, String nombreTipoEmpleado) {
        try {
            String SQL = "CALL editarTipoEmpleado(?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idTipoEmpleado);
            consulta.setString(2, nombre);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Tipo de empleado actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int idempleado) {

        String SQL = "CALL eliminarTipoEmpleado(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idempleado);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo de empleado Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel search(String value) {
        
        String[] titulos = {" ID ", " Nombre "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarTipoEmpleado('"+value+"')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idtipoe");
                registros[1] = resultados.getString("Nombre");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    */
    
    
}
