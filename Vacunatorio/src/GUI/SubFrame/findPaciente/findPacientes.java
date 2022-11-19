/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SubFrame.findPaciente;

import GUI.SubFrame.Render;
import static Persistencia.ControllerAplicacion.AplicacionByDNI;
import static Persistencia.ControllerAplicacion.AplicacionByid;
import static Persistencia.ControllerAplicacion.AplicacionDeleteById;
import static Persistencia.ControllerCitas.CitaDeleteByPaciente;
import static Persistencia.ControllerCitas.getCitaByDNI;
import static Persistencia.ControllerPacientes.PacienteDelete;
import static Persistencia.ControllerPacientes.PacientesByDNI;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Aplicacion;
import model.Cita;
import model.Paciente;

/**
 *
 * @author Cristian
 */
public class findPacientes extends javax.swing.JPanel {
    Paciente p = null;
    Cita c = null;    
    DefaultTableModel tablaDosisModel = new DefaultTableModel(){    
        @Override
        public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }    
  };
    
   
    
    public findPacientes() {//constructor
        initComponents();
        ComponentesNovisibles();        
    }
    
    private void ComponentesNovisibles(){//Inicializo paneles como no visibles - luego se habilitan si existen los datos
        labelNoPaciente.setVisible(false);
        labelNoTurno.setVisible(false);
        panelDataPaciente.setVisible(false);
        panelDosisTurno.setVisible(false);
        panelCita.setVisible(false);        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        panelDataPaciente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelDNI = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        bntEdit = new javax.swing.JButton();
        labelNoPaciente = new javax.swing.JLabel();
        panelDosisTurno = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDosis = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        labelNoDosis = new javax.swing.JLabel();
        panelCita = new javax.swing.JPanel();
        labelVacunatorio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelDosis = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelFecha_cita = new javax.swing.JLabel();
        labelNoTurno = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDeleteTurno = new javax.swing.JButton();
        bntEditTurno = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar Pacientes");

        textDNI.setText("12456789");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DNI");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        panelDataPaciente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre :");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido :");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI :");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de nacimiento :");

        labelName.setBackground(new java.awt.Color(255, 255, 255));
        labelName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(0, 0, 0));
        labelName.setText("Nombre :");

        labelApellido.setBackground(new java.awt.Color(255, 255, 255));
        labelApellido.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelApellido.setForeground(new java.awt.Color(0, 0, 0));
        labelApellido.setText("Nombre :");

        labelDNI.setBackground(new java.awt.Color(255, 255, 255));
        labelDNI.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelDNI.setForeground(new java.awt.Color(0, 0, 0));
        labelDNI.setText("Nombre :");

        labelFecha.setBackground(new java.awt.Color(255, 255, 255));
        labelFecha.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha.setText("Nombre :");

        btnDelete.setText("Eliminar Paciente");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        bntEdit.setText("Editar datos");
        bntEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataPacienteLayout = new javax.swing.GroupLayout(panelDataPaciente);
        panelDataPaciente.setLayout(panelDataPacienteLayout);
        panelDataPacienteLayout.setHorizontalGroup(
            panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelName))
                    .addGroup(panelDataPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelApellido))
                    .addGroup(panelDataPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDNI))
                    .addGroup(panelDataPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFecha)))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(panelDataPacienteLayout.createSequentialGroup()
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(bntEdit)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDataPacienteLayout.setVerticalGroup(
            panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataPacienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelDataPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(bntEdit)))
        );

        labelNoPaciente.setForeground(new java.awt.Color(204, 0, 0));
        labelNoPaciente.setText("No se encontró Paciente con ese DNI");

        panelDosisTurno.setBackground(new java.awt.Color(255, 255, 255));

        tablaDosis.setBackground(new java.awt.Color(255, 255, 255));
        tablaDosis.setForeground(new java.awt.Color(0, 0, 0));
        tablaDosis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaDosis.setGridColor(new java.awt.Color(255, 255, 255));
        tablaDosis.setShowHorizontalLines(true);
        tablaDosis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDosisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDosis);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dosis aplicadas");

        labelNoDosis.setForeground(new java.awt.Color(204, 0, 0));
        labelNoDosis.setText("No se encontraron Dosis aplicadas al Paciente");

        javax.swing.GroupLayout panelDosisTurnoLayout = new javax.swing.GroupLayout(panelDosisTurno);
        panelDosisTurno.setLayout(panelDosisTurnoLayout);
        panelDosisTurnoLayout.setHorizontalGroup(
            panelDosisTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDosisTurnoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(panelDosisTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNoDosis)
                    .addComponent(jLabel8))
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDosisTurnoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDosisTurnoLayout.setVerticalGroup(
            panelDosisTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDosisTurnoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNoDosis)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelCita.setBackground(new java.awt.Color(255, 255, 255));

        labelVacunatorio.setForeground(new java.awt.Color(0, 0, 0));
        labelVacunatorio.setText("El día:");

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Presentarse en :");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Proxima Aplicacíon :");

        labelDosis.setForeground(new java.awt.Color(0, 0, 0));
        labelDosis.setText("El día:");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("El día:");

        labelFecha_cita.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha_cita.setText("El día:");

        labelNoTurno.setForeground(new java.awt.Color(204, 0, 0));
        labelNoTurno.setText("No tiene un turno asignado");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Proximo Turno");

        btnDeleteTurno.setText("Eliminar Turno");
        btnDeleteTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTurnoActionPerformed(evt);
            }
        });

        bntEditTurno.setText("Editar Turno");
        bntEditTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCitaLayout = new javax.swing.GroupLayout(panelCita);
        panelCita.setLayout(panelCitaLayout);
        panelCitaLayout.setHorizontalGroup(
            panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCitaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCitaLayout.createSequentialGroup()
                        .addComponent(btnDeleteTurno)
                        .addGap(18, 18, 18)
                        .addComponent(bntEditTurno))
                    .addComponent(labelNoTurno)
                    .addComponent(jLabel9)
                    .addGroup(panelCitaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDosis))
                    .addGroup(panelCitaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVacunatorio))
                    .addGroup(panelCitaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFecha_cita)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelCitaLayout.setVerticalGroup(
            panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCitaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNoTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelFecha_cita))
                .addGap(4, 4, 4)
                .addGroup(panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelDosis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelVacunatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panelCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteTurno)
                    .addComponent(bntEditTurno))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNoPaciente)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelDataPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(panelDosisTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(791, 791, 791))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(panelCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDosisTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNoPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDataPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addComponent(panelCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPaciente();        
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    private void buscarPaciente(){ // busca Paciente por número de DNI
    String DNI = textDNI.getText();        
        try {
            p = PacientesByDNI(DNI);//obtengo paciente
        } catch (SQLException ex) {
            Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }        
        if (p.getNombre() != null) {//verifico si tengo datos del paciente
           llenarPanelPaciente(p);//lleno el panel de datos del paciente
           findDosis(p);//busco las dosis que tiene ese paciente
            try {
                findCitas(p);// buesco el turno que tiene ese paciente
            } catch (SQLException ex) {
                Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            labelNoPaciente.setVisible(true);
            panelDataPaciente.setVisible(false);            
        }
    }
    
     //muestra los datos de la tabla paciente
    private void llenarPanelPaciente(Paciente p){
            labelNoPaciente.setVisible(false);
            panelDataPaciente.setVisible(true);
            labelName.setText(p.getNombre());
            labelApellido.setText(p.getApellido());
            labelDNI.setText(p.getDni());            
            labelFecha.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(p.getFecha_nacimiento()));
    }    
   
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          
            int input = JOptionPane.showConfirmDialog(null, 
                    "¿Estas seguro de eliminar al Paciente "+this.p.getNombre()+" "+this.p.getApellido()+"?"
                    , "Eliminar paciente",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
	       if (input == 0) {// 0=yes, 1=no, 2=cancel
            PacienteDelete(this.p.getDni());
        }
	
	System.out.println(input);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void bntEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditActionPerformed
      editPaciente modPaciente = new editPaciente(this.p);
      modPaciente.setVisible(true);
    }//GEN-LAST:event_bntEditActionPerformed
    
    //función para detectar boton eliminar o modificar de tablaDosis
    //cuando detecta llama a la funcion correspondiente
    private void tablaDosisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDosisMouseClicked
        int column = tablaDosis.getColumnModel().getColumnIndexAtX(evt.getX());// me dice en que columna hago click 
        int row = evt.getY()/tablaDosis.getRowHeight();// me dice en que fila hago click 
        if(row < tablaDosis.getRowCount() && row >= 0 && column < tablaDosis.getColumnCount() && column >= 0){ // me aseguro que los valores de filas y columnas tengan un valor logico
            Object value = tablaDosis.getValueAt(row, column); // traigo el objeto según fila y columna
            if(value instanceof JButton){ // me aseguro que el click sea en un botón 
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){ //si el botón es igual a modificar
                    int idDosis = Integer.parseInt(tablaDosis.getValueAt(row, column-5).toString());// traigo el valor de la celda id de la fila 
                    
                    try {
                        Aplicacion a = AplicacionByid(idDosis);//busca la dosis por id
                        editarDosis(a); // llama a la ventana editar
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(findPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println(tablaDosis.getValueAt(row, column-5).toString());
                    //EVENTOS MODIFICAR
                }
                if(boton.getName().equals("e")){ // si el botón es igual a eliminar
                    //JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println("Click en el boton eliminar");
                    //EVENTOS ELIMINAR
                    int idDosis = Integer.parseInt(tablaDosis.getValueAt(row, column-6).toString());// traigo el valor de la celda id de la fila 
                    eliminarDosis(idDosis);
                }
            }
        }
       
    }//GEN-LAST:event_tablaDosisMouseClicked

    private void btnDeleteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTurnoActionPerformed
        eliminarTurno(this.c.getId());
    }//GEN-LAST:event_btnDeleteTurnoActionPerformed

    private void bntEditTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditTurnoActionPerformed
        editarTurno(this.c);
    }//GEN-LAST:event_bntEditTurnoActionPerformed
    
   
    //-----------------Dosis o Aplicaciones------------------------------------------
    
    private void findDosis(Paciente p){//Busca las dosis del paciente y llama a las funcion que llena la tabla con las dosis
        List<Aplicacion> ListA = new ArrayList<Aplicacion>();
        
        try {
            ListA = AplicacionByDNI(p.getDni());
        } catch (Exception e) {
        }
        if (ListA.size() > 0) {
            //llenarListaDosis(ListA);
            ver_tabla(tablaDosis,ListA);
            panelDosisTurno.setVisible(true);
            labelNoDosis.setVisible(false);                    
        }
        else{ // si no hay dosis se muestra el label
            labelNoDosis.setVisible(true);
        }
        
    }    
  
    private void setModelo(){//Crea el modelo de la tabla Dosis
     String[] cabecera = {"N°","Id","Fecha de aplicación","Lote Vacuna","Marca Vacuna","N° Dosis"," "," "};
     tablaDosisModel.setColumnIdentifiers(cabecera);

     tablaDosis.setModel(tablaDosisModel);
    } 
      
    public void ver_tabla(JTable tabla,List<Aplicacion> ListA){//Llena la tabla con las dosis del paciente
        LimpiarTabla();//limpio antes de llenarla, de otro modo acumula si hago dos busquedas 
        tabla.setDefaultRenderer(Object.class, new Render());
        
        JButton btn1 = new JButton("Modificar");
        btn1.setName("m");
        JButton btn2 = new JButton("Eliminar");
        btn2.setName("e");
        //btn2.setIcon(defaultIcon);
         setModelo();
         Object[] Registro = new Object[tablaDosisModel.getColumnCount()];
         int i = 0;
         for (Aplicacion a : ListA) {
             Registro[0] = i;
             Registro[1] = a.getId();
             Registro[2] = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(a.getFecha_ult_dosis());
             Registro[3] = a.getLote_vacuna();
             Registro[4] = a.getMarca_vacuna();
             Registro[5] = a.getNumeroDosis();
             Registro[6] = btn1;
             Registro[7] = btn2;
             i++;
             tablaDosisModel.addRow(Registro);
        }


        tabla.setModel(tablaDosisModel);        
        tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
  

    }
    
    public void LimpiarTabla(){
        DefaultTableModel tb = (DefaultTableModel) tablaDosis.getModel();
        int a = tablaDosis.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        //cargaTicket();
    }
    
    private void llenarPanelDosis(Cita c){
        labelNoTurno.setVisible(false);
        panelCita.setVisible(true);
        labelFecha_cita.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(c.getFecha_cita())); 
        labelDosis.setText(c.getDosis() + " dosis");
        labelVacunatorio.setText(c.getVacunatorio()); 
        panelCita.setVisible(true);
        
    }   

    private void editarDosis(Aplicacion a){ // llama a la ventana editar dosis

      editDosis modDosis = new editDosis(a);
      modDosis.setVisible(true);
              
    }
    
    private void eliminarDosis(int idDosis){
        int input = JOptionPane.showConfirmDialog(null, 
                    "¿Estas seguro de eliminar la Dosis del paciente " + this.p.getNombre()+" "+this.p.getApellido()+"?"
                    , "Eliminar Dosis",
	JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
	if (input == 0) { // 0=yes, 1=no, 2=cancel
            AplicacionDeleteById(idDosis);
        }	
    }
    
    //----------------------------------Citas o Turnos------------------------------------------
    private void findCitas(Paciente p) throws SQLException, ParseException{//Busco Turnos del paciente por DNI
        
        try {
            this.c = getCitaByDNI(p.getDni());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if (this.c.getFecha_cita() !=  null && !c.isEstado() ) {
            //System.out.println(c.isEstado());
                    
            llenarPanelDosis(this.c);
        }else{
            labelNoTurno.setVisible(true);
            System.out.println("no cita");
            panelCita.setVisible(false);
        }
               
    }
    
    private void editarTurno(Cita c){
        editTurno modCita = new editTurno(c);
        modCita.setVisible(true);
    }
    
    private void eliminarTurno(int idTurno){
        int input = JOptionPane.showConfirmDialog(null, 
                    "¿Estas seguro de eliminar el Turno del paciente " + this.p.getNombre()+" "+this.p.getApellido()+"?"
                    , "Eliminar Turno",
	JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
	if (input == 0) { // 0=yes, 1=no, 2=cancel
            CitaDeleteByPaciente(idTurno);
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEdit;
    private javax.swing.JButton bntEditTurno;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelDosis;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelFecha_cita;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNoDosis;
    private javax.swing.JLabel labelNoPaciente;
    private javax.swing.JLabel labelNoTurno;
    private javax.swing.JLabel labelVacunatorio;
    private javax.swing.JPanel panelCita;
    private javax.swing.JPanel panelDataPaciente;
    private javax.swing.JPanel panelDosisTurno;
    private javax.swing.JTable tablaDosis;
    private javax.swing.JTextField textDNI;
    // End of variables declaration//GEN-END:variables
}
