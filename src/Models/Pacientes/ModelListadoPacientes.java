
package Models.Pacientes;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelListadoPacientes {
    
        public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {" ID ", " Nombre ", " Cedula ", " sexo "," Telefono "," Correo "," Direccion "};
        String[] registros = new String[8];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaPacientes";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idpaciente");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("cedula");
                registros[3] = resultados.getString("sexo");
                registros[4] = resultados.getString("telefono");
                registros[5] = resultados.getString("correo");
                registros[6] = resultados.getString("direccion");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
        public DefaultTableModel buscarPaciente(String buscar) {
        String[] titulos = {" ID ", " Nombre ", " Cedula ", " sexo "," Telefono "," Correo "," Direccion "};
        String[] registros = new String[8];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM pacientes WHERE idpaciente LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%' OR cedula LIKE '%"+buscar+"%'";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idpaciente");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("cedula");
                registros[3] = resultados.getString("sexo");
                registros[4] = resultados.getString("telefono");
                registros[5] = resultados.getString("correo");
                registros[6] = resultados.getString("direccion");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    } 
    
}
