/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import funciones.Encoder;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Empleado;
import java.sql.SQLException;



public class EmpleadoControlador {
    
    public ArrayList consultarEmpleado(){
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList empleados = new ArrayList<>();
        try{
            resul = conn.consultarReg("SELECT * FROM empleado");
            while (resul.next()){
                Empleado empleado = new Empleado();
                empleado.setCedula(resul.getInt("cedula"));
                empleado.setNombre(resul.getString("nombres"));
                empleado.setApellido(resul.getString("apellidos"));
                empleado.setSexo(resul.getString("sexo"));
                empleado.setEstado(resul.getString("estadoCivil"));
                empleado.setDireccion(resul.getString("dirección"));
                empleado.setTelefono(resul.getString("telefono"));
                empleado.setCorreo(resul.getString("correo"));
                empleado.setCargo(resul.getString("cargo"));
                empleados.add(empleado);
            }
        }catch(Exception e){
        System.out.println(e);
        }finally{
        conn.desconectar();
        }
        return empleados;    
    }
    
    //Consultar empleado
    public Empleado consultarId(int cedula) throws SQLException{
        ResultSet resul;
        Empleado empleado = new Empleado();
        Conexion conn = new Conexion();
        conn.conectar();
        try{
            resul = conn.consultarReg("SELECT * FROM empleado WHERE empleado.cedula =" +cedula+";");
            while (resul.next()){                
                empleado.setCedula(resul.getInt("cedula"));
                empleado.setNombre(resul.getString("nombres"));
                empleado.setApellido(resul.getString("apellidos"));
                empleado.setSexo(resul.getString("sexo"));
                empleado.setEstado(resul.getString("estadoCivil"));
                empleado.setDireccion(resul.getString("dirección"));
                empleado.setTelefono(resul.getString("telefono"));
                empleado.setCorreo(resul.getString("correo"));
                empleado.setCargo(resul.getString("cargo"));            
            }        
        }catch (Exception e){
            System.out.println(e);            
        }finally{
            conn.desconectar();
        }
        return empleado;
    }
    
    //Validar usuario admin
    public boolean validarUsuario (String usuario, String contrasena){
        Encoder encoder = new Encoder();
        Conexion conn = new Conexion();
        conn.conectar();
        String claveD;
        boolean flag = false;
        
        try{
            ResultSet resul = conn.consultarReg("SELECT usuario, contrasena FROM empleado WHERE cargo='admin'");
            while (resul.next()){
                System.out.println(resul.getString("usuario"));
                claveD = encoder.decrypt(resul.getString("contrasena"));
                System.out.print(claveD);
                System.out.println(usuario);
                System.out.println(contrasena);
                if (usuario.equals(resul.getString("usuario"))&& contrasena.equals(resul.getString("contrasena")))
                {
                    flag = true;
                }                
            }
        }catch (Exception e){
            System.out.println(e);
        }finally{
            conn.desconectar();
        }
        return flag;    
    }
    
    // Consultar usuario
    public ArrayList <Empleado> consultarEmp(){
       Conexion conn = new Conexion();
       conn.conectar();
       ResultSet resul = null;
       ArrayList<Empleado> usuarios = new ArrayList<>();
       
       try{
           resul = conn.consultarReg("SELECT * FROM Empleado");
           while (resul.next()){
               Empleado empleado = new Empleado();
               
               System.out.println(resul.getInt("IdEmpleado"));
               System.out.println(resul.getInt("cedula"));
               System.out.println(resul.getString("nombres"));
               System.out.println(resul.getString("apellidos"));
               System.out.println(resul.getString("sexo"));
               System.out.println(resul.getString("estadoCivil"));
               System.out.println(resul.getString("dirección"));
               System.out.println(resul.getString("telefono"));
               System.out.println(resul.getString("correo"));
               System.out.println(resul.getString("cargo"));
               System.out.println(resul.getString("usuario"));
               System.out.println(resul.getString("contrasena"));
               
               empleado.setIdEmpleado(resul.getInt("IdEmpleado"));
               empleado.setCedula(resul.getInt("cedula"));
               empleado.setNombre(resul.getString("nombres"));
               empleado.setApellido(resul.getString("apellidos"));
               empleado.setSexo(resul.getString("sexo"));
               empleado.setEstado(resul.getString("estadoCivil"));
               empleado.setDireccion(resul.getString("dirección"));
               empleado.setTelefono(resul.getString("telefono"));
               empleado.setCorreo(resul.getString("correo"));
               empleado.setCargo(resul.getString("cargo"));
               empleado.setUsuario(resul.getString("usuario"));
               empleado.setContrasena(resul.getString("contrasena"));
               
               
               usuarios.add(empleado);               
           }
       }catch (Exception e){
           System.out.println(e);
       }finally{
           conn.desconectar();
       }
       return usuarios;
   }
    
    //Crear usuario
    public boolean crearUsuario (Empleado empleado){
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try{
            
            int res = conn.ejecutarSentenciaSQL("INSERT INTO `empleado` (`IdEmpleado`,`cedula`, `nombres`,`apellidos`,`sexo`,`estadoCivil`,`dirección`,`telefono`,`correo`,`cargo`,`usuario`,`contrasena`) VALUES ('"+empleado.getIdEmpleado()+"','"+empleado.getCedula()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getSexo()+"','"+empleado.getEstado()+"','"+empleado.getDireccion()+"','"+empleado.getTelefono()+"','"+empleado.getCorreo()+"','"+empleado.getCargo()+"','"+empleado.getUsuario()+"','"+empleado.getContrasena()+"')" );
        
            if (res==1){
                System.out.println("Guardado con exito");
                flag = true;
            }            
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag;
    }
    
    //Eliminar usuario
    public boolean eliminarUsuario(int IdEmpleado){
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            int res = conn.ejecutarSentenciaSQL("DELETE FROM `empleado` WHERE `empleado`.`IdEmpleado` = "+IdEmpleado+";");
             
            if (res==1){
                System.out.println("Borrado con exito");
                flag = true;
            }         
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag;        
    }
    
    //Editar usuario
    public boolean editarUsuario(Empleado empleado){
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        int res = conn.ejecutarSentenciaSQL("UPDATE `empleado` SET `cedula` = '"+empleado.getCedula()+"',"
                + "`nombres`= '"+empleado.getNombre()+"',`apellidos`= '"+empleado.getApellido()+"',"
                + "`sexo` = '"+empleado.getSexo()+"',`estadoCivil`= '"+empleado.getEstado()+"',"
                + "`dirección`='"+empleado.getDireccion()+"',`telefono`= '"+empleado.getTelefono()+"',"
                + "`correo` = '"+empleado.getCorreo()+"',`cargo` = '"+empleado.getCargo()+"'"
                + "WHERE `empleado`.`IdEmpleado` = "+empleado.getIdEmpleado()+";");
        
        if (res==1){
            System.out.println("Actualizado con exito");
            flag = true; 
        }
        return flag;  
    }          
    //Consultar empleado 
    public Empleado consultarEmpleadoid(int IdEmpleado)  throws SQLException{
        ResultSet resul;
        Empleado empleado = new Empleado();
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            resul = conn.consultarReg("SELECT * FROM `empleado` WHERE `empleado`.`IdEmpleado` = "+IdEmpleado+";");
            
            while (resul.next()){
                empleado.setCedula(resul.getInt("cedula"));
                empleado.setNombre(resul.getString("nombres"));
                empleado.setApellido(resul.getString("apellidos"));
                empleado.setSexo(resul.getString("sexo"));
                empleado.setEstado(resul.getString("estadoCivil"));
                empleado.setDireccion(resul.getString("dirección"));
                empleado.setTelefono(resul.getString("telefono"));
                empleado.setCorreo(resul.getString("correo"));
                empleado.setCargo(resul.getString("cargo"));
                empleado.setUsuario(resul.getString("usuario"));
                empleado.setContrasena(resul.getString("contrasena"));                  
            }
        }catch (Exception e){
            System.out.println(e);        
        }finally{
            conn.desconectar();
        }
        return empleado;
    }
}