package views;

import Class.Usuario;
import Controllers.ConnectionDB;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import views.Empleados.Empleados;
import views.Empleados.ListadoEmpleados;
import views.Empleados.TipoEmpleado;
import views.Pacientes.ListadoPacientes;
import views.Pacientes.Pacientes;
import views.Citas.Citas;
import views.Empleados.Empleados;
import views.Facturas.Facturas;
import views.Facturas.visualizarFacturas;
import views.Muestras.DatosMuestras;
import views.Muestras.Muestras;
import views.Muestras.Resultados;
import views.admin.Login;
import views.examenes.Categoria;
import views.examenes.Examenes;
import views.examenes.Unidad;

public class Index extends javax.swing.JFrame {

    public static ConnectionDB con = new ConnectionDB();
    public static Connection connection = con.conectar();
    public static Usuario user = null;

    public Index() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        stopComponents();
        Login login = new Login();
        Index.desktopPane.add(login);
        login.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        btnExamenes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnFacturas = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        filePacientes = new javax.swing.JMenu();
        acPacientes = new javax.swing.JMenuItem();
        aclistPacientes = new javax.swing.JMenuItem();
        fileEmpleados = new javax.swing.JMenu();
        acTipEmpleados = new javax.swing.JMenuItem();
        acEmpleados = new javax.swing.JMenuItem();
        aclistEmpleados = new javax.swing.JMenuItem();
        fileExamSistema = new javax.swing.JMenu();
        acCategorias = new javax.swing.JMenuItem();
        acUnidades = new javax.swing.JMenuItem();
        acExamSistema = new javax.swing.JMenuItem();
        fileCitas = new javax.swing.JMenu();
        acCitas = new javax.swing.JMenuItem();
        aclistCitas = new javax.swing.JMenuItem();
        fileExamPacientes = new javax.swing.JMenu();
        acAnalisis = new javax.swing.JMenuItem();
        FilesResultados = new javax.swing.JMenuItem();
        fileFacturas = new javax.swing.JMenu();
        acFacturas = new javax.swing.JMenuItem();
        aclistFacturas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setToolTipText("");

        btnExamenes.setBackground(new java.awt.Color(180, 185, 210));
        btnExamenes.setFont(new java.awt.Font("COCOGOOSE ", 1, 12)); // NOI18N
        btnExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/Examenes.png"))); // NOI18N
        btnExamenes.setText("Examenes");
        btnExamenes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExamenes.setMaximumSize(new java.awt.Dimension(129, 61));
        btnExamenes.setMinimumSize(new java.awt.Dimension(129, 61));
        btnExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExamenesActionPerformed(evt);
            }
        });
        desktopPane.add(btnExamenes);
        btnExamenes.setBounds(150, 520, 180, 60);

        btnEmpleados.setBackground(new java.awt.Color(180, 185, 210));
        btnEmpleados.setFont(new java.awt.Font("COCOGOOSE ", 1, 12)); // NOI18N
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/empleado.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleados.setMaximumSize(new java.awt.Dimension(129, 61));
        btnEmpleados.setMinimumSize(new java.awt.Dimension(129, 61));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });
        desktopPane.add(btnEmpleados);
        btnEmpleados.setBounds(150, 400, 180, 60);

        btnPacientes.setBackground(new java.awt.Color(180, 185, 210));
        btnPacientes.setFont(new java.awt.Font("COCOGOOSE ", 1, 12)); // NOI18N
        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/paciente.png"))); // NOI18N
        btnPacientes.setText("Pacientes");
        btnPacientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        desktopPane.add(btnPacientes);
        btnPacientes.setBounds(150, 170, 180, 60);

        btnFacturas.setBackground(new java.awt.Color(180, 185, 210));
        btnFacturas.setFont(new java.awt.Font("COCOGOOSE ", 1, 12)); // NOI18N
        btnFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/Facturas.png"))); // NOI18N
        btnFacturas.setText("Facturas");
        btnFacturas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFacturas.setMaximumSize(new java.awt.Dimension(129, 61));
        btnFacturas.setMinimumSize(new java.awt.Dimension(129, 61));
        btnFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturasActionPerformed(evt);
            }
        });
        desktopPane.add(btnFacturas);
        btnFacturas.setBounds(150, 620, 180, 60);

        btnCitas.setBackground(new java.awt.Color(180, 185, 210));
        btnCitas.setFont(new java.awt.Font("COCOGOOSE ", 1, 12)); // NOI18N
        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/Citas.png"))); // NOI18N
        btnCitas.setText("Citas");
        btnCitas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCitas.setMaximumSize(new java.awt.Dimension(129, 61));
        btnCitas.setMinimumSize(new java.awt.Dimension(129, 61));
        btnCitas.setPreferredSize(new java.awt.Dimension(129, 61));
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });
        desktopPane.add(btnCitas);
        btnCitas.setBounds(150, 290, 180, 60);

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publics/img/50561.jpg"))); // NOI18N
        Fondo.setRequestFocusEnabled(false);
        Fondo.setVerifyInputWhenFocusTarget(false);
        desktopPane.add(Fondo);
        Fondo.setBounds(0, 0, 1600, 1067);

        filePacientes.setMnemonic('f');
        filePacientes.setText("Pacientes");

        acPacientes.setMnemonic('o');
        acPacientes.setText("Acciones de pacientes");
        acPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acPacientesActionPerformed(evt);
            }
        });
        filePacientes.add(acPacientes);

        aclistPacientes.setMnemonic('s');
        aclistPacientes.setText("Listar Pacientes");
        aclistPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclistPacientesActionPerformed(evt);
            }
        });
        filePacientes.add(aclistPacientes);

        menuBar.add(filePacientes);

        fileEmpleados.setMnemonic('e');
        fileEmpleados.setText("Empleados");

        acTipEmpleados.setMnemonic('y');
        acTipEmpleados.setText("Acciones de tipo Empleado");
        acTipEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acTipEmpleadosActionPerformed(evt);
            }
        });
        fileEmpleados.add(acTipEmpleados);

        acEmpleados.setMnemonic('y');
        acEmpleados.setText("Acciones de empleados");
        acEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acEmpleadosActionPerformed(evt);
            }
        });
        fileEmpleados.add(acEmpleados);

        aclistEmpleados.setMnemonic('t');
        aclistEmpleados.setText("Listar Empleados");
        aclistEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclistEmpleadosActionPerformed(evt);
            }
        });
        fileEmpleados.add(aclistEmpleados);

        menuBar.add(fileEmpleados);

        fileExamSistema.setMnemonic('h');
        fileExamSistema.setText("Examenes del sistema");

        acCategorias.setMnemonic('c');
        acCategorias.setText("Categorias");
        acCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acCategoriasActionPerformed(evt);
            }
        });
        fileExamSistema.add(acCategorias);

        acUnidades.setMnemonic('c');
        acUnidades.setText("Unidades");
        acUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acUnidadesActionPerformed(evt);
            }
        });
        fileExamSistema.add(acUnidades);

        acExamSistema.setMnemonic('a');
        acExamSistema.setText("Acciones examenes");
        acExamSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acExamSistemaActionPerformed(evt);
            }
        });
        fileExamSistema.add(acExamSistema);

        menuBar.add(fileExamSistema);

        fileCitas.setMnemonic('h');
        fileCitas.setText("Citas");

        acCitas.setMnemonic('c');
        acCitas.setText("Acciones de citas");
        acCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acCitasActionPerformed(evt);
            }
        });
        fileCitas.add(acCitas);

        aclistCitas.setMnemonic('a');
        aclistCitas.setText("Ver lista de citas");
        fileCitas.add(aclistCitas);

        menuBar.add(fileCitas);

        fileExamPacientes.setMnemonic('h');
        fileExamPacientes.setText("Examenes de pacientes");

        acAnalisis.setMnemonic('c');
        acAnalisis.setText("Analizar muestras de examenes");
        acAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acAnalisisActionPerformed(evt);
            }
        });
        fileExamPacientes.add(acAnalisis);

        FilesResultados.setMnemonic('a');
        FilesResultados.setText("Ver lista de Resultados");
        FilesResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilesResultadosActionPerformed(evt);
            }
        });
        fileExamPacientes.add(FilesResultados);

        menuBar.add(fileExamPacientes);

        fileFacturas.setMnemonic('h');
        fileFacturas.setText("Facturas");

        acFacturas.setMnemonic('c');
        acFacturas.setText("Acciones de facturas");
        acFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acFacturasActionPerformed(evt);
            }
        });
        fileFacturas.add(acFacturas);

        aclistFacturas.setMnemonic('a');
        aclistFacturas.setText("Ver lista de facturas");
        aclistFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aclistFacturasActionPerformed(evt);
            }
        });
        fileFacturas.add(aclistFacturas);

        menuBar.add(fileFacturas);

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


    private void btnExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExamenesActionPerformed
        Examenes examenes = new Examenes();
        Index.desktopPane.add(examenes);
        examenes.show();
    }//GEN-LAST:event_btnExamenesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        Empleados empleados = new Empleados();
        Index.desktopPane.add(empleados);
        empleados.show();
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed

        Pacientes paciente = new Pacientes();
        Index.desktopPane.add(paciente);
        paciente.show();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed

        Citas citas = new Citas();
        Index.desktopPane.add(citas);
        citas.show();
    }//GEN-LAST:event_btnCitasActionPerformed

    private void btnFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturasActionPerformed
        Facturas factura = new Facturas();
        Index.desktopPane.add(factura);
        factura.show();
    }//GEN-LAST:event_btnFacturasActionPerformed

    private void aclistFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclistFacturasActionPerformed

        visualizarFacturas facturas = new visualizarFacturas();
        Index.desktopPane.add(facturas);
        facturas.show();
    }//GEN-LAST:event_aclistFacturasActionPerformed

    private void acFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acFacturasActionPerformed

        Facturas factura = new Facturas();
        Index.desktopPane.add(factura);
        factura.show();
    }//GEN-LAST:event_acFacturasActionPerformed

    private void acAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acAnalisisActionPerformed
        if (Index.user.getIdTipoEmpleado() == 1 || Index.user.getIdTipoEmpleado() == 2) {
            Muestras muestra = new Muestras();
            Index.desktopPane.add(muestra);
            muestra.show();
        }else{
            JOptionPane.showMessageDialog(null, "No esta autorizado para esta accion", "Accion no realizada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_acAnalisisActionPerformed

    private void acCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acCitasActionPerformed
        Citas citas = new Citas();
        Index.desktopPane.add(citas);
        citas.show();
    }//GEN-LAST:event_acCitasActionPerformed

    private void acExamSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acExamSistemaActionPerformed
        Examenes examenes = new Examenes();
        Index.desktopPane.add(examenes);
        examenes.show();
    }//GEN-LAST:event_acExamSistemaActionPerformed

    private void acUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acUnidadesActionPerformed
        Unidad unidad = new Unidad();
        Index.desktopPane.add(unidad);
        unidad.show();
    }//GEN-LAST:event_acUnidadesActionPerformed

    private void acCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acCategoriasActionPerformed
        Categoria categorias = new Categoria();
        Index.desktopPane.add(categorias);
        categorias.show();
    }//GEN-LAST:event_acCategoriasActionPerformed

    private void aclistEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclistEmpleadosActionPerformed
        ListadoEmpleados listado = new ListadoEmpleados();
        Index.desktopPane.add(listado);
        listado.show();
    }//GEN-LAST:event_aclistEmpleadosActionPerformed

    private void acEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acEmpleadosActionPerformed
        Empleados empleados = new Empleados();
        Index.desktopPane.add(empleados);
        empleados.show();
    }//GEN-LAST:event_acEmpleadosActionPerformed

    private void acTipEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acTipEmpleadosActionPerformed
        if (user != null && user.getIdEmpleado() == 1) {
            TipoEmpleado tipoEmpleado = new TipoEmpleado();
            Index.desktopPane.add(tipoEmpleado);
            tipoEmpleado.show();
        } else {
            JOptionPane.showMessageDialog(null, "No esta autorizado para esta accion", "Accion no realizada", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_acTipEmpleadosActionPerformed

    private void aclistPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aclistPacientesActionPerformed
        ListadoPacientes listadoPacientes = new ListadoPacientes();
        Index.desktopPane.add(listadoPacientes);
        listadoPacientes.show();
    }//GEN-LAST:event_aclistPacientesActionPerformed

    private void acPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acPacientesActionPerformed
        Pacientes paciente = new Pacientes();
        Index.desktopPane.add(paciente);
        paciente.show();
    }//GEN-LAST:event_acPacientesActionPerformed

    private void FilesResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilesResultadosActionPerformed
        Resultados resultados = new Resultados();
        Index.desktopPane.add(resultados);
        resultados.show();
        
    }//GEN-LAST:event_FilesResultadosActionPerformed

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
        for (Component bar : bars) {
            bar.setEnabled(false);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem FilesResultados;
    private javax.swing.JLabel Fondo;
    private javax.swing.JMenuItem acAnalisis;
    private javax.swing.JMenuItem acCategorias;
    private javax.swing.JMenuItem acCitas;
    private javax.swing.JMenuItem acEmpleados;
    private javax.swing.JMenuItem acExamSistema;
    private javax.swing.JMenuItem acFacturas;
    private javax.swing.JMenuItem acPacientes;
    private javax.swing.JMenuItem acTipEmpleados;
    private javax.swing.JMenuItem acUnidades;
    private javax.swing.JMenuItem aclistCitas;
    private javax.swing.JMenuItem aclistEmpleados;
    private javax.swing.JMenuItem aclistFacturas;
    private javax.swing.JMenuItem aclistPacientes;
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnExamenes;
    private javax.swing.JButton btnFacturas;
    private javax.swing.JButton btnPacientes;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileCitas;
    private javax.swing.JMenu fileEmpleados;
    private javax.swing.JMenu fileExamPacientes;
    private javax.swing.JMenu fileExamSistema;
    private javax.swing.JMenu fileFacturas;
    private javax.swing.JMenu filePacientes;
    public static javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
