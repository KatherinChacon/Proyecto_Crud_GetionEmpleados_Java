/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CoordinadorControlador;
import controlador.EmpleadoControlador;
import funciones.Encoder;
import funciones.Validaciones;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Coordinador;
import modelo.Empleado;

public class CoordinadorVista extends javax.swing.JFrame {

    DefaultTableModel modelo;

    private int IdEmpleado;

    public CoordinadorVista() {
        initComponents();
        this.setLocationRelativeTo(null);

        String[] titulosC = {"Item", "Cedula", "Nombres", "Apellidos", "Sexo", "Estado", "Dirección", "Telefono", "Correo", "Cargo", "Usuario", "Contrasena"};
        modelo = new DefaultTableModel(null, titulosC);
        tbUsuarioC.setModel(modelo);

        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        CoordinadorControlador coordinadorControlador = new CoordinadorControlador();

        ArrayList<Empleado> empleado = new ArrayList<>();

        empleado = empleadoControlador.consultarEmp();
        for (int i = 0; i < empleado.size(); i++) {
            Object[] oEmp = {empleado.get(i).getIdEmpleado(), empleado.get(i).getCedula(), empleado.get(i).getNombre(), empleado.get(i).getApellido(), empleado.get(i).getSexo(), empleado.get(i).getEstado(), empleado.get(i).getDireccion(), empleado.get(i).getTelefono(), empleado.get(i).getCorreo(), empleado.get(i).getCargo(), empleado.get(i).getUsuario(), empleado.get(i).getContrasena()};
            modelo.addRow(oEmp);
        }
    }

    @SuppressWarnings("unchecked")

    public void setIdEmpleado(int idE) throws SQLException {
        this.IdEmpleado = idE;
        mapearEmpleado();
    }

    private void mapearEmpleado() throws SQLException {
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Empleado empleado = new Empleado();
        empleado = empleadoControlador.consultarEmpleadoid(this.IdEmpleado);

        CoordinadorControlador coordinadorControlador = new CoordinadorControlador();
        Coordinador coordinador = new Coordinador();
        coordinador = (Coordinador) coordinadorControlador.consultarEmpleadoid(this.IdEmpleado);

        int cedula = Integer.valueOf(empleado.getCedula());

        Date fechaIncorporacion = coordinador.getFechaIncorporacion();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIncorporacionstr = formato.format(fechaIncorporacion);

        txtNombreC.setText(empleado.getNombre());
        txtApellidoC.setText(empleado.getApellido());
        txtCedulaC.setText(String.valueOf(cedula));
        txtSexoC.setText(empleado.getSexo());
        txtEstadoC.setText(empleado.getEstado());
        txtDireccionC.setText(empleado.getDireccion());
        txtTelefonoC.setText(empleado.getTelefono());
        txtCorreoC.setText(empleado.getCorreo());
        txtCargoC.setText(empleado.getCargo());
        txtUsuarioC.setText(empleado.getUsuario());
        txtContrasenaC.setText(empleado.getContrasena());
        txtFechaC.setText(fechaIncorporacionstr);
        txtAreaC.setText(coordinador.getAreaPertenece());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCorreoC = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUsuarioC = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtContrasenaC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCargoC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFechaC = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAreaC = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCedulaC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSexoC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEstadoC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccionC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefonoC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarioC = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCrearC = new java.awt.Button();
        btnActualizarC = new java.awt.Button();
        btnConsultarC = new java.awt.Button();
        btnEliminarC = new java.awt.Button();
        jLabel11 = new javax.swing.JLabel();
        btnRegresarC = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));
        jPanel2.setName(""); // NOI18N

        jLabel9.setText("Correo:");

        jLabel13.setText("Usuario:");

        txtUsuarioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioCActionPerformed(evt);
            }
        });

        jLabel19.setText("Contraseña:");

        jLabel20.setText("Cargo:");

        jLabel8.setText("Fecha ");
        jLabel8.setToolTipText("");

        jLabel12.setText("Incorporación:");

        jLabel14.setText("Area");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContrasenaC, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel20)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreoC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCargoC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuarioC)
                            .addComponent(txtAreaC, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCorreoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtCargoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12))
                    .addComponent(txtFechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtAreaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtUsuarioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(39, 39, 39))
        );

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellidos:");

        jLabel7.setText("Cedula:");

        jLabel3.setText("Sexo:");

        jLabel4.setText("Estado Civil:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Telefono:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEstadoC, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(txtSexoC)
                                .addComponent(txtCedulaC)
                                .addComponent(txtApellidoC)
                                .addComponent(txtNombreC)))
                        .addComponent(jLabel3)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionC)
                            .addComponent(txtTelefonoC))))
                .addGap(6, 6, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSexoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tbUsuarioC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Apellidos", "Cedula", "Sexo", "EstadoCivil", "Dirección", "Telefono", "Correo", "Cargo", "FechaIncorporación", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(tbUsuarioC);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Gestión Empleados Coordinador");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCrearC.setLabel("Crear");
        btnCrearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCActionPerformed(evt);
            }
        });

        btnActualizarC.setLabel("Actualizar");
        btnActualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCActionPerformed(evt);
            }
        });

        btnConsultarC.setLabel("Consultar");
        btnConsultarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarCActionPerformed(evt);
            }
        });

        btnEliminarC.setLabel("Eliminar");
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnActualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnConsultarC, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnRegresarC.setText("Regresar");
        btnRegresarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarCActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Administrador.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/LogoRecordar.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Nota!");

        jLabel18.setText("En el campo Area determine según aplique:");

        jLabel21.setText("empleados con Cargo Coordinador");

        jLabel22.setText("En esta vista solo puede Consultar");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/LogoImportant.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("Recordar!");

        jLabel25.setText("Almacén, facturadores cuadrilla, administrativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresarC)
                                .addGap(205, 205, 205)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel25))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(jLabel24))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(jLabel17))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnRegresarC)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(293, 293, 293))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel21)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCActionPerformed
        Validaciones validaciones = new Validaciones();
        Encoder encoder = new Encoder();
        try {
            if (!txtNombreC.getText().trim().equals("") && !txtApellidoC.getText().trim().equals("") && !txtTelefonoC.getText().trim().equals("")
                    && !txtSexoC.getText().trim().equals("") && !txtEstadoC.getText().trim().equals("") && !txtDireccionC.getText().trim().equals("")
                    && !txtCargoC.getText().trim().equals("") && !txtUsuarioC.getText().trim().equals("") && !txtContrasenaC.getText().trim().equals("")
                    && !txtFechaC.getText().trim().equals("") && !txtAreaC.getText().trim().equals("")) {

                if (validaciones.ValidarEmail(txtCorreoC.getText())) { 
                   
                    if (txtTelefonoC.getText().length() >= 7){

                        Empleado empleado = new Empleado();

                        EmpleadoControlador empleadoControlador = new EmpleadoControlador();

                        empleado.setNombre(txtNombreC.getText());
                        empleado.setApellido(txtApellidoC.getText());
                        empleado.setCedula(Integer.parseInt(txtCedulaC.getText()));
                        empleado.setSexo(txtSexoC.getText());
                        empleado.setEstado(txtEstadoC.getText());
                        empleado.setDireccion(txtDireccionC.getText());
                        empleado.setTelefono(txtTelefonoC.getText());
                        empleado.setCorreo(txtCorreoC.getText());
                        empleado.setCargo(txtCargoC.getText());
                        empleado.setUsuario(txtUsuarioC.getText());
                        empleado.setContrasena(encoder.encrypt(txtContrasenaC.getText()));

                        Coordinador coordinador = new Coordinador();

                        CoordinadorControlador coordinadorControlador = new CoordinadorControlador();

                        String fechaIncorporacionStr = txtFechaC.getText();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                        coordinador.setFechaIncorporacion(formato.parse(fechaIncorporacionStr));
                        coordinador.setAreaPertenece(txtAreaC.getText());

                        boolean flag = empleadoControlador.crearUsuario(empleado);
                        if (flag) {
                            JOptionPane.showMessageDialog(null, "Usuario creado con Exito");
                            CoordinadorVista coordinadorVista = new CoordinadorVista();
                            coordinadorVista.setVisible(true);
                            this.dispose();
                        }

                        boolean flag1 = coordinadorControlador.crearUsuario(coordinador);
                        if (flag1) {
                            CoordinadorVista coordinadorVista = new CoordinadorVista();
                            coordinadorVista.setVisible(true);
                            this.dispose();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El telefono debe tener minimo 7 digitos");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "El Correo debe tener un formato (ejemplo@xxxx.xx)");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Diligencia todos los campos");
            }
        } catch (ParseException ex) {
            Logger.getLogger(CoordinadorVista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrearCActionPerformed

    private void btnRegresarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCActionPerformed
        TipoEmpleadoVista tipoEmpleadoVista = new TipoEmpleadoVista();
        tipoEmpleadoVista.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarCActionPerformed

    private void btnActualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCActionPerformed
        try {
            Empleado empleado = new Empleado();
            EmpleadoControlador empleadoControlador = new EmpleadoControlador();
            Coordinador coordinador = new Coordinador();
            CoordinadorControlador coordinadorControlador = new CoordinadorControlador();

            empleado.setIdEmpleado(this.IdEmpleado);
            empleado.setNombre(txtNombreC.getText());
            empleado.setApellido(txtApellidoC.getText());
            empleado.setCedula(Integer.parseInt(txtCedulaC.getText()));
            empleado.setSexo(txtSexoC.getText());
            empleado.setEstado(txtEstadoC.getText());
            empleado.setDireccion(txtDireccionC.getText());
            empleado.setTelefono(txtTelefonoC.getText());
            empleado.setCorreo(txtCorreoC.getText());
            empleado.setCargo(txtCargoC.getText());
            empleado.setUsuario(txtUsuarioC.getText());
            empleado.setContrasena(txtContrasenaC.getText());

            coordinador.setIdEmpleado(this.IdEmpleado);
            String fechaIncorporacionStr = txtFechaC.getText();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            coordinador.setFechaIncorporacion(formato.parse(fechaIncorporacionStr));
            coordinador.setAreaPertenece(txtAreaC.getText());

            boolean flag = empleadoControlador.editarUsuario(empleado);
            if (flag) {
                JOptionPane.showMessageDialog(null, "Usuario Actualiado con Exito");
                CoordinadorVista coordinadorVista = new CoordinadorVista();
                coordinadorVista.setVisible(true);
                this.dispose();
            }

            boolean flag1 = coordinadorControlador.editarUsuario(coordinador);
            if (flag1) {
                CoordinadorVista coordinadorVista = new CoordinadorVista();
                coordinadorVista.setVisible(true);
                this.dispose();
            }
        } catch (ParseException ex) {
            Logger.getLogger(CoordinadorVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnActualizarCActionPerformed

    private void btnConsultarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarCActionPerformed
        if (tbUsuarioC.getSelectedRowCount() > 0) {
            CoordinadorVista coordinadorVista;
            try {
                coordinadorVista = new CoordinadorVista();
                int IdEmpleado = Integer.parseInt(tbUsuarioC.getValueAt(tbUsuarioC.getSelectedRow(), 0).toString());
                coordinadorVista.setIdEmpleado(IdEmpleado);
                coordinadorVista.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(TipoEmpleadoVista.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debe selecionar un empleado de la tabla");
        }
    }//GEN-LAST:event_btnConsultarCActionPerformed

    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        CoordinadorControlador CoordinadorControlador = new CoordinadorControlador();

        boolean flag = empleadoControlador.eliminarUsuario(Integer.parseInt(tbUsuarioC.getValueAt(tbUsuarioC.getSelectedRow(), 0).toString()));

        boolean flag1 = CoordinadorControlador.eliminarUsuario(Integer.parseInt(tbUsuarioC.getValueAt(tbUsuarioC.getSelectedRow(), 0).toString()));

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
    }//GEN-LAST:event_btnEliminarCActionPerformed

    private void txtUsuarioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioCActionPerformed

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
            java.util.logging.Logger.getLogger(CoordinadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoordinadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoordinadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoordinadorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoordinadorVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnActualizarC;
    private java.awt.Button btnConsultarC;
    private java.awt.Button btnCrearC;
    private java.awt.Button btnEliminarC;
    private javax.swing.JButton btnRegresarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarioC;
    private javax.swing.JTextField txtApellidoC;
    private javax.swing.JTextField txtAreaC;
    private javax.swing.JTextField txtCargoC;
    private javax.swing.JTextField txtCedulaC;
    private javax.swing.JTextField txtContrasenaC;
    private javax.swing.JTextField txtCorreoC;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtEstadoC;
    private javax.swing.JTextField txtFechaC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtSexoC;
    private javax.swing.JTextField txtTelefonoC;
    private javax.swing.JTextField txtUsuarioC;
    // End of variables declaration//GEN-END:variables
}
