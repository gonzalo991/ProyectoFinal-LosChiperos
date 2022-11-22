
package GUI.SubFrame;

import static Persistencia.ControllerPacientes.AllPacientes;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.Paciente;
import model.User;

public class AllPacientes extends javax.swing.JPanel {
    DefaultTableModel tablaDePacientes = new DefaultTableModel();
    List<Paciente> listarPacientes = new ArrayList<Paciente>();
    User usuario;
    public AllPacientes(User usuario) throws SQLException, ParseException {
        initComponents();
        this.usuario = usuario;
        setModelo();
        LlenarLista();
        administradorEnable();
    }
    
    private void setModelo(){
     String[] cabecera = {"N°","Id","Nombre","Vacunatorio","DNI","Fecha de nacimiento"};
     tablaDePacientes.setColumnIdentifiers(cabecera);
     TablaPacientes.setModel(tablaDePacientes);
    }
    
    private void LlenarLista() throws SQLException, ParseException{
        Object[] Registro = new Object[tablaDePacientes.getColumnCount()];

            listarPacientes = AllPacientes();
            int i = 1;
            for (Paciente p : listarPacientes) {
                Registro[0] = i;
                Registro[1] = p.getId();
                Registro[2] = p.getNombre();
                Registro[3] = p.getApellido();
                Registro[4] = p.getDni();
                Registro[5] = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(p.getFecha_nacimiento());
                
                i++;
                tablaDePacientes.addRow(Registro);
            }
              TablaPacientes.setModel(tablaDePacientes);                   
            
    }
    
    private void administradorEnable(){
    
        if (usuario.getPermisos().equals("administrador")){
            btnNewPaciente.setEnabled(true);
        }else {
            btnNewPaciente.setEnabled(false);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPacientes = new javax.swing.JTable();
        btnNewPaciente = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 600));

        label1.setText("Todos los pacientes");

        TablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaPacientes);

        btnNewPaciente.setText("Registrar Paciente");
        btnNewPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPacienteActionPerformed(evt);
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
                    .addComponent(btnNewPaciente))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
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
                        .addComponent(btnNewPaciente)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPacienteActionPerformed
        
        NewPaciente Nuevo = new NewPaciente();
        Nuevo.setLocationRelativeTo(null);
        Nuevo.setVisible(true);
        
    }//GEN-LAST:event_btnNewPacienteActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPacientes;
    private javax.swing.JButton btnNewPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
