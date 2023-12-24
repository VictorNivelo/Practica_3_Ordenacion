/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Dao.Modelo.personaDao;
import Controlador.TDA.ListaDinamica.ListaDinamica;
import Controlador.Tda.listas.Exepciones.ListaVacia;
import Controlador.Utiles.UtilesControlador;
import Modelo.Persona;
import Vista.ModeloTabla.ModeloTablaPersona;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class VistaPrincipal extends javax.swing.JFrame {
    personaDao personaControlDao = new personaDao();
    ListaDinamica<Persona> listaPersonas = new ListaDinamica<>();
    ModeloTablaPersona mtp = new ModeloTablaPersona();
    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarTabla();
    }
    
    private void CargarTabla() {
        mtp.setPersonasTabla(personaControlDao.getListaPersonas());
        cbxGenero.setSelectedIndex(-1);
        cbxEstadoCivil.setSelectedIndex(-1);
        cbxCensador.setSelectedIndex(-1);
        cbxCampoOrden.setSelectedIndex(-1);
        cbxOrden.setSelectedIndex(-1);
        cbxMetodo.setSelectedIndex(-1);
        tblPersonas.setModel(mtp);
        tblPersonas.updateUI();
    }
    
    private void Limpiar() throws ListaVacia {
        txtNombre.setText("");
        txtApellido.setText("");
        cbxGenero.setSelectedIndex(-1);
        cbxEstadoCivil.setSelectedIndex(-1);
        txtMotivo.setText("");
        txtFecha.setText("");
        txtEstadoEmocional.setText("");
        cbxCensador.setSelectedIndex(-1);
        cbxCampoOrden.setSelectedIndex(-1);
        cbxOrden.setSelectedIndex(-1);
        cbxMetodo.setSelectedIndex(-1);
        personaControlDao.setPersona(null);
        CargarTabla();
    }
    
    private void Seleccionar(){
        int fila = tblPersonas.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        }
        else{
            try {
                personaControlDao.setPersona(mtp.getPersonasTabla().getInfo(fila));
                
                txtNombre.setText(personaControlDao.getPersona().getNombre());
                txtApellido.setText(personaControlDao.getPersona().getApellido());
                cbxGenero.setSelectedItem(personaControlDao.getPersona().getGenero());
                cbxEstadoCivil.setSelectedItem(personaControlDao.getPersona().getEstadoCivil());
                txtMotivo.setText(personaControlDao.getPersona().getMotivo());
                txtFecha.setText(personaControlDao.getPersona().getFecha());
                txtEstadoEmocional.setText(personaControlDao.getPersona().getEstadoEmocional());
                cbxCensador.setSelectedItem(personaControlDao.getPersona().getCensador());
            } 
            catch (Exception e) {
                
            }
        }
    }
    
    private void Guardar() throws ListaVacia {

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar apellido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtEstadoEmocional.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar estado emocional", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar fecha", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (txtMotivo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta llenar motivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Integer IdPersona = listaPersonas.getLongitud() + 1;
            String Nombre = txtNombre.getText();
            String Apellido = txtApellido.getText();
            String Genero = cbxGenero.getSelectedItem().toString();
            String EstadoCivil = cbxEstadoCivil.getSelectedItem().toString();
            String Motivo = txtMotivo.getText();
            String Fecha = txtFecha.getText();
            String EstadoEmocional = txtEstadoEmocional.getText();
            String Censador = cbxCensador.getSelectedItem().toString();
                        
            personaControlDao.getPersona().setIdPersona(IdPersona);
            personaControlDao.getPersona().setNombre(Nombre);
            personaControlDao.getPersona().setApellido(Apellido);
            personaControlDao.getPersona().setGenero(Genero);
            personaControlDao.getPersona().setEstadoCivil(EstadoCivil);
            personaControlDao.getPersona().setMotivo(Motivo);
            personaControlDao.getPersona().setFecha(Fecha);
            personaControlDao.getPersona().setEstadoEmocional(EstadoEmocional);
            personaControlDao.getPersona().setCensador(Censador);
                                    
            if (personaControlDao.Persist()) {
                JOptionPane.showMessageDialog(null, "CENSO GUARDADA EXISTOSAMENTE", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                personaControlDao.setPersona(null);
            } 
            else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            Limpiar();
        } 
    }
    
    public  Integer OrdenSeleccionado(){
        String OrdenO = cbxOrden.getSelectedItem().toString();
        
        if ("Asendente".equals(OrdenO)) {
            return 0;
        }
        if("Desendente".equals(OrdenO)){
            return 1;
        }
        return null;
    }
    
    public  Integer OrdenSeleccionadoq(){
        String OrdenO = cbxOrden.getSelectedItem().toString();
        
        if ("Asendente".equals(OrdenO)) {
            return 1;
        }
        if("Desendente".equals(OrdenO)){
            return 0;
        }
        return null;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEstadoEmocional = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbxCampoOrden = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbxOrden = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbxMetodo = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxCensador = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR PERSONAS");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Genero");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino", "No definido" }));

        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado civil");

        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Divorsiado", "Union libre", "Viudo", "Separado" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DATOS DEL CENSO");

        jLabel7.setText("Fecha");

        jLabel8.setText("Estado emocional");

        jLabel9.setText("LISTA DE PERSONAS CENSADAS");

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPersonas);

        jButton2.setText("SELECCIONAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel10.setText("Ordenar");

        cbxCampoOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Genero", "Estado civil" }));

        jLabel11.setText("Orden");

        cbxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asendente", "Desendente" }));

        jLabel12.setText("Metodo");

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ShellSort", "Quicksort" }));

        jButton5.setText("ORDENAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setText("Motivo");

        jLabel14.setText("Censador");

        cbxCensador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Victor Nivelo", "Jose Carrion", "Mateo Martinez" }));

        jButton4.setText("TOTAL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstadoEmocional))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFecha)
                            .addComponent(txtMotivo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCensador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxCampoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbxCampoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEstadoEmocional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbxCensador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Guardar();
        } 
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Seleccionar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = tblPersonas.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            //Datos de persona a registrar
            Integer IdPersona = personaControlDao.getListaPersonas().getLongitud() + 1;
            
            String Nombre = txtNombre.getText();
            String Apellido = txtApellido.getText();
            String Genero = cbxGenero.getSelectedItem().toString();
            String EstadoCivil = cbxEstadoCivil.getSelectedItem().toString();
            String Motivo = txtMotivo.getText();
            String Fecha = txtFecha.getText();
            String EstadoEmocional = txtEstadoEmocional.getText();
            String Censador = cbxCensador.getSelectedItem().toString();
            
            Persona personaModiPersona = new Persona(IdPersona, Nombre, Apellido, Genero, EstadoCivil, Motivo, Fecha, EstadoEmocional, Censador);
            
            personaControlDao.Merge(personaModiPersona, fila);
            
            CargarTabla();
            
            try {
                Limpiar();
            } 
            catch (ListaVacia ex) {
                
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblPersonas.getSelectedRow()-1;
        if (fila < -1) {
            JOptionPane.showMessageDialog(null, "Escoga un registro");
        } 
        else {
            personaControlDao.Eliminar(fila);
            CargarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            String Campo = cbxCampoOrden.getSelectedItem().toString();
            String Metodo = cbxMetodo.getSelectedItem().toString();

            switch (Metodo) {
                case "ShellSort":
                    long tiempoInicio = System.currentTimeMillis();
                    
                    UtilesControlador.ShellSort(personaControlDao.all(), OrdenSeleccionado(), Campo);
                    
                    System.out.println("LISTA ORDENADA MEDIANTE ShellSort");
                    System.out.println("CAMPO DE ORDENAMIENTO: " + Campo + " METODO DE ORDENAMIENTO: " + Metodo);
                    System.out.println(UtilesControlador.ShellSort(personaControlDao.all(), OrdenSeleccionado(), Campo));
                    
                    long tiempoFin = System.currentTimeMillis();
                    long tiempoEjecucion = tiempoFin - tiempoInicio;
                    
                    UtilesControlador.ShellSort(mtp.getPersonasTabla(), OrdenSeleccionado(), Campo);
                    mtp.fireTableDataChanged();
                    
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucion + " ms");
                    JOptionPane.showMessageDialog(null, "Tiempo de ejecución: " + tiempoEjecucion + " ms");
                    break;
                    
                case "Quicksort":
                    long tiempoInicioQ = System.currentTimeMillis();
                    
                    UtilesControlador.QuickSort(personaControlDao.all(), OrdenSeleccionado(), Campo);
                    
                    System.out.println("LISTA ORDENADA MEDIANTE QuickSort");
                    System.out.println("CAMPO DE ORDENAMIENTO: "+Campo+" METODO DE ORDENAMIENTO: "+Metodo);
                    System.out.println(UtilesControlador.QuickSort(personaControlDao.all(), OrdenSeleccionadoq(), Campo));
                    
                    long tiempoFinQ = System.currentTimeMillis();
                    long tiempoEjecucionQ = tiempoFinQ - tiempoInicioQ;
                    
                    UtilesControlador.QuickSort(mtp.getPersonasTabla(), OrdenSeleccionadoq(), Campo);
                    mtp.fireTableDataChanged();
                    
                    System.out.println("Tiempo de ejecución: " + tiempoEjecucionQ + " ms");
                    JOptionPane.showMessageDialog(null, "Tiempo de ejecución: " + tiempoEjecucionQ + " ms");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Método de ordenamiento no válido");
            }
        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Integer IdPersona = personaControlDao.getListaPersonas().getLongitud();
        JOptionPane.showMessageDialog(null, "Total divorsiados = "+mtp.contarPersonasPorEstadoCivil(4,"Divorsiado")+"\nTotal separados = "+mtp.contarPersonasPorEstadoCivil(4, "Separado"));
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxCampoOrden;
    private javax.swing.JComboBox<String> cbxCensador;
    private javax.swing.JComboBox<String> cbxEstadoCivil;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxMetodo;
    private javax.swing.JComboBox<String> cbxOrden;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEstadoEmocional;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
