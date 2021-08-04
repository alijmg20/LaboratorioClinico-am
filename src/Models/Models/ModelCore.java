package Models.Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelCore {

//------------------------------------------------------------------------------
    public void create() {
        System.out.println("This model register in database");
    }

    public DefaultTableModel read() {
        return new DefaultTableModel();
    }

    public void update() {
        System.out.println("This model update in database");
    }

    public void delete() {
        System.out.println("This model delete in database");
    }
    
        public DefaultTableModel search() {
        return new DefaultTableModel();
    }
        

//------------------------------------------------------------------------------
    public void obtenerTiposEmpleados(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM mostrarListaTipoEmpleado";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombre"));
            }
        } catch (Exception ex) {

        }
    }

    
}
