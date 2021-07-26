package views;

import Controllers.ConnectionDB;
import java.awt.Component;
import java.sql.Connection;
import views.Empleados.Empleados;
import views.Empleados.ListadoEmpleados;
import views.Empleados.TipoEmpleado;
import views.Pacientes.ListadoPacientes;
import views.Pacientes.Pacientes;
import views.admin.Login;

public class Index extends javax.swing.JFrame {

    public static ConnectionDB con = new ConnectionDB();
    public static Connection connection = con.conectar();
    
    public Index() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
//        stopComponents();
//        Login login = new Login();
//        Index.desktopPane.add(login);
//        login.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        helpMenu1 = new javax.swing.JMenu();
        contentMenuItem1 = new javax.swing.JMenuItem();
        aboutMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        cutMenuItem = new javax.swing.JMenuItem();
        cutMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/50561.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(0, 0, 1638, 1067);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Pacientes");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Acciones de pacientes");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Listar Pacientes");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        helpMenu1.setMnemonic('h');
        helpMenu1.setText("Examenes");

        contentMenuItem1.setMnemonic('c');
        contentMenuItem1.setText("Contents");
        helpMenu1.add(contentMenuItem1);

        aboutMenuItem1.setMnemonic('a');
        aboutMenuItem1.setText("About");
        helpMenu1.add(aboutMenuItem1);

        menuBar.add(helpMenu1);

        editMenu.setMnemonic('e');
        editMenu.setText("Empleados");

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Acciones de tipo Empleado");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Acciones de empleados");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem);

        cutMenuItem1.setMnemonic('t');
        cutMenuItem1.setText("Listar Empleados");
        cutMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(cutMenuItem1);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Citas");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Crear citas");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Ver lista de citas");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        ListadoPacientes listadoPacientes = new ListadoPacientes();
        Index.desktopPane.add(listadoPacientes);
        listadoPacientes.show();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        Pacientes paciente = new Pacientes();
        Index.desktopPane.add(paciente);
        paciente.show();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        TipoEmpleado tipoEmpleado = new TipoEmpleado();
        Index.desktopPane.add(tipoEmpleado);
        tipoEmpleado.show();
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        Empleados empleados = new Empleados();
        Index.desktopPane.add(empleados);
        empleados.show();
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void cutMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItem1ActionPerformed
        ListadoEmpleados  listado = new ListadoEmpleados();
        Index.desktopPane.add(listado);
        listado.show();
    }//GEN-LAST:event_cutMenuItem1ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    public static void stopComponents() {
        Component[] components = Index.desktopPane.getComponents();
        Component[] bars = Index.menuBar.getComponents();
        for (Component component : components) {
            component.setEnabled(false);
        }
        for(Component bar : bars){
            bar.setEnabled(false);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem aboutMenuItem1;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem contentMenuItem1;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem cutMenuItem1;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu helpMenu1;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
