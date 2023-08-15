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
import modelo.Facturador;

public class FacturadorControlador {
    
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
    public ArrayList <Facturador> consultarEmp(){
       Conexion conn = new Conexion();
       conn.conectar();
       ResultSet resul = null;
       ArrayList<Facturador> Facturadores = new ArrayList<>();
       
       try{
           resul = conn.consultarReg("SELECT * FROM `cuadrilla`");
           
            while (resul.next()){
               Facturador facturador = new Facturador();
                              
               System.out.println(resul.getInt("idEmpleado"));
               System.out.println(resul.getString("areaAsignada"));
               
               facturador.setAreaAsignada(resul.getString("areaAsignada"));                                        
                
               Facturadores.add(facturador);               
           }
       }catch (Exception e){
           System.out.println(e);
       }finally{
           conn.desconectar();
       }
       return Facturadores;
   }
    
    //Crear usuario
    public boolean crearUsuario (Facturador facturador){
        boolean flag3 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try{
            int res = conn.ejecutarSentenciaSQL("INSERT INTO `facturadores`(`idEmpleado`,`areaAsignada`) VALUES ((SELECT MAX(`IdEmpleado`)FROM `empleado`),'"+facturador.getAreaAsignada()+"')" );
        
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
            int res = conn.ejecutarSentenciaSQL("DELETE FROM `facturadores` WHERE `facturadores`.`idEmpleado` = "+idEmpleado+";");
             
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
    public boolean editarUsuario(Facturador facturador){
        boolean flag3 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        int res = conn.ejecutarSentenciaSQL("UPDATE `facturadores` SET `areaAsignada` = '"+facturador.getAreaAsignada()+"'WHERE `facturadores`.`idEmpleado` = "+facturador.getIdEmpleado()+";");
        
        if (res==1){
            System.out.println("Actualizado con exito");
            flag3 = true; 
        }
        return flag3;   
    }          
    //Consultar empleado 
    public Empleado consultarEmpleadoid(int IdEmpleado)  throws SQLException{
        ResultSet resul;
        Facturador facturador = new Facturador();
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            resul = conn.consultarReg("SELECT * FROM `facturadores` WHERE `facturadores`.`IdEmpleado` = "+IdEmpleado+";");
                        
            while (resul.next()){                
                facturador.setAreaAsignada(resul.getString("areaAsignada")); 
            }
        }catch (Exception e){
            System.out.println(e);        
        }finally{
            conn.desconectar();
        }
        return facturador;
    } 
}
