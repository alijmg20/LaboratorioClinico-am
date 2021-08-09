package Models.Muestras;

import Models.Models.ModelCore;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelAnalisis extends ModelCore {

    public DefaultTableModel read() {
        String[] titulos = {"ID", "Fecha Agendada", "Nombre Paciente", "Cedula"," estado "};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaAnalisis ";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcita");
                registros[1] = resultados.getString("fecha_agendada");
                registros[2] = resultados.getString("nombre");
                registros[3] = resultados.getString("cedula");
                registros[4] = resultados.getString("statusCita");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    public DefaultTableModel buscarCita(String buscar) {
        String[] titulos = {"ID", "Fecha Agendada", "Nombre Paciente", "Cedula"," estado "};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaAnalisis WHERE cedula LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%' OR idcita LIKE '%"+buscar+"%'";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idcita");
                registros[1] = resultados.getString("fecha_agendada");
                registros[2] = resultados.getString("nombre");
                registros[3] = resultados.getString("cedula");
                registros[4] = resultados.getString("statusCita");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    

}
