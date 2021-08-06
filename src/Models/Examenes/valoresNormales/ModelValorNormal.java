package Models.Examenes.valoresNormales;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelValorNormal {

    public void create(int idExamen, double desde, double hasta, String genero) {

        try {
            String SQL = "CALL registrarValorNormal(?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idExamen);
            consulta.setDouble(2, desde);
            consulta.setDouble(3, hasta);
            consulta.setString(4, genero);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Rango registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel read(int idExamen) {
        String[] titulos = {" ID ", " Valor desde ", " valor hasta ", " Genero "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaValorNormal WHERE idexamen = " + idExamen;

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idvalornormal");
                registros[1] = resultados.getString("valor_desde");
                registros[2] = resultados.getString("valor_hasta");
                registros[3] = resultados.getString("genero");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void update(int idValorNormal,int idExamen, double desde, double hasta, String genero) {
        try {
            String SQL = "CALL editarValorNormal(?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idValorNormal);
            consulta.setInt(2, idExamen);
            consulta.setDouble(3, desde);
            consulta.setDouble(4, hasta);
            consulta.setString(5, genero);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Valor Normal actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int idValorNormal, int idExamen) {

        String SQL = "CALL eliminarValorNormal(?,?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idValorNormal);
            consulta.setInt(2, idExamen);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Valor Normal Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel search(int idexamen, String value) {

        String[] titulos = {" ID ", " Valor desde ", " valor hasta ", " Genero "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarValorNormal(" + idexamen + ",'" + value + "')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idvalornormal");
                registros[1] = resultados.getString("valor_desde");
                registros[2] = resultados.getString("valor_hasta");
                registros[3] = resultados.getString("genero");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

}
