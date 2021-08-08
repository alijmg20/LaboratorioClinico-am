
package Models.admin;

import Class.Usuario;
import Models.Models.ModelCore;
import controllers.SecurityKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import views.Index;

public class ModelAdmin extends ModelCore {
    
    public Usuario inUser(String usuario, String password){
        
        String SQL = "CALL IngresarSistema('"+usuario+"','"+password+"')";
        
        try{
            Statement consulta = Index.connection.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            String pass = resultados.getString("clave");
            String desencriptado = SecurityKey.Desencriptar(pass);
            
            if(desencriptado.equals(password)){
                return new Usuario(resultados.getInt("idempleado"),resultados.getString("nombre"),resultados.getInt("idtipoempleado"));
                
            }
        }catch(SQLException | NumberFormatException e){
            //JOptionPane.showMessageDialog(null, "Error al ingresar al sistema " + e.getMessage(),"",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al ingresar al sistema " + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
}
