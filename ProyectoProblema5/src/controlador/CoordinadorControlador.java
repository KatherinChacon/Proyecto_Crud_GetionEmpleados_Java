

package controlador;

import configuracion.Conexion;
import funciones.Encoder;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Empleado;
import java.sql.SQLException;
import modelo.Coordinador;



public class CoordinadorControlador {
            
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
   public ArrayList <Coordinador> consultarEmp(){
       Conexion conn = new Conexion();
       conn.conectar();
       ResultSet resul = null;
       ArrayList<Coordinador> Coordinadores = new ArrayList<>();
       
       try{
           resul = conn.consultarReg("SELECT * FROM `coordinador`");
           
            while (resul.next()){
               Coordinador coordinador = new Coordinador();
                              
               System.out.println(resul.getInt("idEmpleado"));
               System.out.println(resul.getDate("fechaIncorporacion"));
               System.out.println(resul.getString("areaPertenece"));
               
               coordinador.setFechaIncorporacion(resul.getDate("fechaIncorporacion"));  
               coordinador.setAreaPertenece(resul.getString("areaPertenece"));
                
               Coordinadores.add(coordinador);               
           }
       }catch (Exception e){
           System.out.println(e);
       }finally{
           conn.desconectar();
       }
       return Coordinadores;
   }
    
    //Crear usuario
    public boolean crearUsuario (Coordinador coordinador){
        boolean flag1 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try{
            int res = conn.ejecutarSentenciaSQL("INSERT INTO `coordinador`(`idEmpleado`,`fechaIncorporacion`,`areaPertenece`) VALUES ((SELECT MAX(`IdEmpleado`)FROM `empleado`),STR_TO_dATE('"+coordinador.getFechaIncorporacion()+"','%a %b %e %H:%i:%s COT %Y'),'"+coordinador.getAreaPertenece()+"')");
        
            if (res==1){
                System.out.println("Guardado con exito");
                flag1 = true;
            }            
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag1;
    }
    
    //Eliminar usuario
    public boolean eliminarUsuario(int idEmpleado){
        boolean flag1 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            int res = conn.ejecutarSentenciaSQL("DELETE FROM `coordinador` WHERE `coordinador`.`idEmpleado` = "+idEmpleado+";");
             
            if (res==1){
                System.out.println("Borrado con exito");
                flag1 = true;
            }         
        }catch (Exception e){
           System.out.println(e);
        }finally{
           conn.desconectar();
        }
        return flag1;       
    }
    
    //Editar usuario
    public boolean editarUsuario(Coordinador coordinador){
        boolean flag1 = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        int res = conn.ejecutarSentenciaSQL("UPDATE `coordinador` SET `fechaIncorporacion` = STR_TO_DATE('"+coordinador.getFechaIncorporacion()+"','%a %b %d %T COT %Y'),`areaPertenece`= '"+coordinador.getAreaPertenece()+"'WHERE `coordinador`.`idEmpleado` = "+coordinador.getIdEmpleado()+";");
        
        if (res==1){
            System.out.println("Actualizado con exito");
            flag1 = true; 
        }
        return flag1;
    }          
    //Consultar empleado 
    public Empleado consultarEmpleadoid(int IdEmpleado)  throws SQLException{
        ResultSet resul;
        Coordinador coordinador = new Coordinador();
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {
            resul = conn.consultarReg("SELECT * FROM `coordinador` WHERE `coordinador`.`IdEmpleado` = "+IdEmpleado+";");
                        
            while (resul.next()){
                //cuadrilla.setIdEmpleado(resul.getInt("idEmpleado"));
                coordinador.setFechaIncorporacion(resul.getDate("fechaIncorporacion"));
                coordinador.setAreaPertenece(resul.getString("areaPertenece"));
            }
        }catch (Exception e){
            System.out.println(e);        
        }finally{
            conn.desconectar();
        }
        return coordinador;
    }
}
