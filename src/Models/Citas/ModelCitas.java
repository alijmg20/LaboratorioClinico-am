package Models.Citas;




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

public class ModelCitas {
    

    
        public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {"ID", "Fecha Agendada", "Nombre Paciente", "Cedula"};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaCitas";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcita");
                registros[1] = resultados.getString("fecha_agendada");
                registros[2] = resultados.getString("nombrepaciente");
                registros[3] = resultados.getString("cedulapaciente");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
        public DefaultTableModel mostrarTxt() {
        String[] titulos = {" idcita ", "idpacinete", " cedula ", " nombre ", " fecha ", " correo ", " direccion ", " telefono ", "fecha agendada"};
        String[] registros = new String[9];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);     
        String SQL = "SELECT * FROM mostrarListaCitas";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                
                registros[0] = resultados.getString("idcita");
                registros[1] = resultados.getString("idpaciente");
                registros[2] = resultados.getString("cedulapaciente");
                registros[3] = resultados.getString("nombrepaciente");
                String formato = resultados.getString("fechapaciente");
                String fecha1 = formato.replace("-", "/");
                registros[4] = fecha1;
                registros[5] = resultados.getString("correopaciente");
                registros[6] = resultados.getString("direccionpaciente");
                registros[7] = resultados.getString("telefonopaciente");
                
                String prueba = resultados.getString("fecha_agendada");
                String fecha2 = prueba.replace("-", "/");
                registros[8] = fecha2;
               
                tabla.addRow(registros);

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla; 
    }
        
        public void create(String fecha_emision,String fecha_agendada,String statusCita, int idpaciente, int idempleado){
        
   

        try {

            long fechaInterfaz = java.util.Date.parse(fecha_agendada);
            Date fecha = new Date(fechaInterfaz);
            System.out.println("FECHA QUE LLEGA A SENTENCIA 2: "+fecha_agendada);
            String SQL = "CALL registrarCita(?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, fecha_emision); // fecha_emision
            consulta.setString(2, fecha_agendada);
            consulta.setString(3, statusCita);
            consulta.setInt(4, idpaciente);
            consulta.setInt(5, idempleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Cita registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos, horario no disponible para cita " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void update(int idcita, String fecha_emision,String fecha_agendada,String statusCita, int idpaciente, int idempleado){
 
        try {

            long fechaInterfaz = java.util.Date.parse(fecha_agendada);
            Date fecha = new Date(fechaInterfaz);
            String SQL = "CALL editarCita(?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            
            consulta.setInt(1, idcita); 
            consulta.setString(2, fecha_emision); // fecha_emision
            consulta.setDate(3, fecha);
            consulta.setString(4, statusCita);
            consulta.setInt(5, idpaciente);
            consulta.setInt(6, idempleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Cita actualizada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
         
        public void delete(int idcita) {
        
        String SQL = "CALL eliminarCita(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idcita);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cita eliminada exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: el paciente tiene citas registradas en el sistema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }
        
        
         public DefaultTableModel buscarCita(String buscar) {
        String[] titulos = {"ID", "Fecha Agendada", "Nombre Paciente", "Cedula"};
        String[] registros = new String[9];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaCitas WHERE cedulapaciente LIKE '%"+buscar+"%' OR nombrepaciente LIKE '%"+buscar+"%' OR idcita LIKE '%"+buscar+"%'";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcita");
                registros[1] = resultados.getString("fecha_agendada");
                registros[2] = resultados.getString("nombrepaciente");
                registros[3] = resultados.getString("cedulapaciente");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
}
