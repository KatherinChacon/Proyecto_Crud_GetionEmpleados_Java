/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CuadrillaControlador;
import controlador.EmpleadoControlador;
import funciones.Encoder;
import funciones.Validaciones;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cuadrilla;
import modelo.Empleado;

public class CuadrillaVista extends javax.swing.JFrame {

    private final DefaultTableModel modelo;

    private int IdEmpleado;

    public CuadrillaVista() {
        initComponents();
        this.setLocationRelativeTo(null);

        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        CuadrillaControlador cuadrillaControlador = new CuadrillaControlador();

        String[] titulosC = {"Item", "Cedula", "Nombres", "Apellidos", "Sexo", "Estado", "Dirección", "Telefono", "Correo", "Cargo", "Usuario", "Contrasena"};
        modelo = new DefaultTableModel(null, titulosC);
        tbUsuarioL.setModel(modelo);

        ArrayList<Empleado> empleado = new ArrayList<>();

        empleado = empleadoControlador.consultarEmp();
        for (int i = 0; i < empleado.size(); i++) {
            Object[] oEmp = {empleado.get(i).getIdEmpleado(), empleado.get(i).getCedula(), empleado.get(i).getNombre(), empleado.get(i).getApellido(), empleado.get(i).getSexo(), empleado.get(i).getEstado(), empleado.get(i).getDireccion(), empleado.get(i).getTelefono(), empleado.get(i).getCorreo(), empleado.get(i).getCargo(), empleado.get(i).getUsuario(), empleado.get(i).getContrasena()};
            modelo.addRow(oEmp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNombreL = new javax.swing.JTextField();
        txtApellidoL = new javax.swing.JTextField();
        txtCedulaL = new javax.swing.JTextField();
        txtSexoL = new javax.swing.JTextField();
        txtEstadoL = new javax.swing.JTextField();
        txtDireccionL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtCorreoL = new javax.swing.JTextField();
        txtTelefonoL = new javax.swing.JTextField();
        txtCargoL = new javax.swing.JTextField();
        txtDepartamentoL = new javax.swing.JTextField();
        txtUsuarioL = new javax.swing.JTextField();
        txtContrasenaL = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegresarL = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnCrearL = new javax.swing.JButton();
        btnActulizarL = new javax.swing.JButton();
        btnConsultarL = new javax.swing.JButton();
        btnEliminarL = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarioL = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Cedula:");

        jLabel5.setText("Sexo:");

        jLabel6.setText("Estado Civil:");

        jLabel7.setText("Dirección:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreL)
                    .addComponent(txtApellidoL)
                    .addComponent(txtCedulaL)
                    .addComponent(txtSexoL)
                    .addComponent(txtEstadoL)
                    .addComponent(txtDireccionL, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtNombreL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedulaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSexoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstadoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Telefono:");

        jLabel9.setText("Correo:");

        jLabel10.setText("Cargo:");

        jLabel11.setText("Departamento:");

        jLabel13.setText("Usuario:");

        jLabel14.setText("Contraseña:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtContrasenaL, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(txtUsuarioL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(txtDepartamentoL)
                    .addComponent(txtCargoL, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoL, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTelefonoL, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTelefonoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartamentoL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuarioL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gestión Empleados Cuadrilla");
        jLabel1.setToolTipText("");

        btnRegresarL.setText("Regresar");
        btnRegresarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarLActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCrearL.setBackground(new java.awt.Color(240, 240, 240));
        btnCrearL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCrearL.setText("Crear");
        btnCrearL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearLActionPerformed(evt);
            }
        });

        btnActulizarL.setBackground(new java.awt.Color(240, 240, 240));
        btnActulizarL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnActulizarL.setText("Actualizar");
        btnActulizarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActulizarLActionPerformed(evt);
            }
        });

        btnConsultarL.setBackground(new java.awt.Color(240, 240, 240));
        btnConsultarL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnConsultarL.setText("Consultar");
        btnConsultarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarLActionPerformed(evt);
            }
        });

        btnEliminarL.setBackground(new java.awt.Color(240, 240, 240));
        btnEliminarL.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnEliminarL.setText("Eliminar");
        btnEliminarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCrearL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActulizarL)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarL)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarL, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearL)
                    .addComponent(btnActulizarL)
                    .addComponent(btnConsultarL)
                    .addComponent(btnEliminarL))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tbUsuarioL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Cedula", "Sexo", "EstadoCivil", "Dirección", "Telefono", "Correo", "Cargo", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(tbUsuarioL);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cuadrilla.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/LogoImportant.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Nota!");

        jLabel22.setText("En esta vista solo puede Consultar");

        jLabel21.setText("empleados con Cargo Cuadrilla");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/LogoRecordar.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("Recordar!");

        jLabel18.setText("En el campo Departamento determine según aplique:");

        jLabel19.setText("Acueducto, alcantarillado o recolector basuras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnRegresarL))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jLabel17))
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(jLabel24))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarL)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addGap(28, 28, 28))
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setIdEmpleado(int idE) throws SQLException {
        this.IdEmpleado = idE;
        mapearEmpleado();
    }

    private void mapearEmpleado() throws SQLException {
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Empleado empleado = new Empleado();
        empleado = empleadoControlador.consultarEmpleadoid(this.IdEmpleado);

        CuadrillaControlador cuadrillaControlador = new CuadrillaControlador();
        Cuadrilla cuadrilla = new Cuadrilla();
        cuadrilla = cuadrillaControlador.consultarEmpleadoid(this.IdEmpleado);

        int cedula = Integer.valueOf(empleado.getCedula());

        txtNombreL.setText(empleado.getNombre());
        txtApellidoL.setText(empleado.getApellido());
        txtCedulaL.setText(String.valueOf(cedula));
        txtSexoL.setText(empleado.getSexo());
        txtEstadoL.setText(empleado.getEstado());
        txtDireccionL.setText(empleado.getDireccion());
        txtTelefonoL.setText(empleado.getTelefono());
        txtCorreoL.setText(empleado.getCorreo());
        txtCargoL.setText(empleado.getCargo());
        txtUsuarioL.setText(empleado.getUsuario());
        txtContrasenaL.setText(empleado.getContrasena());
        txtDepartamentoL.setText(cuadrilla.getDepartamento());
    }

    private void btnRegresarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarLActionPerformed
        TipoEmpleadoVista tipoEmpleadoVista = new TipoEmpleadoVista();
        tipoEmpleadoVista.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarLActionPerformed

    private void btnCrearLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearLActionPerformed
        Validaciones validaciones = new Validaciones();
        Encoder encoder = new Encoder();

        try {
            if (!txtNombreL.getText().trim().equals("") && !txtApellidoL.getText().trim().equals("") && !txtTelefonoL.getText().trim().equals("")
                    && !txtSexoL.getText().trim().equals("") && !txtEstadoL.getText().trim().equals("") && !txtDireccionL.getText().trim().equals("")
                    && !txtCargoL.getText().trim().equals("") && !txtUsuarioL.getText().trim().equals("") && !txtContrasenaL.getText().trim().equals("")
                    && !txtDepartamentoL.getText().trim().equals("")) {

                if (validaciones.ValidarEmail(txtCorreoL.getText())) {

                    if (txtTelefonoL.getText().length() >= 7){

                        Empleado empleado = new Empleado();

                        EmpleadoControlador empleadoControlador = new EmpleadoControlador();

                        empleado.setNombre(txtNombreL.getText());
                        empleado.setApellido(txtApellidoL.getText());
                        empleado.setCedula(Integer.parseInt(txtCedulaL.getText()));
                        empleado.setSexo(txtSexoL.getText());
                        empleado.setEstado(txtEstadoL.getText());
                        empleado.setDireccion(txtDireccionL.getText());
                        empleado.setTelefono(txtTelefonoL.getText());
                        empleado.setCorreo(txtCorreoL.getText());
                        empleado.setCargo(txtCargoL.getText());
                        empleado.setUsuario(txtUsuarioL.getText());
                        empleado.setContrasena(encoder.encrypt(txtContrasenaL.getText()));

                        Cuadrilla cuadrilla = new Cuadrilla();

                        CuadrillaControlador cuadrillaControlador = new CuadrillaControlador();

                        cuadrilla.setDepartamento(txtDepartamentoL.getText());

                        boolean flag = empleadoControlador.crearUsuario(empleado);
                        if (flag) {
                            JOptionPane.showMessageDialog(null, "Usuario creado con Exito");
                            CuadrillaVista cuadrillaVista = new CuadrillaVista();
                            cuadrillaVista.setVisible(true);
                            this.dispose();
                        }

                        boolean flag3 = cuadrillaControlador.crearUsuario(cuadrilla);
                        if (flag3) {
                            CuadrillaVista cuadrillaVista = new CuadrillaVista();
                            cuadrillaVista.setVisible(true);
                            this.dispose();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El telefono debe tener minimo 7 digitos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Correo debe tener un formato (ejemplo@xxxx.xx)");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Diligencia todos los campos");
            }
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrearLActionPerformed

    private void btnEliminarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLActionPerformed

        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        CuadrillaControlador cuadrillaControlador = new CuadrillaControlador();

        boolean flag = empleadoControlador.eliminarUsuario(Integer.parseInt(tbUsuarioL.getValueAt(tbUsuarioL.getSelectedRow(), 0).toString()));

        boolean flag3 = cuadrillaControlador.eliminarUsuario(Integer.parseInt(tbUsuarioL.getValueAt(tbUsuarioL.getSelectedRow(), 0).toString()));

        if (flag) {
            System.out.println("Borrado con exito");
            JOptionPane.showMessageDialog(null, "Usuario borrado con exito");
            int count = modelo.getRowCount();
            for (int i = 0; i < count; i++) {
                modelo.removeRow(0);
            }
        }

        ArrayList<Empleado> empleado = new ArrayList<>();

        empleado = empleadoControlador.consultarEmp();
        for (int i = 0; i < empleado.size(); i++) {
            Object[] oEmp = {empleado.get(i).getIdEmpleado(), empleado.get(i).getCedula(), empleado.get(i).getNombre(), empleado.get(i).getApellido(), empleado.get(i).getSexo(), empleado.get(i).getEstado(), empleado.get(i).getDireccion(), empleado.get(i).getTelefono(), empleado.get(i).getCorreo(), empleado.get(i).getCargo(), empleado.get(i).getUsuario(), empleado.get(i).getContrasena()};
            modelo.addRow(oEmp);
        }
    }//GEN-LAST:event_btnEliminarLActionPerformed

    private void btnActulizarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActulizarLActionPerformed
        Empleado empleado = new Empleado();
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();

        Cuadrilla cuadrilla = new Cuadrilla();
        CuadrillaControlador cuadrillaControlador = new CuadrillaControlador();

        empleado.setIdEmpleado(this.IdEmpleado);
        empleado.setNombre(txtNombreL.getText());
        empleado.setApellido(txtApellidoL.getText());
        empleado.setCedula(Integer.parseInt(txtCedulaL.getText()));
        empleado.setSexo(txtSexoL.getText());
        empleado.setEstado(txtEstadoL.getText());
        empleado.setDireccion(txtDireccionL.getText());
        empleado.setTelefono(txtTelefonoL.getText());
        empleado.setCorreo(txtCorreoL.getText());
        empleado.setCargo(txtCargoL.getText());
        empleado.setUsuario(txtUsuarioL.getText());
        empleado.setContrasena(txtContrasenaL.getText());
        cuadrilla.setIdEmpleado(this.IdEmpleado);
        cuadrilla.setDepartamento(txtDepartamentoL.getText());

        boolean flag = empleadoControlador.editarUsuario(empleado);
        if (flag) {
            JOptionPane.showMessageDialog(null, "Usuario Actualiado con Exito");
            CuadrillaVista cuadrillaVista = new CuadrillaVista();
            cuadrillaVista.setVisible(true);
            this.dispose();
        }

        boolean flag3 = cuadrillaControlador.editarUsuario(cuadrilla);
        if (flag3) {
            CuadrillaVista cuadrillaVista = new CuadrillaVista();
            cuadrillaVista.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnActulizarLActionPerformed

    private void btnConsultarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarLActionPerformed

        if (tbUsuarioL.getSelectedRowCount() > 0) {
            CuadrillaVista cuadrillaVista;
            try {
                cuadrillaVista = new CuadrillaVista();
                int IdEmpleado = Integer.parseInt(tbUsuarioL.getValueAt(tbUsuarioL.getSelectedRow(), 0).toString());
                cuadrillaVista.setIdEmpleado(IdEmpleado);
                cuadrillaVista.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(TipoEmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe selecionar un empleado de la tabla");
        }
    }//GEN-LAST:event_btnConsultarLActionPerformed

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
            java.util.logging.Logger.getLogger(CuadrillaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuadrillaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuadrillaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuadrillaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuadrillaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActulizarL;
    private javax.swing.JButton btnConsultarL;
    private javax.swing.JButton btnCrearL;
    private javax.swing.JButton btnEliminarL;
    private javax.swing.JButton btnRegresarL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarioL;
    private javax.swing.JTextField txtApellidoL;
    private javax.swing.JTextField txtCargoL;
    private javax.swing.JTextField txtCedulaL;
    private javax.swing.JTextField txtContrasenaL;
    private javax.swing.JTextField txtCorreoL;
    private javax.swing.JTextField txtDepartamentoL;
    private javax.swing.JTextField txtDireccionL;
    private javax.swing.JTextField txtEstadoL;
    private javax.swing.JTextField txtNombreL;
    private javax.swing.JTextField txtSexoL;
    private javax.swing.JTextField txtTelefonoL;
    private javax.swing.JTextField txtUsuarioL;
    // End of variables declaration//GEN-END:variables

}
