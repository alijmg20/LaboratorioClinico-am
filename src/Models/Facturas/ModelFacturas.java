
package Models.Facturas;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;


public class ModelFacturas {
    
        public DefaultTableModel mostrarInterfaz() {
        String[] titulos = {"ID Factura", "ID Cita", "Nombre", "Cedula","Fecha de pago"};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaFacturas";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idfactura");
                registros[1] = resultados.getString("idcita");
                registros[2] = resultados.getString("nombrepaciente");
                registros[3] = resultados.getString("cedulapaciente");
                registros[4] = resultados.getString("fecha_pagada");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
        public DefaultTableModel mostrarTxt() {
        String[] titulos = {"ID Factura", "ID Cita", "Nombre", "Cedula","Fecha pago","precio_total"};
        String[] registros = new String[6];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaFacturas";

        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idfactura");
                registros[1] = resultados.getString("idcita");
                registros[2] = resultados.getString("nombrepaciente");
                registros[3] = resultados.getString("cedulapaciente");
                registros[4] = resultados.getString("fecha_pagada");
                registros[5] = resultados.getString("precio_total");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
        public void create(int precio, String fecha_pagada, int idempleado, int idcita){
        
        try {

            long fechaInterfaz = java.util.Date.parse(fecha_pagada);
            Date fecha = new Date(fechaInterfaz);
            String SQL = "CALL registrarFactura(?,?,?,?)";
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);

            consulta.setInt(1, precio); 
            consulta.setDate(2, fecha); // fecha de pago 
            consulta.setInt(3, idempleado);
            consulta.setInt(4, idcita);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Factura registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void delete(int idfactura) {
        
        String SQL = "CALL eliminarFactura(?)";

        try {
            PreparedStatement consulta = Index.connection.prepareStatement(SQL);
            consulta.setInt(1, idfactura);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Factura eliminada exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la factura " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }
        
        
         public DefaultTableModel buscarFactura(String buscar) {
        String[] titulos = {"ID Factura", "ID Cita", "Nombre", "Cedula","Fecha de pago"};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM mostrarListaFacturas WHERE cedulapaciente LIKE '%"+buscar+"%' OR nombrepaciente LIKE '%"+buscar+"%' OR idcita LIKE '%"+buscar+"%'";
        
        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idfactura");
                registros[1] = resultados.getString("idcita");
                registros[2] = resultados.getString("nombrepaciente");
                registros[3] = resultados.getString("cedulapaciente");
                registros[4] = resultados.getString("fecha_pagada");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
        
    
         public int calcularTotal(int idcita){
             
       // String[] titulos = {"ID Factura", "ID Cita", "Nombre", "Cedula","Fecha de pago"};
       // String[] registros = new String[5];

      //  DefaultTableModel tabla = new DefaultTableModel(null, titulos);
      int resultado = 0; 
       String SQL = "SELECT SUM(precioexamen) AS total FROM mostrarListaDetalle WHERE idcita = '"+idcita+"';";
            
        try {
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                resultado = Integer.parseInt(resultados.getString("total"));
             
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al calcular " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
             
             return resultado;
         }
         
}
