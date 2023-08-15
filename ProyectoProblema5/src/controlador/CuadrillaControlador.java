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
import modelo.Cuadrilla;


public class CuadrillaControlador {
    
     
    
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
    public ArrayList <Cuadrilla> consultarEmp(){
       Conexion conn = new Conexion();
       conn.conectar();
       ResultSet resul = null;
       ArrayList<Cuadrilla> Cuadrillas = new ArrayList<>();
       
       try{
           resul = conn.consultarReg("SELECT * FROM `cuadrilla`");
           
            while (resul.next()){
               Cuadrilla cuadrilla = new Cuadrilla();
                              
               System.out.println(resul.getInt("idEmpleado"));
               System.out.println(resul.getString("departamento"));
               
               cuadrilla.setDepartamento(resul.getString("departamento"));                                        
                
               Cuadrillas.add(cuadrilla);               
           }
       }catch (Exception e){
           System.out.println(e);
       }finally{
           conn.desconectar();
       }
       return Cuadrillas;
   }
    
    //Crear usuario
    public boolean crearUsuario (Cuadrilla cuadrilla){
        boolean flag3 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try{
            int res = conn.ejecutarSentenciaSQL("INSERT INTO `cuadrilla`(`idEmpleado`,`departamento`) VALUES ((SELECT MAX(`IdEmpleado`)FROM `empleado`),'"+cuadrilla.getDepartamento()+"')" );
        
            if (res==1){
                System.out.println("Guardado con exito");
                flag3 = true;
            }            
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag3;
    }
    
    //Eliminar usuario
    public boolean eliminarUsuario(int idEmpleado){
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            int res = conn.ejecutarSentenciaSQL("DELETE FROM `cuadrilla` WHERE `cuadrilla`.`idEmpleado` = "+idEmpleado+";");
             
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
    public boolean editarUsuario(Cuadrilla cuadrilla){
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        int res = conn.ejecutarSentenciaSQL("UPDATE `cuadrilla` SET `departamento` = '"+cuadrilla.getDepartamento()+"'WHERE `cuadrilla`.`idEmpleado` = "+cuadrilla.getIdEmpleado()+";");
        
        if (res==1){
            System.out.println("Actualizado con exito");
            flag = true; 
        }
        return flag;  
    }          
    //Consultar empleado 
    public Cuadrilla consultarEmpleadoid(int IdEmpleado)  throws SQLException{
        ResultSet resul;
        Cuadrilla cuadrilla = new Cuadrilla();
        Conexion conn = new Conexion();
        conn.conectar();
        
        
        try {
            resul = conn.consultarReg("SELECT * FROM `cuadrilla` WHERE `cuadrilla`.`IdEmpleado` = "+IdEmpleado+";");
                        
            while (resul.next()){
                //cuadrilla.setIdEmpleado(resul.getInt("idEmpleado"));
                cuadrilla.setDepartamento(resul.getString("departamento")); 
            }
        }catch (Exception e){
            System.out.println(e);        
        }finally{
            conn.desconectar();
        }
        return cuadrilla;
    }
}
