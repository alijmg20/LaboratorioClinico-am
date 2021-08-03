
package Models.Pacientes;

import Models.Models.ModelCore;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelPacientes extends ModelCore{

    @Override
    public DefaultTableModel search() {
        return super.search(); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void delete(int idpaciente) {
        
        String SQL = "CALL eliminarPaciente(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idpaciente);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: el paciente tiene citas registradas en el sistema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }

    
    public void update(int id, String nombre,char sexo, String fecha_nacimiento,int cedula, String correo, String direccion, String telefono) {
        
        try {

            long fechaInterfaz = java.util.Date.parse(fecha_nacimiento);
            Date fecha = new Date(fechaInterfaz);

            String SQL = "CALL editarPaciente(?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, id);
            consulta.setString(2, nombre);
            consulta.setString(3, String.valueOf(sexo));
            consulta.setDate(4, fecha);
            consulta.setInt(5, cedula);
            consulta.setString(6, correo);
            consulta.setString(7, direccion);
            consulta.setString(8, telefono);
           
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    public DefaultTableModel mostrarTxt() {
        String[] titulos = {" id "," nombre ", " cedula ", " sexo ", " fecha ", " correo ", " telefono ", " direccion "};
        String[] registros = new String[9];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);     
        String SQL = "SELECT * FROM mostrarListaPacientes";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idpaciente");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("cedula");
                registros[3] = resultados.getString("sexo");
                String formato = resultados.getString("fecha_nacimiento");
                String fecha1 = formato.replace("-", "/");
                registros[4] = fecha1;
                registros[5] = resultados.getString("correo");
                registros[6] = resultados.getString("telefono");
                registros[7] = resultados.getString("direccion");
               
                tabla.addRow(registros);

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla; 
    }

    
    public void create(String nombre,char sexo, String fecha_nacimiento,int cedula, String correo, String direccion, String telefono) {
        
   

        try {

            long fechaInterfaz = java.util.Date.parse(fecha_nacimiento);
            Date fecha = new Date(fechaInterfaz);
            String SQL = "CALL registrarPaciente(?,?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setString(2, String.valueOf(sexo));
            consulta.setDate(3, fecha);
            consulta.setInt(4, cedula);
            consulta.setString(5, correo);
            consulta.setString(6, direccion);
            consulta.setString(7, telefono);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {" ID ", " Nombre ", " Cedula ", " sexo "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaPacientes";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idpaciente");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("cedula");
                registros[3] = resultados.getString("sexo");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
}
