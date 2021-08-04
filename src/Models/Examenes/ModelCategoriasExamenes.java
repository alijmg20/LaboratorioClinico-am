
package Models.Examenes;

import Models.Models.ModelCore;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelCategoriasExamenes extends ModelCore{

    
    public DefaultTableModel mostrarTxt() {
        
       String[] titulos = {" ID ", " nombre ", " descripcion"};
        String[] registros = new String[3];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaCategoria";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcategoria");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("descripcion");
                tabla.addRow(registros);

            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
        
    }

  
    public void delete(int id) {
        super.delete(); //To change body of generated methods, choose Tools | Templates.
        String SQL = "CALL eliminarCategoria(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, id);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria eliminada exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: el paciente tiene citas registradas en el sistema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    public void update(int id, String nombre, String descripcion) {
            try {
            String SQL = "CALL editarCategoria(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            
            consulta.setInt(1, id);
            consulta.setString(2, nombre);
            consulta.setString(3, descripcion);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Categoria actualizada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

   
    public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {" ID ", " Nombre "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaCategoria";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcategoria");
                registros[1] = resultados.getString("nombre");
                
                
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
        
    }

   
    public void create(String nombre, String descripcion) {
         try {
            String SQL = "CALL registrarCategoria(?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Categoria registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
