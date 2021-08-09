
package views.Citas;

import Models.Citas.ModelCitas;
import Models.Citas.ModelDetalleCita;
import Models.Examenes.ModelExamenes;
import Models.Pacientes.ModelPacientes;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static views.Citas.Citas.idempleado;
import static views.Citas.Citas.idpaciente;
import views.Empleados.Empleados;


public class DetallesCita extends javax.swing.JInternalFrame {
    
    ModelExamenes examenes = new ModelExamenes(); 
    ModelDetalleCita detalle = new ModelDetalleCita();
    DefaultTableModel tablaTodo = new DefaultTableModel();
    public static int idexamen=0;
    public static int [] arrayIDexamenes;
    public static int idcita; 
    
    // pruebas 
   public static DefaultTableModel modelo;
   public static DefaultTableModel modelo2; 
   public static int  idexamenEliminar;
   

  
    public DetallesCita() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        this.setLocation((pantalla.width - ventana.width) / 2, ((pantalla.height - ventana.height) / 2) - 50);
        this.tablaExamenes.setModel(this.examenes.readUnsets());
        idcita = Citas.idcita; 
      //  this.tablaSeleccionado.setModel(this.detalle.mostrarInterfaz(Citas.idcita));
        
       
        // prueba de JTABLE  
       // MODELO 1 
       /*
       modelo = new DefaultTableModel(); 
       tablaExamenes.setModel(modelo); */
       
       // MODELO 2 
       modelo2 = new DefaultTableModel(); 
       modelo2.addColumn("ID Examen");
       modelo2.addColumn("Nombre");
       modelo2.addColumn("Precio");
       modelo2.addColumn("Categoria");
       tablaSeleccionado.setModel(modelo2);
       this.tablaSeleccionado.setModel(this.detalle.mostrarInterfaz(idcita));
      // this.tablaSeleccionado.setModel(this.detalle.mostrarInterfaz(idcita));
         
    }

    public void eliminar(int fila){
    
     //   fireTableRovsDeleted(fila, fila);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaExamenes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtsearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        btnseleccionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaSeleccionado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1000, 670));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Detalles de cita");

        tablaExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaExamenes);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Buscar:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Opciones"));

        btneliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnseleccionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnseleccionar.setText("Añadir");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablaSeleccionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaSeleccionado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSeleccionadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaSeleccionado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        // TODO add your handling code here:
        int FilaSeleccionada = tablaExamenes.getSelectedRow(); 
        String[] registros = new String[4];   
        int idexa =0; 
        
        if(FilaSeleccionada>=0){
            
               idexa = Integer.parseInt(this.tablaExamenes.getValueAt(FilaSeleccionada, 0).toString()); 
            
                registros[0] = this.tablaExamenes.getValueAt(FilaSeleccionada, 0).toString();
                registros[1] = this.tablaExamenes.getValueAt(FilaSeleccionada, 1).toString();
                registros[2] = this.tablaExamenes.getValueAt(FilaSeleccionada, 2).toString();
                registros[3] = this.tablaExamenes.getValueAt(FilaSeleccionada, 3).toString(); 
                
               // modelo2.addRow(registros);     
        }
        
        
        arrayIDexamenes = new int[tablaSeleccionado.getRowCount()]; 
        String estado = "por realizar";
       
  
        /*
        if (arrayIDexamenes.length > 0) { // mientras exista 1 examen seleccionado           
        for (int i = 0; i < tablaSeleccionado.getRowCount(); i++) {       
			System.out.println("Prueba de tabla seleccionado: "+tablaSeleccionado.getValueAt(i, 0));
                        arrayIDexamenes [i] = Integer.parseInt((String) tablaSeleccionado.getValueAt(i, 0));
				//System.out.println();
			}     */   
        // verificar que el arreglo este guardando bien 
        /* 
        for(int x =0; x < arrayIDexamenes.length ; x++ ){
            System.out.println("Muestra de arreglo completo= "+arrayIDexamenes[x]);
        } */    
        
        
        System.out.println("ID CITA : "+idcita);             
        System.out.println("ID examen: "+idexa);
             // ejecuta esta consulta hasta que se termine de recorrer todo el array de id
                                                  // de los examenes seleccionados 
                
          int decision = JOptionPane.showConfirmDialog(null, "¿Desea Registrar el examen seleccionado?");                            
           if(idexa !=0){ 
            this.detalle.create(estado,idexa,idcita);
            modelo2.addRow(registros);
            tablaSeleccionado.setModel(detalle.mostrarInterfaz(idcita));
           // tablaSeleccionado.setModel(modelo2);
           } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un examen", "Accion no realizada", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        this.tablaExamenes.setModel(this.examenes.searchUnset(this.txtsearch.getText()));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void tablaSeleccionadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSeleccionadoMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = this.tablaSeleccionado.rowAtPoint(evt.getPoint());       
        try {         
           idexamenEliminar = Integer.parseInt(this.tablaSeleccionado.getValueAt(filaSeleccionada, 0).toString()); // para el manejo interno del id  
        } catch (Exception ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tablaSeleccionadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int decision = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas eliminar?");
        if(decision == 0){       
            
            this.detalle.delete(idcita,idexamenEliminar);  
            tablaSeleccionado.setModel(detalle.mostrarInterfaz(idcita));
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaExamenes;
    private javax.swing.JTable tablaSeleccionado;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
