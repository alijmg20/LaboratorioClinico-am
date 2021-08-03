
package Models.Empleados;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

// String SQL = "SELECT * FROM pacientes WHERE idpaciente LIKE '%"+buscar+"%' OR nombre LIKE '%"+buscar+"%' OR cedula LIKE '%"+buscar+"%'";

public class ModelListadoEmpleados {
    
    public DefaultTableModel read() {
        String[] titulos = {" ID ", " Nombre ", " Usuario "," Cedula ", " Telefono ", " Tipo "};
        String[] registros = new String[7];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaEmpleado";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idempleado");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("username");
                registros[3] = resultados.getString("cedula");
                registros[4] = resultados.getString("telefono");
                registros[5] = resultados.getString("nombretipoe");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
        public DefaultTableModel buscarPaciente(String buscar) {
        String[] titulos = {" ID ", " Nombre ", " Usuario "," Cedula ", " Telefono ", " Tipo "};
        String[] registros = new String[7];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT e.idempleado, e.nombre, e.username, e.cedula, e.telefono, tp.nombre as nombretipoe"
                + " from (empleados e join tipoempleado tp on(e.idtipoempleado = tp.idtipoe))  WHERE "
                + " idempleado LIKE '%"+buscar+"%' "
                + "OR e.nombre LIKE '%"+buscar+"%' OR e.cedula LIKE '%"+buscar+"%' OR e.username LIKE '%"+buscar+"%'"
                + "";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idempleado");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("username");
                registros[3] = resultados.getString("cedula");
                registros[4] = resultados.getString("telefono");
                registros[5] = resultados.getString("nombretipoe");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    } 
    
    
}
