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
import views.Citas.Citas;
import views.Facturas.Facturas;
import views.Facturas.visualizarExamen;
import views.Facturas.visualizarFacturas;
import views.Muestras.DatosMuestras;
import views.Muestras.Muestras;
import views.examenes.Categoria;
import views.examenes.Examenes;

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
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
        helpMenu2 = new javax.swing.JMenu();
        contentMenuItem2 = new javax.swing.JMenuItem();
        aboutMenuItem2 = new javax.swing.JMenuItem();
        helpMenu3 = new javax.swing.JMenu();
        contentMenuItem3 = new javax.swing.JMenuItem();
        aboutMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setToolTipText("");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Examenes");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton1);
        jButton1.setBounds(150, 520, 180, 50);

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setText("Empleados");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton2);
        jButton2.setBounds(150, 400, 180, 50);

        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setText("Pacientes");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton3);
        jButton3.setBounds(150, 190, 180, 50);

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setText("Facturas");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton4);
        jButton4.setBounds(150, 620, 180, 50);

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setText("Citas");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton5);
        jButton5.setBounds(150, 290, 180, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel2.setText("<html>\n\t<body>\n\t\tSoftware administrativo\n\t\t<br>\n\t\tpara el control y gestión\n\t\t<br>\n\t\tde laboratorios clinicos\n\t</body>\n\n</html>");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(720, 20, 450, 330);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 150)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("AMLAB");
        desktopPane.add(jLabel3);
        jLabel3.setBounds(720, 400, 480, 250);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/50561.jpg"))); // NOI18N
        Fondo.setRequestFocusEnabled(false);
        Fondo.setVerifyInputWhenFocusTarget(false);
        desktopPane.add(Fondo);
        Fondo.setBounds(0, 0, 1600, 1067);

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
        contentMenuItem1.setText("Categorias");
        contentMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItem1ActionPerformed(evt);
            }
        });
        helpMenu1.add(contentMenuItem1);

        aboutMenuItem1.setMnemonic('a');
        aboutMenuItem1.setText("Acciones examenes");
        aboutMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem1ActionPerformed(evt);
            }
        });
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
        contentMenuItem.setText("Acciones de citas");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Ver lista de citas");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        helpMenu2.setMnemonic('h');
        helpMenu2.setText("Muestras");

        contentMenuItem2.setMnemonic('c');
        contentMenuItem2.setText("Analisis de muestra");
        contentMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItem2ActionPerformed(evt);
            }
        });
        helpMenu2.add(contentMenuItem2);

        aboutMenuItem2.setMnemonic('a');
        aboutMenuItem2.setText("Resultados de muestras");
        aboutMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem2ActionPerformed(evt);
            }
        });
        helpMenu2.add(aboutMenuItem2);

        menuBar.add(helpMenu2);

        helpMenu3.setMnemonic('h');
        helpMenu3.setText("Facturas");

        contentMenuItem3.setMnemonic('c');
        contentMenuItem3.setText("Acciones de facturas");
        contentMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItem3ActionPerformed(evt);
            }
        });
        helpMenu3.add(contentMenuItem3);

        aboutMenuItem3.setMnemonic('a');
        aboutMenuItem3.setText("Ver lista de facturas");
        aboutMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItem3ActionPerformed(evt);
            }
        });
        helpMenu3.add(aboutMenuItem3);

        menuBar.add(helpMenu3);

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

    private void contentMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItem1ActionPerformed
        Categoria categorias = new Categoria();
        Index.desktopPane.add(categorias);
        categorias.show();
    }//GEN-LAST:event_contentMenuItem1ActionPerformed

    private void aboutMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem1ActionPerformed
        Examenes examenes = new Examenes();
        Index.desktopPane.add(examenes);
        examenes.show();
    }//GEN-LAST:event_aboutMenuItem1ActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        Citas citas = new Citas();
        Index.desktopPane.add(citas);
        citas.show();
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void contentMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItem2ActionPerformed
        // TODO add your handling code here:
        Muestras muestra = new Muestras();
        Index.desktopPane.add(muestra);
        muestra.show();
    }//GEN-LAST:event_contentMenuItem2ActionPerformed

    private void contentMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItem3ActionPerformed
        
        Facturas factura = new Facturas();
        Index.desktopPane.add(factura);
        factura.show();
                
    }//GEN-LAST:event_contentMenuItem3ActionPerformed

    private void aboutMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem3ActionPerformed
        // TODO add your handling code here:
        visualizarFacturas facturas = new visualizarFacturas();
        Index.desktopPane.add(facturas);
        facturas.show();
    }//GEN-LAST:event_aboutMenuItem3ActionPerformed

    private void aboutMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItem2ActionPerformed
        // TODO add your handling code here:
        DatosMuestras datom = new DatosMuestras();
        Index.desktopPane.add(datom);
        datom.show();
    }//GEN-LAST:event_aboutMenuItem2ActionPerformed

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
    private javax.swing.JLabel Fondo;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem aboutMenuItem1;
    private javax.swing.JMenuItem aboutMenuItem2;
    private javax.swing.JMenuItem aboutMenuItem3;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem contentMenuItem1;
    private javax.swing.JMenuItem contentMenuItem2;
    private javax.swing.JMenuItem contentMenuItem3;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem cutMenuItem1;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu helpMenu1;
    private javax.swing.JMenu helpMenu2;
    private javax.swing.JMenu helpMenu3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
