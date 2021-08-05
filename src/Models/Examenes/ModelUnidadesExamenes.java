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

public class ModelUnidadesExamenes extends ModelCore {

    public DefaultTableModel mostrarTxt() {

        String[] titulos = {" ID ", " descripcion"};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaUnidades";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idunidad");
                registros[1] = resultados.getString("descripcion");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;

    }

    public void delete(int id) {
        super.delete(); //To change body of generated methods, choose Tools | Templates.
        String SQL = "CALL eliminarUnidades(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, id);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "unidad eliminada exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: al eliminar datos en el sistema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(int id, String descripcion) {
        try {
            String SQL = "CALL editarUnidades(?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setInt(1, id);
            consulta.setString(2, descripcion);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "unidad actualizada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {" ID ", " Descripcion "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaUnidades";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idunidad");
                registros[1] = resultados.getString("descripcion");

                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;

    }

    public void create(String descripcion) {
        try {
            String SQL = "CALL registrarUnidad(?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, descripcion);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "unidad registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel searchUnset(String value) {

        String[] titulos = {" ID ", " descripcion "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarUnidad('" + value + "')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idunidad");
                registros[1] = resultados.getString("descripcion");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

}
