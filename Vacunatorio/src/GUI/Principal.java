/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.SubFrame.AllPacientes;
import GUI.SubFrame.Turnos.AllTurnos;
import GUI.SubFrame.findPaciente.findPacientes;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.User;




public class Principal extends javax.swing.JFrame {
    

    /**
     * Creates new form Principal
     */
    User Usuario;
    public Principal(User Usuario) {
        initComponents();
        this.Usuario = Usuario;
        PanelContenedor.setLocation(0, 0);       
        labelVacunatorio.setText(Usuario.getVacunatorio());
        MenuUser.setText(Usuario.getUser());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelContenedor = new javax.swing.JPanel();
        PanelDataUser = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        labelVacunatorio = new java.awt.Label();
        menu = new javax.swing.JMenuBar();
        MenuUser = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        btnPacientes = new javax.swing.JMenu();
        viewPacientes = new javax.swing.JMenuItem();
        findPaciente = new javax.swing.JMenuItem();
        Turnos = new javax.swing.JMenu();
        citaByDate = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Aplicaciones = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        PanelContenedor.setPreferredSize(new java.awt.Dimension(1200, 600));

        javax.swing.GroupLayout PanelContenedorLayout = new javax.swing.GroupLayout(PanelContenedor);
        PanelContenedor.setLayout(PanelContenedorLayout);
        PanelContenedorLayout.setHorizontalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        PanelContenedorLayout.setVerticalGroup(
            PanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        PanelDataUser.setBackground(new java.awt.Color(255, 255, 255));

        label2.setText("Centro de Trabajo:");

        labelVacunatorio.setText("Vacunatorio");

        javax.swing.GroupLayout PanelDataUserLayout = new javax.swing.GroupLayout(PanelDataUser);
        PanelDataUser.setLayout(PanelDataUserLayout);
        PanelDataUserLayout.setHorizontalGroup(
            PanelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDataUserLayout.createSequentialGroup()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(labelVacunatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1718, Short.MAX_VALUE))
        );
        PanelDataUserLayout.setVerticalGroup(
            PanelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDataUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDataUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVacunatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(752, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelDataUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(PanelDataUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(null);
        menu.setForeground(new java.awt.Color(0, 0, 0));

        MenuUser.setText("jMenu1");

        jMenuItem3.setText("Cerrar Sesión");
        MenuUser.add(jMenuItem3);

        menu.add(MenuUser);

        btnPacientes.setText("Pacientes");

        viewPacientes.setText("Ver Pacientes");
        viewPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPacientesMouseClicked(evt);
            }
        });
        viewPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPacientesActionPerformed(evt);
            }
        });
        btnPacientes.add(viewPacientes);

        findPaciente.setText("Buscar Paciente");
        findPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPacienteActionPerformed(evt);
            }
        });
        btnPacientes.add(findPaciente);

        menu.add(btnPacientes);

        Turnos.setText("Turnos");

        citaByDate.setText("Turnos del día");
        citaByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citaByDateActionPerformed(evt);
            }
        });
        Turnos.add(citaByDate);

        jMenuItem2.setText("Turno del Paciente");
        Turnos.add(jMenuItem2);

        menu.add(Turnos);

        Aplicaciones.setText("Aplicaciones");

        jMenuItem1.setText("Registar Aplicacion");
        Aplicaciones.add(jMenuItem1);

        menu.add(Aplicaciones);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPacientesMouseClicked
        
    }//GEN-LAST:event_viewPacientesMouseClicked

    private void viewPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPacientesActionPerformed
        System.out.println("AllPacientes");
        AllPacientes p = null;
        try {
            p = new AllPacientes();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowPanel(p);
    }//GEN-LAST:event_viewPacientesActionPerformed

    private void findPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPacienteActionPerformed
        
         findPacientes f = null;
         f = new findPacientes();
        
        ShowPanel(f);
    }//GEN-LAST:event_findPacienteActionPerformed

    private void citaByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citaByDateActionPerformed
        AllTurnos t = null;
        try {
            t = new AllTurnos();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowPanel(t);
          
    }//GEN-LAST:event_citaByDateActionPerformed
    
    private void ShowPanel(JPanel p){
        p.setSize(1200,600);
        p.setLocation(0,0);
        
        PanelContenedor.removeAll();
        PanelContenedor.add(p,BorderLayout.CENTER);
        PanelContenedor.revalidate();
        PanelContenedor.repaint();
                
        
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aplicaciones;
    private javax.swing.JMenu MenuUser;
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JPanel PanelDataUser;
    private javax.swing.JMenu Turnos;
    private javax.swing.JMenu btnPacientes;
    private javax.swing.JMenuItem citaByDate;
    private javax.swing.JMenuItem findPaciente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label2;
    private java.awt.Label labelVacunatorio;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem viewPacientes;
    // End of variables declaration//GEN-END:variables
}
