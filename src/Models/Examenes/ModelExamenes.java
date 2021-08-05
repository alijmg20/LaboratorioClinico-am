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

public class ModelExamenes extends ModelCore {

    public void create(String nombre, double precio, String tipov ,String unidad, String Nombrecategoria) {
        try {
            String SQL = "CALL registrarExamen(?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setDouble(2, precio);
            consulta.setString(3, tipov);
            consulta.setString(4, unidad);
            consulta.setString(5, Nombrecategoria);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Examen registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public DefaultTableModel read() {
        String[] titulos = {" ID ", " Nombre ", " Precio ", " tipov ", " unidad " ," categoria "};
        String[] registros = new String[6];
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaExamenes";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idexamen");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("precio");
                registros[3] = resultados.getString("tipov");
                registros[4] = resultados.getString("descripcionu");
                registros[5] = resultados.getString("nombrec");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public DefaultTableModel readUnsets() {
        String[] titulos = {" ID ", " Nombre ", " Precio ", " Categoria "};
        String[] registros = new String[4];
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaExamenes";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idexamen");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("precio");
                registros[3] = resultados.getString("nombrec");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void update(int id, String nombre, double precio,String tipov ,String unidad, String Nombrecategoria) {
        try {
            String SQL = "CALL editarExamen(?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setInt(1, id);
            consulta.setString(2, nombre);
            consulta.setDouble(3, precio);
            consulta.setString(4, tipov);
            consulta.setString(5, unidad);
            consulta.setString(6, Nombrecategoria);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Examen actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int id) {

        String SQL = "CALL eliminarExamen(?)";
        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, id);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Examen eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: el paciente tiene citas registradas en el sistema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public DefaultTableModel searchUnset(String value) {

        String[] titulos = {" ID ", " Nombre ", " Precio ", " Categoria "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarExamenes('" + value + "')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idexamen");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("precio");
                registros[3] = resultados.getString("nombrec");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    

}
