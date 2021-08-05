package Models.Examenes.valoresNormales;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelTipoValor {

    public void create(int idExamen, String valor) {

        try {
            String SQL = "CALL registrarTipoValor(?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idExamen);
            consulta.setString(2, valor);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Valor Normal registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel read(int idExamen) {
        String[] titulos = {" ID ", " Valor "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaTipoValor WHERE idexamen = " + idExamen;

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idtipovalor");
                registros[1] = resultados.getString("valor");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void update(int idTipoValor, int idExamen, String valor) {
        try {
            String SQL = "CALL editarTipoValor(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idTipoValor);
            consulta.setInt(2, idExamen);
            consulta.setString(3, valor);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Valor Normal actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int idTipoValor,int idExamen) {

        String SQL = "CALL eliminarTipoValor(?,?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idTipoValor);
            consulta.setInt(2, idExamen);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Valor Normal Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public DefaultTableModel search(int idexamen,String value) {
        
        String[] titulos = {" ID ", " Valor "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarTipoValor("+idexamen+",'"+value+"')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idtipovalor");
                registros[1] = resultados.getString("valor");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    

}
