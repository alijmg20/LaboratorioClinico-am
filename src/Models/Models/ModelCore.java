package Models.Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import views.Index;

public class ModelCore {

//------------------------------------------------------------------------------
    public  void create() {
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
    public void obtenerDatosCombobox(JComboBox cb,String funcion,String dato) {
        try {                           //mostrarListaTipoEmpleado
            String SQL = "SELECT * FROM "+funcion;
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {      //"nombre"
                cb.addItem(resultado.getString(dato));
            }
        } catch (Exception ex) {

        }
    }
    
    public boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    

    
}
