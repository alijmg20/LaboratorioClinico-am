package Models.Muestras;

import Models.Models.ModelCore;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelMuestras extends ModelCore {

    public void create(String resultado, String descripcion, int iddetalleCita, int idEmpleado) {

        try {
            String SQL = "CALL registrarMuestra(?,NULL,?,NOW(),?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, resultado);
            consulta.setString(2, descripcion);
            consulta.setInt(3, iddetalleCita);
            consulta.setInt(4, idEmpleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Resultado de muestra registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(String resultado, String descripcion, int iddetalleCita) {
        try {
            String SQL = "CALL editarMuestra(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setString(1, resultado);
            consulta.setString(2, descripcion);
            consulta.setInt(3, iddetalleCita);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Resultado de muestra actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int iddetalleCita) {

        String SQL = "CALL eliminarMuestra(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, iddetalleCita);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Resultado de muestra Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel readUnset(int idcita) {
        String[] titulos = {" ID ", " examen ", " estado ", " categoria "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM MostrarListaMuestras WHERE idcita=" + idcita;

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("iddetallescita");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("estado");
                registros[3] = resultados.getString("nombrecat");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public DefaultTableModel read(int iddetalle) {
        String[] titulos = {" ID ", " valor ", " descripcion "};
        String[] registros = new String[3];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM muestras WHERE iddetallescita=" + iddetalle;

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("iddetallescita");
                registros[1] = resultados.getString("valor");
                registros[2] = resultados.getString("descripcion");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
        public DefaultTableModel search(int idcita,String valor) {
        String[] titulos = {" ID ", " examen ", " estado ", " categoria "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM MostrarListaMuestras WHERE idcita=" + idcita+" "
                + " AND (iddetallescita LIKE CONCAT('%','"+valor+"','%') "
                + " OR nombre LIKE CONCAT('%','"+valor+"','%')"
                + " OR nombrecat LIKE CONCAT('%','"+valor+"','%'))";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("iddetallescita");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("estado");
                registros[3] = resultados.getString("nombrecat");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    

}
