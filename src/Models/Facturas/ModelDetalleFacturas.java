
package Models.Facturas;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.Index;


public class ModelDetalleFacturas {
    
        public Object[] readHeader(int idfactura) {
        String SQL = "SELECT * FROM mostrarCabeceraFactura WHERE idfactura=" + idfactura;
        try {
            Object[] objeto;
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            objeto = new Object[]{
                resultados.getString("idfactura"),
                resultados.getString("fecha_pagada"),
                resultados.getString("nombrepaciente"),
                resultados.getString("sexopaciente"),
                resultados.getString("fechanacimientopaciente"),
                resultados.getString("cedulapaciente"),
                resultados.getString("correopaciente"),
                resultados.getString("direccionpaciente"),
                resultados.getString("telefonopaciente"),
                resultados.getString("montoTotal"),};
            return objeto;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public DefaultTableModel mostrarInterfaz(int idcita) {
        String[] titulos = {" ID ", " Nombre ", " Precio ", " Categoria "};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        

        try {
            
            String SQL = "SELECT * FROM mostrarListaDetalle WHERE idcita = '"+idcita+"';";
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("idexamen");
                registros[1] = resultados.getString("nombreexamen");
                registros[2] = resultados.getString("precioexamen");
                registros[3] = resultados.getString("categoriaexamen");
                
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
}
