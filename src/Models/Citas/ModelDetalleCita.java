
package Model.Citas;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;


public class ModelDetalleCita {
    
    
    public void create(String estado, int idexamen, int idcita){
        
       
        try {

            String SQL = "CALL registrarDetalleCita(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, estado); 
            consulta.setInt(2, idexamen);
            consulta.setInt(3, idcita);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Examen: "+idexamen+" registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    public void update(String estado, int idexamen, int idcita){
       
        try {

            String SQL = "CALL editarDetalleCita(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, estado); 
            consulta.setInt(2, idexamen);
            consulta.setInt(3, idcita);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Detalle actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(int idcita, int idexamen) {
        
        String SQL = "CALL eliminarDetalleCita(?,?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idexamen);
            consulta.setInt(2, idcita);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Detalle eliminada exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error:  " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }   
        
    public DefaultTableModel mostrarInterfaz(int idcita) {
        String[] titulos = {" ID ", " Nombre ", " Precio ", " Categoria ", " Estado "};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        

        try {
            
            String SQL = "SELECT * FROM mostrarListaDetalle WHERE idcita = '"+idcita+"';";
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idexamen");
                registros[1] = resultados.getString("nombreexamen");
                registros[2] = resultados.getString("precioexamen");
                registros[3] = resultados.getString("categoriaexamen");
                registros[4] = resultados.getString("estado");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
}
