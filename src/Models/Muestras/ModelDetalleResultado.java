package Models.Muestras;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelDetalleResultado {

    public Object[] readHeader(int idcita) {
        String SQL = "SELECT * FROM mostrarCabeceraResultado WHERE idcita=" + idcita;
        try {
            Object[] objeto;
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            objeto = new Object[]{
                resultados.getString("idcita"),
                resultados.getString("fecha_emision"),
                resultados.getString("nombrepaciente"),
                resultados.getString("sexopaciente"),
                resultados.getString("fechanacimientopaciente"),
                resultados.getString("cedulapaciente"),
                resultados.getString("correopaciente"),
                resultados.getString("direccionpaciente"),
                resultados.getString("telefonopaciente"),
                resultados.getString("nombreempleado"),
                resultados.getString("correoempleado"),
                resultados.getString("telefonoempleado"),
                resultados.getString("direccionempleado"),};
            return objeto;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public DefaultTableModel read(int idCita) {
        String[] titulos = {" nombre Examen ", " Resultado ", " ", " Diagnostico ", " categoria "};
        String[] registros = new String[5];
        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarCuerpoResultado WHERE idcita="+idCita;

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("nombreexamen");
                registros[1] = resultados.getString("valorresultado");
                registros[2] = resultados.getString("unidadexamen");
                registros[3] = resultados.getString("descripcionresultado");
                registros[4] = resultados.getString("categoriaexamen");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

}
