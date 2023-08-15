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
import modelo.ServicioGeneral;

public class ServicioControlador {
    
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
    public ArrayList <ServicioGeneral> consultarEmp(){
       Conexion conn = new Conexion();
       conn.conectar();
       ResultSet resul = null;
       ArrayList<ServicioGeneral> Servicios = new ArrayList<>();
       
       try{
           resul = conn.consultarReg("SELECT * FROM `cuadrilla`");
           
            while (resul.next()){
               ServicioGeneral  servicioGeneral = new ServicioGeneral();
                              
               System.out.println(resul.getInt("idEmpleado"));
               System.out.println(resul.getString("departamento"));
               
               servicioGeneral.setAreaTrabajo(resul.getString("tipoServicios"));                                       
                
               Servicios.add(servicioGeneral);               
           }
       }catch (Exception e){
           System.out.println(e);
       }finally{
           conn.desconectar();
       }
       return Servicios;
   }
    
    //Crear usuario
    public boolean crearUsuario (ServicioGeneral  servicio){
        boolean flag4 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try{
            int res = conn.ejecutarSentenciaSQL("INSERT INTO `serviciosgenerales`(`idEmpleado`,`tipoServicios`) VALUES ((SELECT MAX(`IdEmpleado`)FROM `empleado`),'"+servicio.getAreaTrabajo()+"')" );
        
            if (res==1){
                System.out.println("Guardado con exito");
                flag4 = true;
            }            
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag4;
    }
    
    //Eliminar usuario
    public boolean eliminarUsuario(int idEmpleado){
        boolean flag4 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            int res = conn.ejecutarSentenciaSQL("DELETE FROM `serviciosgenerales` WHERE `serviciosgenerales`.`idEmpleado` = "+idEmpleado+";");
             
            if (res==1){
                System.out.println("Borrado con exito");
                flag4 = true;
            }         
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag4;         
    }
    
    //Editar usuario
    public boolean editarUsuario(ServicioGeneral  servicio){
        boolean flag4 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        int res = conn.ejecutarSentenciaSQL("UPDATE `serviciosgenerales` SET `tipoServicios` = '"+servicio.getAreaTrabajo()+"'WHERE `serviciosgenerales`.`idEmpleado` = "+servicio.getIdEmpleado()+";");
        
        if (res==1){
            System.out.println("Actualizado con exito");
            flag4 = true; 
        }
        return flag4;   
    }          
    //Consultar empleado 
    public Empleado consultarEmpleadoid(int IdEmpleado)  throws SQLException{
        ResultSet resul;
        ServicioGeneral servicio = new ServicioGeneral();
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            resul = conn.consultarReg("SELECT * FROM `serviciosgenerales` WHERE `serviciosgenerales`.`IdEmpleado` = "+IdEmpleado+";");
                        
            while (resul.next()){
                //cuadrilla.setIdEmpleado(resul.getInt("idEmpleado"));
                servicio.setAreaTrabajo(resul.getString("tipoServicios"));
            }
        }catch (Exception e){
            System.out.println(e);        
        }finally{
            conn.desconectar();
        }
        return servicio;
    }
    
    
}
