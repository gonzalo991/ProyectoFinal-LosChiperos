
package GUI.SubFrame.Turnos;


import GUI.SubFrame.Render;
import static Persistencia.ControllerCentro.AllCentros;
import static Persistencia.ControllerCitas.CitaUpdate;
import static Persistencia.ControllerCitas.getCitaById;
import static Persistencia.ControllerCitas.getCitas;
import com.toedter.calendar.JDateChooser;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Centro;
import model.Cita;


public class AllTurnos extends javax.swing.JPanel {
    DefaultTableModel tablaDeTurnos = new DefaultTableModel();
    List<Cita> listarTurnos = new ArrayList<Cita>();
    
    public AllTurnos() throws SQLException, ParseException {
        initComponents();
        setModelo();
        listarTurnos = getCitas("2022-12-16",true);
        LlenarLista(listarTurnos);
       
        inicializarDatePicker(DateTurno);
        initComboBox();
    }
    private void inicializarDatePicker(JDateChooser datepicker){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        int subtractYearValue = 0;

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDate= Calendar.getInstance().get(Calendar.DATE);

        calendar.set(currentYear - subtractYearValue , currentMonth , currentDate);
        date.setTime(calendar.getTimeInMillis());
         datepicker.setDate(date);
        datepicker.setCalendar(calendar);
        
       
     
        
    }
    private void initComboBox(){
        List<Centro> centros = AllCentros();   
        ComboCentros.removeAllItems();
        ComboCentros.addItem("Todos");
        for (Centro c : centros) {
            ComboCentros.addItem(c.getVacunatorio());
        }
    }
    private void setModelo(){
     String[] cabecera = {"Id","Id_Paciente","Nombre","Apellido","Dosis","Fecha","Vacunatorio", "Estado",""};
     tablaDeTurnos.setColumnIdentifiers(cabecera);
     TablaTurnos.setModel(tablaDeTurnos);
    }
    
    private void LlenarLista( List<Cita> listaTurnos) throws SQLException, ParseException{
        Object[] Registro = new Object[tablaDeTurnos.getColumnCount()];
        LimpiarTabla();
        TablaTurnos.setDefaultRenderer(Object.class, new Render());
            //listarTurnos = getCitas("2022-12-16",true);
           JButton btn1 = new JButton("Cumplir");
            btn1.setName("cumplir");
            
            for (Cita c : listarTurnos) {
                Registro[0] = c.getId();
                Registro[1] = c.getId_paciente();
                Registro[2] = c.getNombre();
                Registro[3] = c.getApellido();
                Registro[4] = c.getDosis();
                Registro[5] = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(c.getFecha_cita());
                Registro[6] = c.getVacunatorio();
                Registro[7] = c.isEstado() ? "Cumplido" : "Pendiente";
                Registro[8] = c.isEstado() ? "" : btn1;
                
                
               
                tablaDeTurnos.addRow(Registro);
            }
              TablaTurnos.setModel(tablaDeTurnos);
              TablaTurnos.setPreferredScrollableViewportSize(TablaTurnos.getPreferredSize());
        TablaTurnos.setRowHeight(30);
        TablaTurnos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

    }
    public void LimpiarTabla(){
        DefaultTableModel tb = (DefaultTableModel) TablaTurnos.getModel();
        int a = TablaTurnos.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupEstado = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnos = new javax.swing.JTable();
        btnNewTurno = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DateTurno = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RadioPend = new javax.swing.JRadioButton();
        RadioCumpl = new javax.swing.JRadioButton();
        RadioTodos = new javax.swing.JRadioButton();
        ComboCentros = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

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
        TablaTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTurnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTurnos);

        btnNewTurno.setText("Asignar Turno");
        btnNewTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTurnoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fecha del Turno");

        DateTurno.setDateFormatString("yyyy-MM-dd");
        DateTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DateTurnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DateTurnoKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Estado");

        RadioPend.setBackground(new java.awt.Color(255, 255, 255));
        GroupEstado.add(RadioPend);
        RadioPend.setForeground(new java.awt.Color(0, 0, 0));
        RadioPend.setSelected(true);
        RadioPend.setText("Pendiente");
        RadioPend.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RadioPend.setInheritsPopupMenu(true);

        RadioCumpl.setBackground(new java.awt.Color(255, 255, 255));
        GroupEstado.add(RadioCumpl);
        RadioCumpl.setForeground(new java.awt.Color(0, 0, 0));
        RadioCumpl.setText("Cumplidos");
        RadioCumpl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RadioCumpl.setInheritsPopupMenu(true);

        RadioTodos.setBackground(new java.awt.Color(255, 255, 255));
        GroupEstado.add(RadioTodos);
        RadioTodos.setForeground(new java.awt.Color(0, 0, 0));
        RadioTodos.setText("Todos");
        RadioTodos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RadioTodos.setInheritsPopupMenu(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RadioPend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RadioCumpl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioTodos)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioPend)
                    .addComponent(RadioCumpl)
                    .addComponent(RadioTodos))
                .addContainerGap())
        );

        ComboCentros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Vacunatorio");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboCentros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar))
                            .addComponent(DateTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewTurno))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnNewTurno))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTurnoActionPerformed
        newTurno nuevoturno = new newTurno();
        nuevoturno.setVisible(true);
    }//GEN-LAST:event_btnNewTurnoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        boolean estado = RadioCumpl.isSelected();
        int id_v = ComboCentros.getSelectedIndex();
        String fecha = new SimpleDateFormat("YYYY-MM-dd").format(DateTurno.getDate());
        
        listarTurnos.clear();
        if(!RadioTodos.isSelected() && id_v > 0 ){ //No todos los estados - No todos los vacunatorios
            
            try {
                
                listarTurnos = getCitas(fecha, estado, id_v);
                LlenarLista(listarTurnos);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (RadioTodos.isSelected() && id_v > 0) { //Todos los estados - No todos los centros vacunatorios
            
            try {
                listarTurnos = getCitas(fecha, id_v);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                LlenarLista(listarTurnos);
            } catch (SQLException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (RadioTodos.isSelected() && id_v == 0){ try {
            // todos los estados - todos los centros vacunatorios
            listarTurnos = getCitas(fecha);
            LlenarLista(listarTurnos);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else if (!RadioTodos.isSelected() && id_v == 0){
            try {
                listarTurnos = getCitas(fecha, estado);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                LlenarLista(listarTurnos);
            } catch (SQLException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void DateTurnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DateTurnoKeyTyped
       
    }//GEN-LAST:event_DateTurnoKeyTyped

    private void DateTurnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DateTurnoKeyPressed
      
    }//GEN-LAST:event_DateTurnoKeyPressed

    private void TablaTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTurnosMouseClicked
             int column = TablaTurnos.getColumnModel().getColumnIndexAtX(evt.getX());// me dice en que columna hago click 
        int row = evt.getY()/TablaTurnos.getRowHeight();// me dice en que fila hago click 
        if(row < TablaTurnos.getRowCount() && row >= 0 && column < TablaTurnos.getColumnCount() && column >= 0){ // me aseguro que los valores de filas y columnas tengan un valor logico
            Object value = TablaTurnos.getValueAt(row, column); // traigo el objeto según fila y columna
            if(value instanceof JButton){ // me aseguro que el click sea en un botón 
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("cumplir")){ //si el botón es igual a cumplido
                    int idDosis = Integer.parseInt(TablaTurnos.getValueAt(row, column-8).toString());// traigo el valor de la celda id de la fila 
                   
                    try {
                     Cita  c = getCitaById(idDosis);
                         InsertDosis newDosis = new InsertDosis(c);
                         CitaUpdate(idDosis);
                         newDosis.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(AllTurnos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //"Id","Id_Paciente","Nombre","Apellido","Dosis","Fecha","Vacunatorio", "Estado",
                    // Cuando se cumple el turno se genaran dos acciones - 
                        //1_Se cambia el estado al turno
                        //1_Se inserta la aplicacion de dosis
                     
                     
                      
                }

            }
        }
    }//GEN-LAST:event_TablaTurnosMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCentros;
    private com.toedter.calendar.JDateChooser DateTurno;
    private javax.swing.ButtonGroup GroupEstado;
    private javax.swing.JRadioButton RadioCumpl;
    private javax.swing.JRadioButton RadioPend;
    private javax.swing.JRadioButton RadioTodos;
    private javax.swing.JTable TablaTurnos;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNewTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
