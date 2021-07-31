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

    public void create(String nombre, String username, String correo,
            String clave, int cedula, char sexo, String fecha_nacimiento,
            String telefono, String direccion, String NombreTipoEmpleado) {

        try {

            long fechaLong1 = java.util.Date.parse(fecha_nacimiento);
            Date fechaDate1 = new Date(fechaLong1);

            String SQL = "CALL registrarEmpleado(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setString(2, username);
            consulta.setString(3, correo);
            consulta.setString(4, clave);
            consulta.setInt(5, cedula);
            consulta.setString(6, String.valueOf(sexo));
            consulta.setDate(7, fechaDate1);
            consulta.setString(8, telefono);
            consulta.setString(9, direccion);
            consulta.setString(10, NombreTipoEmpleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public DefaultTableModel read() {
        String[] titulos = {" ID ", " Nombre ", " Usuario ", " correo ", " clave ", " Cedula ", " Sexo ",
            " fecha de nacimiento ", " Telefono ", " Direccion ", " Tipo "};
        String[] registros = new String[11];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL mostrarListaEmpleado()";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idempleado");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("username");
                registros[3] = resultados.getString("correo");
                registros[4] = resultados.getString("clave");
                registros[5] = resultados.getString("cedula");
                registros[6] = resultados.getString("sexo");
                String FormatoFecha1 = resultados.getString("fecha_nacimiento");
                String fecha1 = FormatoFecha1.replace("-", "/");
                registros[7] = fecha1;
                registros[8] = resultados.getString("telefono");
                registros[9] = resultados.getString("direccion");
                registros[10] = resultados.getString("nombretipoe");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public DefaultTableModel readUnsets() {
        String[] titulos = {" ID ", " Cedula ", " Nombre ", " Usuario ", " Tipo "};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL mostrarListaEmpleado()";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idempleado");
                registros[1] = resultados.getString("cedula");
                registros[2] = resultados.getString("nombre");
                registros[3] = resultados.getString("username");
                registros[4] = resultados.getString("nombretipoe");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void update(int id, String nombre, String username, String correo,
            String clave, int cedula, char sexo, String fecha_nacimiento,
            String telefono, String direccion, String NombreTipoEmpleado) {
        try {

            long fechaLong1 = java.util.Date.parse(fecha_nacimiento);
            Date fechaDate1 = new Date(fechaLong1);

            String SQL = "CALL editarEmpleado(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, id);
            consulta.setString(2, nombre);
            consulta.setString(3, username);
            consulta.setString(4, correo);
            consulta.setString(5, clave);
            consulta.setInt(6, cedula);
            consulta.setString(7, String.valueOf(sexo));
            consulta.setDate(8, fechaDate1);
            consulta.setString(9, telefono);
            consulta.setString(10, direccion);
            consulta.setString(11, NombreTipoEmpleado);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int idempleado) {

        String SQL = "CALL eliminarEmpleado(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idempleado);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel searchUnset(String value) {

        String[] titulos = {" ID ", " Cedula ", " Nombre ", " Usuario ", " Tipo "};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "CALL filtrarEmpleado('" + value + "')";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idempleado");
                registros[1] = resultados.getString("cedula");
                registros[2] = resultados.getString("nombre");
                registros[3] = resultados.getString("username");
                registros[4] = resultados.getString("nombretipoe");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

}
