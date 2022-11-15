
package GUI.SubFrame.Turnos;


import static Persistencia.ControllerCitas.getCitas;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.Cita;


public class AllTurnos extends javax.swing.JPanel {
    DefaultTableModel tablaDeTurnos = new DefaultTableModel();
    List<Cita> listarTurnos = new ArrayList<Cita>();
    
    public AllTurnos() throws SQLException, ParseException {
        initComponents();
        setModelo();
        LlenarLista();
    }
    
    private void setModelo(){
     String[] cabecera = {"N°","Id","Nombre","Apellido","Dosis","Fecha","Vacunatorio"};
     tablaDeTurnos.setColumnIdentifiers(cabecera);
     TablaTurnos.setModel(tablaDeTurnos);
    }
    
    private void LlenarLista() throws SQLException, ParseException{
        Object[] Registro = new Object[tablaDeTurnos.getColumnCount()];
        
            listarTurnos = getCitas("2022-12-16",false);

            int i = 1;
            for (Cita c : listarTurnos) {
                Registro[0] = i;
                Registro[1] = c.getId();
                Registro[2] = c.getNombre();
                Registro[3] = c.getApellido();
                Registro[4] = c.getDosis();
                Registro[5] = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(c.getFecha_cita());
                Registro[6] = c.getVacunatorio();
                
                i++;
                tablaDeTurnos.addRow(Registro);
            }
              TablaTurnos.setModel(tablaDeTurnos);                
            
            
      
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnos = new javax.swing.JTable();
        btnNewTurno = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        label1.setText("Turnos de la Fecha");

        TablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaTurnos);

        btnNewTurno.setText("Asignar Turno");
        btnNewTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewTurno))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewTurno)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTurnoActionPerformed
        newTurno nuevoturno = new newTurno();
        nuevoturno.setVisible(true);
        
     
        
    }//GEN-LAST:event_btnNewTurnoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTurnos;
    private javax.swing.JButton btnNewTurno;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
